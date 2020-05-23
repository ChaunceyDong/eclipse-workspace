import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class GUI3test {

	public static void main(String[] args) {

		new ViewDBframe();
	}
}

class ViewDBframe extends JFrame {

	Statement stmt = null;
	JTable table = null;
	Connection con = null;
	CachedRowSet tableCurrentRS = null;
	
	public ViewDBframe() {
		setTitle("Chuanlin's DB_GUI 3.0");
		setSize(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildConnection();
		setJMenuBar(builFileMenu());
		add(buildResultViewerTable(), BorderLayout.CENTER);
		add(buildCmbBoxPanel(), BorderLayout.NORTH);
		add(buildQueryPanel(), BorderLayout.SOUTH);
//		stmtTest();
		setVisible(true);
	}

	private void stmtTest() {
		try {
			stmt.execute("use hanmei");
			int[] tempInt = new int[] { 23, 41, 21, 3, 14 };
			for (int i : tempInt) {
				stmt.execute("insert into students values(" + i + ",'test')");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private JMenuBar builFileMenu() {
		JMenuBar mnBar = new JMenuBar();
		JMenu mn = new JMenu("file");
		JMenuItem exMenu = new JMenuItem("Export");
		JMenuItem imMenu = new JMenuItem("Import");
		mn.add(imMenu);
		mn.add(exMenu);
		mnBar.add(mn);
		imMenu.addActionListener(e -> {
			JFileChooser fc = new JFileChooser();
			if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				String fileName = fc.getSelectedFile().getName().substring(0,
						fc.getSelectedFile().getName().lastIndexOf("."));
				System.out.println(fileName);
				try {
					BufferedReader fileReader = new BufferedReader(new FileReader(fc.getSelectedFile()));
					stmt.execute("use test");
					System.out.println("create table if not exists " + fileName
							+ "(id int, name char(20), major char(20), primary key (id))");
					stmt.execute("create table if not exists " + fileName
							+ "(id int, name char(20), major char(20), primary key (id))");
					String line = fileReader.readLine();
					while ((line = fileReader.readLine()) != null) {
						System.out.println(line);
						line = line.replace(",", "','");
						String sql = "insert into " + fileName + " values('" + line + "')";
						System.out.println(sql);
						stmt.execute(sql);
						fileReader.close();
					}
					queryShowTable("select * from " + fileName);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		exMenu.addActionListener(e -> {
			String filename = "/Users/joyjigsaw/test_export.csv";
			try {
				FileWriter fw = new FileWriter(filename);
				while (tableCurrentRS.next()) {
					fw.append(tableCurrentRS.getString(1));
					fw.append(',');
					fw.append(tableCurrentRS.getString(2));
					fw.append(',');
					fw.append(tableCurrentRS.getString(3));
					fw.append('\n');
				}
				fw.close();
				System.out.println("CSV File is created successfully.");
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		});
		return mnBar;
	}

	private JPanel buildQueryPanel() {
		JTextArea txtArea = new JTextArea(4, 30);

		JButton btn = new JButton("Query");
		btn.addActionListener(e -> {
			String sql = txtArea.getText();
			queryShowTable(sql);
		});

		JPanel panel = new JPanel();
		panel.add(txtArea);
		panel.add(btn);
		return panel;
	}

	private JScrollPane buildResultViewerTable() {
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent e) {
				int[] cols = table.getSelectedColumns();
				int[] rows = table.getSelectedRows();
				double[] data = new double[rows.length];
				for (int i = 0; i < data.length; ++i) {
					data[i] = Double.valueOf(table.getValueAt(rows[i], cols[0]).toString());
				}
				System.out.println(Arrays.toString(data));
				DBTrendDlg pltDlg = new DBTrendDlg(data);
				pltDlg.setVisible(true);

			}
		});

		return new JScrollPane(table);
	}

	private JPanel buildCmbBoxPanel() {

		// DataBase cmbBox
		JComboBox<String> dbbox = new JComboBox<>();
		try {
			ResultSet dbrs = stmt.executeQuery("show databases");
			while (dbrs.next())
				dbbox.addItem(dbrs.getString(1));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		// Table cmbBox
		JComboBox<String> tbbox = new JComboBox<>();

		// DataBase CmbBox ActionListener: construct tbBox
		dbbox.addActionListener(e -> {
			String dbSelected = (String) dbbox.getSelectedItem();
			try {
				stmt.execute("use " + dbSelected);
				ResultSet rs = stmt.executeQuery("show tables");
				// Cached RS
				// because meantime TableCmbBox ActnLnr is calling RS too
				CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
				crs.populate(rs);
				tbbox.removeAllItems();
				while (crs.next()) {
					tbbox.addItem(crs.getString(1));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});

		// Table CmbBox: show RS in table area
		tbbox.addActionListener(e -> {
			String tbSelected = (String) tbbox.getSelectedItem();
			if (tbSelected != null)
				queryShowTable("select * from " + tbSelected);
		});

		// combine 2 cmbBoxes into a panel
		JPanel panel = new JPanel();
		panel.add(dbbox);
		panel.add(tbbox);
		return panel;
	}

	private void buildConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost/";
		try {
			Connection con = DriverManager.getConnection(url, "root", "chauncey");
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void queryShowTable(String sql) {
		System.out.println(sql);
		if (!(sql.contains("show") || sql.contains("select"))) {
			String columnNames[] = { "Execute Success: " + sql };
			table.setModel(new DefaultTableModel(columnNames, 1));
			return;
		}
		try {
			ResultSet rs = stmt.executeQuery(sql);
			table.setModel(new DBTableModel(rs));
			tableCurrentRS = RowSetProvider.newFactory().createCachedRowSet();
			tableCurrentRS.populate(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

class DBTableModel extends AbstractTableModel {

	// field
	ResultSet rs;
	ResultSetMetaData rsmd;

	// constructors
	public DBTableModel(ResultSet rs) {
		this.rs = rs;
		try {
			rsmd = rs.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// methods
	public int getColumnCount() {
		try {
			return rsmd.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getRowCount() {
		try {
			rs.last();
			return rs.getRow();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public String getColumnName(int column) {
		try {
			return rsmd.getColumnName(column + 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			rs.absolute(rowIndex + 1);
			return rs.getObject(columnIndex + 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

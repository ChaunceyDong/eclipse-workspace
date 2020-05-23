import java.awt.BorderLayout;
import java.sql.*;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;

public class GUI2test {
	public static void main(String[] args) {
		new ViewDBframe();
	}
}

class ViewDBframe extends JFrame {

	String dbSelected = null;
	JTable table = null;
	Statement stmt = null;
	JScrollPane stable;

	public ViewDBframe() {

		setTitle("Chuanlin's DB_GUI 2.0");
		setSize(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildConnection();
		add(buildCmbBoxPanel(), BorderLayout.NORTH);
		add(buildQueryPanel(), BorderLayout.SOUTH);
		add(addScollTable(), BorderLayout.CENTER);
		setVisible(true);
	}

	public JPanel buildCmbBoxPanel() {

		// Table cmbBox
		JComboBox<String> tbbox = new JComboBox<>();

		tbbox.addActionListener(e -> {
			String tbSelected = (String) tbbox.getSelectedItem();
			if (tbSelected != null)
				queryShowtable("select * from " + tbSelected);
		});

		// Database cmbBox
		JComboBox<String> dbbox = new JComboBox<>();
		try {
			ResultSet dbrs = stmt.executeQuery("show databases;");
			
			CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
			crs.populate(dbrs);

			while (crs.next()) {
				dbbox.addItem(crs.getString(1));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		dbbox.addActionListener(e -> {
			dbSelected = (String) dbbox.getSelectedItem();
			try {
				stmt.execute("use " + dbSelected + ";");
				ResultSet tableRS = stmt.executeQuery("show tables;");
				CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
				crs.populate(tableRS);
				tbbox.removeAllItems();
				while (crs.next()) {
					tbbox.addItem(crs.getString(1));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});

		// panel = 2 * cmbBox
		JPanel panel = new JPanel();
		panel.add(new JLabel("Databases:"));
		panel.add(dbbox);
		panel.add(new JLabel("Tables:"));
		panel.add(tbbox);
		return panel;
	}

	public JScrollPane addScollTable() {
		table = new JTable();
		stable = new JScrollPane(table);
		return stable;
	}

	public void queryShowtable(String mysql) {

		ResultSet rs = null;

		String[] keywords = new String[] { "show", "select" };
		int flag = 0;
		for (String k : keywords) {
			if (mysql.contains(k)) {
				flag = 1;
				break;
			}
		}

		try {
			if (flag == 1) {
				rs = stmt.executeQuery(mysql);
				CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
				crs.populate(rs);
				table.setModel(new DBtable(crs));
			} else {
				stmt.execute(mysql);
				return;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public JPanel buildQueryPanel() {
		// TextArea
		JTextArea txtarea = new JTextArea(5, 30);

		// Button
		JButton btn = new JButton("Query");
		btn.addActionListener(e -> {
			String mysql = txtarea.getText();
			queryShowtable(mysql);

		});

		// Panel = TextArea + Button
		JPanel panel = new JPanel();
		panel.add(txtarea);
		panel.add(btn);
		return panel;
	}

	public void buildConnection() {
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
}

class DBtable extends AbstractTableModel {

	// field
	ResultSet rs;
	ResultSetMetaData rsmd;

	// constructors
	public DBtable(ResultSet rs) {
		this.rs = rs;
		try {
			rsmd = rs.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// methods
	public int getRowCount() {
		try {
			rs.last();
			return rs.getRow();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getColumnCount() {
		try {
			return rsmd.getColumnCount();
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

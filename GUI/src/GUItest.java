import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;

import java.sql.*;

public class GUItest {

	public static void main(String[] args) {
		new ViewDBframe();
	}
}

class ViewDBframe extends JFrame {

	JTable table = null;

	Connection con = null;
	Statement stmt = null;

	public ViewDBframe() {
		this.setTitle("Chuanlin's View DB");
		setSize(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildConnection();
		addScollTable();
		add(buildQueryPanel(), BorderLayout.NORTH);
		setVisible(true);
	}

	private void addScollTable() {
		table = new JTable();
		add(new JScrollPane(table), BorderLayout.CENTER);
		validate();
	}

	private JPanel buildQueryPanel() {
		// Panel = Button + TextArea
		JPanel ret = new JPanel();

		// TextArea
		JTextArea textArea = new JTextArea(5, 30);
		ret.add(textArea);

		// Button
		JButton qrybtn = new JButton("Query");
		qrybtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ResultSet rs = null;
				String sql = textArea.getText();
				try {
					rs = stmt.executeQuery(sql);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				table.setModel(new DBTable(rs));
			}
		});
		ret.add(qrybtn);

		return ret;
	}

	private void buildConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/StudentCourse";
			con = DriverManager.getConnection(url, "root", "chauncey");
			stmt = con.createStatement();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

class DBTable extends AbstractTableModel {

	// fields
	ResultSet rs;
	ResultSetMetaData rsmd;

	// constructors
	public DBTable(ResultSet rs) {
		this.rs = rs;
		try {
			rsmd = rs.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	public int getColumnCount() {
		try {
			return rsmd.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			rs.absolute(rowIndex + 1);
			return rs.getObject(columnIndex + 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		try {
			return rsmd.getColumnName(column + 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

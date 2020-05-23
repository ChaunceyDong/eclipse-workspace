import java.sql.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class GUI4test {

	public static void main(String[] args) {
		new DBFrame();
	}
}

class DBFrame extends JFrame{
	public DBFrame() {
		setTitle("Chuanlin's DB_GUI 4.0");
		setSize(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
}

class TableModel extends AbstractTableModel{
	ResultSet rs;
	ResultSetMetaData rsmd;
	
	public TableModel(ResultSet rs) {
		this.rs = rs;
		try {
			rsmd = rs.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
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
	
	public Object getValueAt(int columnIndex, int rowIndex) {
		try {
			rs.absolute(rowIndex + 1);
			return rs.getObject(columnIndex);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}








import java.sql.*;

public class test {

	public static void main(String[] args) {
		// Load JDBC Driver
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		// Build Connection to the DB
		String url = "jdbc:mysql://localhost/";
		String user = "root";
		String password = "chauncey";
	
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			
			// Create Statements to execute SQL
			Statement stmt = con.createStatement();
//			stmt.execute("create database if not exists hanmei;");
			stmt.execute("use hanmei;");
//			stmt.execute("create table if not exists Students ( id char(10), name char(10), primary key(id))");
//			stmt.execute("insert into Students values('2016001', 'hanmei');");
			
			ResultSet rs = stmt.executeQuery("select * from students");
			while (rs.next()) {
				System.out.println(rs.getString("id") + " " + rs.getString(2));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

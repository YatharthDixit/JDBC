package yath;

import java.sql.*;


public class SecondTable {
	static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/myapps";
	static final String user = "root";
	
	static final String password = "yatharth";
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = null;
		Statement stm = null;
		Class.forName(JDBC_Driver);
		con= DriverManager.getConnection(DB_URL, user, password);
		stm = con.createStatement();
//		stm.executeUpdate("Create database myapps");
//		String sql = "create table myapps.apps(id int not null, name varchar(100), downloads int, primary key(id))";
		
		String sql = "insert into apps(id, name, downloads) values (1, 'Contri', 14to )";
		stm.executeUpdate(sql);
	}

}

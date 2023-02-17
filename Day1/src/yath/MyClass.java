package yath;

import java.sql.*;

public class MyClass {
	static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/Employee";
	static final String user = "root";
	
	static final String password = "yatharth";
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = null;
		Statement stm = null;
		Class.forName(JDBC_Driver);
		con= DriverManager.getConnection(DB_URL, user, password);
		stm = con.createStatement();
		//Updating Database
//		String sql = "create database Employee";
//		String sql = "create table employee_table(id int not null, firstname varchar(100), lastname varchar(100), age int, primary key(id))";
//		 String sql = "insert into employee_table(id, firstname, lastname, age) values (6, 'Tanay','Gupta', 21 )";
//		String sql = "delete from employee_table where id=6";
//		String sql = "update employee_table set age = 22 where id = 6";
//		String sql = "drop table eployee_table";
//		String sql = "drop database eployee";
//		System.out.println("Running query");
//		stm.executeUpdate(sql);
//		System.out.println("Query run successfull");
		
		//Fetching database
		String query = "select *from employee_table";
		ResultSet rs = stm.executeQuery(query);
		while(rs.next()) {
			int id = rs.getInt("id");
			String fName = rs.getString("firstname");
			String lName = rs.getString("lastname");
			int age = rs.getInt("age");
			
			System.out.println("ID: "+id + ", First Name: "+fName + ", Last Name: "+lName + ", Age: "+age);
		}
		rs.close();
		
		
//		
		
		
		

	}

}

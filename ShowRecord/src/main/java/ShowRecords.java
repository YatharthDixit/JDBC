

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowRecords
 */
@WebServlet("/ShowRecords")
public class ShowRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRecords() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "yatharth");
			PreparedStatement ps = con.prepareStatement("select * from student_details");
			out.print("<table width=75% border=1>");
			out.print("<caption>Students Records: </caption><br/>");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int totalColumn = rsmd.getColumnCount();
			for(int i=1; i<=totalColumn; i++)
			{
			out.print("<th>"+rsmd.getColumnName(i)+"</th>");
			}
			out.print("</tr>");
			while(rs.next())
			{
			out.print("<tr><td>"+ rs.getString(1) + "</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3));
			}
			rs.close();

		}
		catch(Exception e){
			out.println(e);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

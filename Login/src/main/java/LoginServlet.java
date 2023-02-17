

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		Connection con = null;
//		Statement stm = null;
			PrintWriter out = response.getWriter();
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			
		
			Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Student", "root", "yatharth");
		
			// TODO Auto-generated catch block
		
		
//			stm = con.createStatement();
		
		String n = request.getParameter("t1");
		String pwd = request.getParameter("t2");
//		PrintWriter out = response.getWriter();
		PreparedStatement ps = con.prepareStatement("select username from details where username =? and password =?");
		ps.setString(1, n);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		
		
		if(rs.next()) {
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
		}
		else {
			out.println("<font color = red size = 20> Login Failed<br>");
			out.println("<font  size = 15> Invalid username or password.<br>");
			
		}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	

}

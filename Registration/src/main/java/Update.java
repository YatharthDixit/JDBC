


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class UpdateName
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    
    //protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //    // TODO Auto-generated method stub
    //    response.getWriter().append("Served at: ").append(request.getContextPath());
    //}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        int status = 0;
        
        try {
            
            
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root" , "yatharth");
        
        PreparedStatement ps = con.prepareStatement("update student set name=?, password=?, phone = ? where email=?");
        ps.setString(1, name);
        
        ps.setString(2, password);
        ps.setString(3, phone);
        ps.setString(4, email);
        
        //out.print("<table width = 75% border=1>");
        //out.print("<caption> Students Records:</caption><br/>");
        status = ps.executeUpdate();
        
        if(status>0) {
            out.print("<p> Record Updated Successfully </p>" );
            request.getRequestDispatcher("home.jsp").include(request,response);
        }
        
        else {
            out.print("<p> Sorry unable to update record!! </p> " );
            request.getRequestDispatcher("update.jsp").include(request, response);
        }
        
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        //doGet(request, response);
    }
}
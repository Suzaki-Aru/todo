
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

	public void doPost(HttpServletRequest request,
		    HttpServletResponse response) throws ServletException,
		    IOException{
		        
		        
		        int postId = Integer.parseInt(request.getParameter("id"));
		        String title = request.getParameter("title");
		        String content = request.getParameter("content");
		        String priority = request.getParameter("priority");
		        
		        String url = "jdbc:mysql://localhost:3306/webappsecond";
		        String user = "root";
		        String password ="root";
		        try{
		            Class.forName("com.mysql.cj.jdbc.Driver");
		        } catch(Exception e){
		            e.printStackTrace();
		        }
		        String sql ="UPDATE task SET title = ?, content = ?, priority = ? WHERE id = ?";
		        try (Connection connection = DriverManager.getConnection
		        (url, user, password);
		        PreparedStatement statement = connection.prepareStatement
		        (sql)){
		        	    statement.setString(1, title);
		        	    statement.setString(2, content);
		        	    statement.setString(3, priority);
		        	    statement.setInt(4, postId);
		                int number = statement.executeUpdate();
		                request.setAttribute("message", "Id:" + postId + "の更新ができました");
                        
		        }   catch(SQLException e){
		            e.printStackTrace();
		        }
		            catch (Exception e){
		            request.setAttribute("message", "Exception" + e.getMessage());
		        }
		        String view="ManageServlet";
		        response.sendRedirect(view);
		    }
}

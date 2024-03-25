

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request,
		    HttpServletResponse response) throws ServletException,
		    IOException{
		        
				 if(request.getAttribute("message")==null){
		            request.setAttribute("message", "todoを管理しましょう");
		        }
		        
		        int postId = Integer.parseInt(request.getParameter("id"));
		        
		        String url = "jdbc:mysql://localhost:3306/webappsecond";
		        String user = "root";
		        String password ="root";
		        try{
		            Class.forName("com.mysql.cj.jdbc.Driver");
		        } catch(Exception e){
		            e.printStackTrace();
		        }
		        String sql ="DELETE FROM task WHERE id =  ?";
		        try (Connection connection = DriverManager.getConnection
		        (url, user, password);
		        PreparedStatement statement = connection.prepareStatement
		        (sql)){
		        	    
		        	    statement.setInt(1, postId);
		                int number = statement.executeUpdate();
		                request.setAttribute("message", "Id:" + postId + "の削除ができました");
                        
		        }   catch(SQLException e){
		            e.printStackTrace();
		        }
		            catch (Exception e){
		            request.setAttribute("message", "Exception" + e.getMessage());
		        }
		        String forward="/ManageServlet";
		        RequestDispatcher dispatcher= request .getRequestDispatcher(forward);
		        dispatcher.forward(request, response);
		    }
}

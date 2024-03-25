

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EdittServlet
 */
@WebServlet("/EdittServlet")
public class EdittServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request,
		    HttpServletResponse response) throws ServletException,
		    IOException{
		        
		        int postId = Integer.parseInt(request.getParameter("id"));
		        
		        String url = "jdbc:mysql://localhost:3306/webappsecond";
		        String user = "root";
		        String password ="root";
		        try{
		            Class.forName("com.mysql.cj.jdbc.Driver");
		        } catch(Exception e){
		            e.printStackTrace();
		        }
		        String sql ="SELECT * FROM task WHERE id = ?";
		        try (Connection connection = DriverManager.getConnection
		        (url, user, password);
		        PreparedStatement statement = connection.prepareStatement
		        (sql)){
		                
		        	    statement.setInt(1, postId);
		        	    ResultSet results = statement.executeQuery();
		               
                        while(results.next()){
		                    
		                    String id=results.getString("id");
		                    request.setAttribute("id", id);
		                    
		                    String title=results.getString("title");
		                    request.setAttribute("title", title);
		                    
		                    String content=results.getString("content").
		                    replaceAll("\n", "<br>");
		                    request.setAttribute("content", content);
		                    
		                }
		        }   catch(SQLException e){
		            e.printStackTrace();
		        }
		            catch (Exception e){
		            request.setAttribute("message", "Exception" + e.getMessage());
		        }
		        String view="WEB-INF/view/editt.jsp";
		        RequestDispatcher dispatcher= request .getRequestDispatcher(view);
		        dispatcher.forward(request, response);
		    }
}

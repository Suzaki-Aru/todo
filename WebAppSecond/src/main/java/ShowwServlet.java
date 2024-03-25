

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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowwServlet
 */
@WebServlet("/ShowwServlet")
public class ShowwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request,
		    HttpServletResponse response) throws ServletException,
		    IOException{
		       
		        
		        int postId = Integer.parseInt(request.getParameter("id"));
		        String sorted = request.getParameter("sort");
		        String selectedSortValue = request.getParameter("sortValue");
		        
		        String url = "jdbc:mysql://localhost:3306/webappsecond";
		        String user = "root";
		        String password ="root";
		        try{
		            Class.forName("com.mysql.cj.jdbc.Driver");
		        } catch(Exception e){
		            e.printStackTrace();
		        }
		        
		        String sql ="select \r\n"
		        		+ "	*,\r\n"
		        		+ "	case priority\r\n"
		        		+ "	when \"1\" then \"High\"\r\n"
		        		+ "	when \"2\" then \"Middle\"\r\n"
		        		+ "	when \"3\" then \"Low\" \r\n"
		        		+ "	end as priority_name\r\n"
		        		+ "\r\n"
		        		+ "from task t WHERE id = ?";
		        try (Connection connection = DriverManager.getConnection
		        (url, user, password);
		        PreparedStatement statement = connection.prepareStatement
		        (sql)){
		                
		        	    statement.setInt(1, postId);
		        	    ResultSet results = statement.executeQuery();
		               
                        while(results.next()){
		                    
		                    String id = results.getString("id");
		                    request.setAttribute("id", id);
		                    
		                    String title = results.getString("title");
		                    request.setAttribute("title", title);
		                    
		                    String content = results.getString("content").
		                    replaceAll("\n", "<br>");
		                    request.setAttribute("content", content);
		                    
		                    String priority = results.getString("priority");
		                    request.setAttribute("priority", priority);
		                    
		                    String created_time = results.getString("created_time");
		                    request.setAttribute("created_time", created_time);
		                    
		                    String priority_name = results.getString("priority_name");
		                    request.setAttribute("priority_name", priority_name);
		                    
		                }
		        }   catch(SQLException e){
		            e.printStackTrace();
		        }
		            catch (Exception e){
		            request.setAttribute("message", "Exception" + e.getMessage());
		        }
		        HttpSession session = request.getSession();
                session.setAttribute("selectedSortValue",selectedSortValue);
		        String view="WEB-INF/view/task.jsp";
		        RequestDispatcher dispatcher= request .getRequestDispatcher(view);
		        dispatcher.forward(request, response);
		    }
}


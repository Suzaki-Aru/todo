

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ManageServlet
 */
@WebServlet("/ManageServlet")
public class ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request,
		    HttpServletResponse response) throws ServletException,
		    IOException{
		       
		        String url = "jdbc:mysql://localhost:3306/webappsecond";
		        String user = "root";
		        String password ="root";
		        try{
		            Class.forName("com.mysql.cj.jdbc.Driver");
		        } catch(Exception e){
		            e.printStackTrace();
		        }
		        
		        String sql;
		        String sorted = request.getParameter("sort");
		        request.setAttribute("sorted", sorted);
		        
		        if (Objects.equals(sorted, "1")) {
		              sql ="select \r\n"
		            		  + "	*,\r\n"
		            		  + "	case priority\r\n"
		            		  + "		when \"1\" then \"High\"\r\n"
		            		  + "		when \"2\" then \"Middle\"\r\n"
		            		  + "		when \"3\" then \"Low\" \r\n"
		            		  + "	end as priority_name\r\n"
		            		  + "from task t \r\n"
		            		  + "where userid = ?\r\n"
		            		  + "order by priority";
		        } else if (Objects.equals(sorted, "2")) {
		        	  sql ="select \r\n"
		        			  + "	*,\r\n"
		        			  + "	case priority\r\n"
		        			  + "		when \"1\" then \"High\"\r\n"
		        			  + "		when \"2\" then \"Middle\"\r\n"
		        			  + "		when \"3\" then \"Low\" \r\n"
		        			  + "	end as priority_name\r\n"
		        			  + "from task t \r\n"
		        			  + "where userid = ?\r\n"
		        			  + "order by priority desc";
		        } else if (Objects.equals(sorted, "3")) {
		        	  sql ="select \r\n"
		        			  + "	*,\r\n"
		        			  + "	case priority\r\n"
		        			  + "		when \"1\" then \"High\"\r\n"
		        			  + "		when \"2\" then \"Middle\"\r\n"
		        			  + "		when \"3\" then \"Low\" \r\n"
		        			  + "	end as priority_name\r\n"
		        			  + "from task t \r\n"
		        			  + "where userid = ?\r\n";
		        } else {
		        	  sql ="select \r\n"
		        			  + "	*,\r\n"
		        			  + "	case priority\r\n"
		        			  + "		when \"1\" then \"High\"\r\n"
		        			  + "		when \"2\" then \"Middle\"\r\n"
		        			  + "		when \"3\" then \"Low\" \r\n"
		        			  + "	end as priority_name\r\n"
		        			  + "from task t \r\n"
		        			  + "where userid = ?\r\n"
		        	          + "order by created_time desc";
		        }
		          
		          HttpSession session = request.getSession();     
		          String userid = (String) session.getAttribute("userid");
		          
		        try (Connection connection = DriverManager.getConnection
		        (url, user, password);
		        PreparedStatement statement = connection.prepareStatement(sql)){
		        		statement.setString(1, userid);
		        	ResultSet results = statement.executeQuery();
		                ArrayList<HashMap<String,String>> rows =new
		                ArrayList<HashMap<String,String>>();
		                while(results.next()){
		                    HashMap<String,String> columns = new
		                    HashMap<String,String>();
		                    String id=results.getString("id");
		                    columns.put("id", id);
		                    columns.put("userid", userid);
		                    String title=results.getString("title");
		                    columns.put("title", title);
		                    String content=results.getString("content");
		                    columns.put("content", content);
		                    String priority=results.getString("priority");
		                    columns.put("priority", priority.toString());
		                    String created_time=results.getString("created_time");
		                    columns.put("created_time", created_time);
		                    
		                    rows.add(columns);
		                }
		                
		                session.setAttribute("rows",rows);
		                
		        }   catch(SQLException e){
		            e.printStackTrace();
		        }
		            catch (Exception e){
		            request.setAttribute("message", "Exception" + e.getMessage());
		        }
		        
		        if (userid != null) {
		            request.setAttribute("userid", userid);
		            String view = "/WEB-INF/view/manage.jsp";
		            request.getRequestDispatcher(view).forward(request, response);
		        } else {
		            // 未ログインの場合、ログイン画面に遷移
		            response.sendRedirect("LoginServlet");
		        }
	  } 
}
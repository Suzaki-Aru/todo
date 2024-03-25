

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/NewServlet")
public class NewServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,
		    HttpServletResponse response) throws ServletException,
		    IOException{
		        
				request.setAttribute("message", "新規作成ページです");
		
		        String view="WEB-INF/view/neeew.jsp";
		        RequestDispatcher dispatcher= request .getRequestDispatcher(view);
		        dispatcher.forward(request, response);
		    }
}

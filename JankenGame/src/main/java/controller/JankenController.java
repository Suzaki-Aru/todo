package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JankenController
 */
@WebServlet("/JankenController")
public class JankenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JankenController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 String view = "/WEB-INF/views/janken.jsp";
		    getServletContext().getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String playerhand = request.getParameter("playerhand");
		String[] cphands = {"rock", "scissors", "paper"};
        String cphand = (getRandom(cphands));
        String result = determineWinner(playerhand, cphand);
        
        request.setAttribute("playerhand", playerhand);
        request.setAttribute("cphand", cphand);
        request.setAttribute("result", result);
        
        String view = "/WEB-INF/views/result.jsp";
        getServletContext().getRequestDispatcher(view).forward(request, response);
	}
	
        
        
        private String determineWinner(String playerhand, String cphand) {
    	    if (playerhand.equals(cphand)) {
    	      return "あいこ";
    	    }
     
     if ((playerhand.equals("rock") && cphand.equals("paper")) ||
             (playerhand.equals("scissor") && cphand.equals("rock")) ||
             (playerhand.equals("paper") && cphand.equals("scissors")))
          {  
          	return "負け";
          
          } else {
          return "勝ち";
          
          }
       
          

	}
	
        
     public static String getRandom(String[] arr) {
            Random rnd = new Random();
            int index = rnd.nextInt(arr.length);
            return arr[index];
    }
	
    
     

}

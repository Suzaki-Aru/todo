import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.HashGenerator;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost/webappsecond";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String view = "/WEB-INF/view/login.jsp";
        req.getRequestDispatcher(view).forward(req, res);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String userid = req.getParameter("userid");
        String password = req.getParameter("password");
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // DBに登録されているパスワードはハッシュ化されているためハッシュ化した値で照合する
            String hashedPassword = HashGenerator.generateHash(password);
            String sql = "SELECT * FROM users WHERE userid=? AND password=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, userid);
                stmt.setString(2, hashedPassword);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("userid");
                    

                 // 2.サーバーからセッションを取得する
                    HttpSession session = req.getSession();
                 // 3.キーと値のペアでセッションに登録する
                    session.setAttribute("id", id);
                    session.setAttribute("userid", userid);
                    res.sendRedirect("ManageServlet");
                } else {
                	req.setAttribute("errorMsg", "Incorrect Username or Password");
                	String view = "/WEB-INF/view/login.jsp";
                	req.getRequestDispatcher(view).forward(req, res);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database Connection Failed", e);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new ServletException("Generate hash Failed", e);
        }
    }

}

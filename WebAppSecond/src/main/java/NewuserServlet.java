import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.HashGenerator;

@WebServlet("/NewuserServlet")
public class NewuserServlet extends HttpServlet {
    // 1.接続情報
    private static final String DB_URL = "jdbc:mysql://localhost/webappsecond";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String view = "/WEB-INF/view/newuser.jsp";
        req.getRequestDispatcher(view).forward(req, res);
    }

    // 2.POST用のメソッド追加
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 3.フォームから各値を取得
        String userid = req.getParameter("userid");
        String password = req.getParameter("password");
        // 4.DBに接続
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // 5.パスワードをハッシュ化する
            String hashedPassword = HashGenerator.generateHash(password);
            String sql = "INSERT INTO users (userid, password) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, userid);
                // 6.ハッシュ化した値を利用
                stmt.setString(2, hashedPassword);
                stmt.execute();

                String view = "/WEB-INF/view/login.jsp";
                req.getRequestDispatcher(view).forward(req, res);
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

package myproject.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/login")
public class Login extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username.equals("admin") && password.equals("admin")){
            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            resp.sendRedirect("/admin/category.html");
        } else {
            resp.sendRedirect("/");

        }
    }
}

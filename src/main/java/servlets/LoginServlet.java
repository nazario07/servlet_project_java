package servlets;


import dao.impl.UserDaoImpl;
import entities.User;
import exceptions.IncorrectCredsExceptions;
import services.UserService;
import services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService;

    public LoginServlet() {
        this.userService = new UserServiceImpl(new UserDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            User user = userService.login(email, password);
            HttpSession session = req.getSession();
            session.setAttribute("id", user.getId());
            session.setAttribute("firstName", user.getFirstName());
            resp.sendRedirect("cabinet.jsp");
        } catch (IncorrectCredsExceptions e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}

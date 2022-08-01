package servlets;


import dao.impl.BucketDaoImpl;
import dao.impl.UserDaoImpl;
import entities.User;
import exceptions.IncorrectCredsExceptions;
import org.apache.log4j.Logger;
import services.UserService;
import services.impl.UserServiceImpl;
import servlets.controllers.ProductController;

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
        this.userService = new UserServiceImpl(new UserDaoImpl(), new BucketDaoImpl());
    }

    private static final Logger log = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            User user = userService.login(email, password);
            HttpSession session = req.getSession();
            session.setAttribute("id", user.getId());
            session.setAttribute("firstName", user.getFirstName());
            session.setAttribute("lastName", user.getLastName());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("role", user.getRole());
            resp.sendRedirect("cabinet.jsp");
            log.info("USER "+user.getFirstName()+" "+ user.getLastName()+ " login");
        } catch (IncorrectCredsExceptions e) {
            e.printStackTrace();
            log.error("Incorrect password or login");
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}

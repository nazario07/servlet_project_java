package servlets;

import com.google.gson.Gson;
import dao.impl.BucketDaoImpl;
import dao.impl.UserDaoImpl;
import entities.User;
import exceptions.UserAlreadyExistException;

import org.apache.log4j.Logger;
import services.UserService;
import services.impl.UserServiceImpl;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;


public class RegistrationServlet extends HttpServlet {
    private final UserService userService;

    public RegistrationServlet() {
        this.userService = new UserServiceImpl(new UserDaoImpl(), new BucketDaoImpl());
    }

    private static final Logger log = Logger.getLogger(String.valueOf(RegistrationServlet.class));
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        BufferedReader reader = req.getReader();
        Gson gson = new Gson();
        User user = gson.fromJson(reader, User.class);
        System.out.println(user);
        try {
            userService.registration(user);
            resp.sendRedirect("login.jsp");
        } catch (UserAlreadyExistException | SQLException e) {
            e.printStackTrace();
            log.error(e.getMessage());
            resp.setStatus(HttpServletResponse.SC_CONFLICT);
        }


    }

}

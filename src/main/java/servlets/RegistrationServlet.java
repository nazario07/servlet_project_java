package servlets;

import com.google.gson.Gson;
import dao.impl.UserDaoImpl;
import entities.User;
import exceptions.UserAlreadyExistException;

import services.UserService;
import services.impl.UserServiceImpl;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


public class RegistrationServlet extends HttpServlet {
    private final UserService userService;

    public RegistrationServlet() {
        this.userService = new UserServiceImpl(new UserDaoImpl());
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        BufferedReader reader = req.getReader();
        Gson gson = new Gson();
        User user = gson.fromJson(reader, User.class);
        System.out.println(user);
        try {
            userService.insert(user);
            resp.sendRedirect("login.jsp");
        } catch (UserAlreadyExistException e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_CONFLICT);
        }


    }

}

package servlets.controllers;

import com.google.gson.Gson;
import dao.impl.ProductDaoImpl;
import entities.Product;
import org.apache.log4j.Logger;
import services.ProductService;
import services.impl.ProductServiceImpl;
import services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/product")
public class ProductController extends HttpServlet {
    private ProductService productService;

    public ProductController() {
        this.productService = new ProductServiceImpl(new ProductDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Gson gson = new Gson();
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();

        if (id != null) {
            Product product = productService.getById(Integer.parseInt(id));
//            writer.print(gson.toJson(product));
            req.setAttribute("product",product);
            req.getRequestDispatcher("details.jsp").forward(req, resp);
        } else {
            List<Product> all = productService.getAll();
            writer.print(gson.toJson(all));
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        BufferedReader reader = req.getReader();
        Product product = gson.fromJson(reader, Product.class);
        productService.createNewProduct(product);
    }
}

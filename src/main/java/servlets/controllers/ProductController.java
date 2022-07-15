package servlets.controllers;

import com.google.gson.Gson;
import dao.impl.ProductDaoImpl;
import entities.Product;
import services.ProductService;
import services.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/product")
public class ProductController extends HttpServlet {
    private ProductService productService;

    public ProductController() {
        this.productService = new ProductServiceImpl(new ProductDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        BufferedReader reader = req.getReader();
        Product product = gson.fromJson(reader, Product.class);
        productService.createNewProduct(product);
    }
}

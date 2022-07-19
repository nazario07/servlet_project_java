package servlets.controllers;

import com.google.gson.Gson;
import dao.impl.BucketDaoImpl;
import entities.Product;
import models.BucketProduct;
import services.BucketService;
import services.impl.BucketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/bucket")
public class BucketController extends HttpServlet {
    BucketService bucketService;

    public BucketController() {
        this.bucketService = new BucketServiceImpl(new BucketDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Product> products = bucketService.getProductFromBucket((int) session.getAttribute("id"));
        Gson gson = new Gson();
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.print(gson.toJson(products));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Gson gson = new Gson();
        BucketProduct bucketItem = gson.fromJson(reader, BucketProduct.class);
        bucketItem.bucketId = (int) req.getSession().getAttribute("id");
        bucketService.addProductToBucket(bucketItem.bucketId, bucketItem.productId);
    }
}

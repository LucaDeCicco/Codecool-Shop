package com.codecool.shop.controller.api;



import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Item;
import com.codecool.shop.model.Product;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "CalculateTotalServlet", urlPatterns = {"/api/getTotal"}, loadOnStartup = 1)
public class CalculateTotalApi extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CartDaoMem cartDataStore = CartDaoMem.getInstance();

        double total = cartDataStore.calculateTotal();


        response.setContentType("application/json");
        String dataToRespond = String.valueOf(total);
        System.out.println(dataToRespond + " Total");
        PrintWriter out = response.getWriter();
        out.println(dataToRespond);
    }
}
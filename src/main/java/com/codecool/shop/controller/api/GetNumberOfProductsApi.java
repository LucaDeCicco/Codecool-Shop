package com.codecool.shop.controller.api;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.model.Item;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "GetNumberOfProductsServlet", urlPatterns = {"/api/getNumberOfProducts"}, loadOnStartup = 1)
public class GetNumberOfProductsApi extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CartDaoMem cartDaoMem = CartDaoMem.getInstance();
        int total = 0;
        for (Item item : cartDaoMem.getAll()) {
            total+=item.getQuantity();
        }
        String numberOfProducts = String.valueOf(total);

        response.setContentType("application/json");

        PrintWriter out = response.getWriter();
        out.println(numberOfProducts);
    }
}
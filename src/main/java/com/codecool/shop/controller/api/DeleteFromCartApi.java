package com.codecool.shop.controller.api;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Item;
import com.codecool.shop.model.Product;
import com.google.gson.JsonObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;


@WebServlet(name = "DeleteFromCartServlet", urlPatterns = {"/api/deleteFromCart"}, loadOnStartup = 1)
public class DeleteFromCartApi extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("deleteFromCartApi");

        CartDaoMem cartDataStore = CartDaoMem.getInstance();

        List<Item> cartProducts = cartDataStore.getAll();

        StringBuffer buffer = new StringBuffer();
        String line;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String bufferID = buffer.substring(7, 8);
        String bufferQuantity = buffer.substring(21, 22);

        for (Item product : cartProducts) {
            if (product.getProductId()==Integer.parseInt(bufferID)){
                cartDataStore.deleteFromCart(product);
            }
        }


        response.setContentType("application/json");
        String dataToRespond = "{\"id\":15,\"result\":\"SUCCESS\"}";
        PrintWriter out = response.getWriter();
        out.println(dataToRespond);
    }
}
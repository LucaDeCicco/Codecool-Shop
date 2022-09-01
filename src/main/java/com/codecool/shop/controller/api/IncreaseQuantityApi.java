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


@WebServlet(name = "IncreaseQuantityServlet", urlPatterns = {"/api/increaseQuantity"}, loadOnStartup = 1)
public class IncreaseQuantityApi extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        String bufferQuantity = buffer.substring(22,23);


        for (Item item : cartProducts) {
            if (item.getId()==Integer.parseInt(bufferID)){
                item.setQuantity(Integer.parseInt(bufferQuantity));
            }
        }



        response.setContentType("application/json");
        String dataToRespond = "{\"id\":15,\"result\":\"SUCCESS\"}";
        PrintWriter out = response.getWriter();
        out.println(dataToRespond);
    }
}
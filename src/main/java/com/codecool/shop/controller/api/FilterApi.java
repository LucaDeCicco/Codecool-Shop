package com.codecool.shop.controller.api;

import com.codecool.shop.Serializations.ProductSerializer;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.FilterMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Item;
import com.codecool.shop.model.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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


@WebServlet(name = "FilterServlet", urlPatterns = {"/api/filter"}, loadOnStartup = 1)
public class FilterApi extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        FilterMem filterMem = FilterMem.getInstance();

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

        String[] criteriaList = buffer.toString().split("\"");
        String criteria = criteriaList[3];
        List<Product>filteredList = filterMem.filterByCriteria(criteria);

        response.setContentType("application/json");


        Gson gson = new GsonBuilder().registerTypeAdapter(Product.class, new ProductSerializer()).create();

        PrintWriter out = response.getWriter();
        out.println(gson.toJson(filteredList));


    }
}
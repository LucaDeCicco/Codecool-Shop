package com.codecool.shop.controller.api;



import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Client;
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


@WebServlet(name = "SetCredentialsServlet", urlPatterns = {"/api/setCredentials"}, loadOnStartup = 1)
public class SetCredentialsApi extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Client client = Client.getInstance();

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


        String name = buffer.toString().split(",")[0].split(":")[1].split("\"")[1];
        String email = buffer.toString().split(",")[1].split(":")[1].split("\"")[1];
        String phoneNumber = buffer.toString().split(",")[2].split(":")[1].split("\"")[1];
        String country = buffer.toString().split(",")[3].split(":")[1].split("\"")[1];
        String city = buffer.toString().split(",")[4].split(":")[1].split("\"")[1];
        String zipCode = buffer.toString().split(",")[5].split(":")[1].split("\"")[1];
        String address = buffer.toString().split(",")[6].split(":")[1].split("\"")[1];


        client.setName(name);
        client.setEmail(email);
        client.setPhoneNumber(phoneNumber);
        client.setCountry(country);
        client.setCity(city);
        client.setZipCode(zipCode);
        client.setAddress(address);
    }
}
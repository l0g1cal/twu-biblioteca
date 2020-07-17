package com.biblioteca.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@WebServlet(name = "WelcomeServlet", urlPatterns = { "welcome" }, loadOnStartup = 1)
public class WelcomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().print(getWelcomeMessage());
    }

    private String getWelcomeMessage() {
        Gson gson = new Gson();
        JsonObject welcomeMessageObj = new JsonObject();
        welcomeMessageObj.addProperty("message",
                "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        String jsonResponse = welcomeMessageObj.toString();
        return gson.toJson(jsonResponse);
    }
}
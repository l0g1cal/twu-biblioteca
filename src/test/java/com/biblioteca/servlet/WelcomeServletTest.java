package com.biblioteca.servlet;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class WelcomeServletTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;

    private Gson gson = new Gson();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    public void doPost() throws Exception {
        JsonObject welcomeMessageObj = new JsonObject();
        welcomeMessageObj.addProperty("message",
                "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        String responseBody = gson.toJson(gson.toJson(welcomeMessageObj));
        StringWriter stringWriter = setupMockResponse();

        WelcomeServlet welcomeServlet = new WelcomeServlet();
        welcomeServlet.doPost(request, response);

        assertEquals(responseBody, stringWriter.toString());
    }

    private StringWriter setupMockResponse() throws IOException {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(printWriter);

        return stringWriter;
    }
}
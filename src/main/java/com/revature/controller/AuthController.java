package com.revature.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import com.revature.service.AuthService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class AuthController implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // TODO Auto-generated method stub
        String verb = exchange.getRequestMethod();
        URI uri = exchange.getRequestURI();


        //PUT - 3, updating 
        //POST - infinite, create a new resource
        //URI uri = exchange.getRequestURI();
        //Parse it
        // "pokemon/login" => "login => http verb" && /pokemon/login/trainer => "login => trainer => each http verb"
        //Use switch statement to direct to specific private methods
        //use a nested switch statement that directs to a specific http verb
        switch (verb) {
            case "GET":
                getRequest(exchange);
                break;
            case "POST":
                switch (uri.getPath()){
                    case "/register":
                        registerUser(exchange);
                        break;
                    case "/login":
                        authenticateUser(exchange);
                        break;
                }
                break;
            default:
                break;
        }
        System.out.println();
    }

    private void getRequest(HttpExchange exchange) throws IOException {
        //create new object and call method get allusers to retrieve from DB
        AuthService serv = new AuthService();
        String jsonCurrentList = serv.getAllUsers();

        exchange.sendResponseHeaders(200, jsonCurrentList.getBytes().length);

        OutputStream os = exchange.getResponseBody();
        os.write(jsonCurrentList.getBytes());//sends back response string
        os.close();
    }

    /*
        Javelin
        HttpClient - library
    */

    private void registerUser(HttpExchange exchange) throws IOException {

        //InputStream has a bunch of bytes
        InputStream is = exchange.getRequestBody();

        //We need to convert the InputStream into String
        //StringBuilder is like a mutable version of a String
        StringBuilder textBuilder = new StringBuilder();

        //Converts our binary into letters
        //try_resource block will automatically close the resource within the parenthesis
        try (Reader reader = new BufferedReader(new InputStreamReader(is, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c = 0;

            //read() method from BufferReader will give a -1 once there is no more letters left
            //TLDR keep reading each letter until there is no more left
            while ((c = reader.read()) != -1) {
                //Adds the letter to your text
                textBuilder.append((char) c);
            }
        }

        exchange.sendResponseHeaders(200, textBuilder.toString().getBytes().length);
        //call on the service layer and execute the method
        AuthService authService = new AuthService();
        authService.createUser(textBuilder.toString());

        OutputStream os = exchange.getResponseBody();
        os.write(textBuilder.toString().getBytes());//write back response
        os.close();
    }

    private void authenticateUser(HttpExchange exchange) throws IOException {

        //InputStream has a bunch of bytes
        InputStream is = exchange.getRequestBody();

        //We need to convert the InputStream into String
        //StringBuilder is like a mutable version of a String
        StringBuilder textBuilder = new StringBuilder();

        //Converts our binary into letters
        //try_resource block will automatically close the resource within the parenthesis
        try (Reader reader = new BufferedReader(new InputStreamReader(is, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c = 0;

            //read() method from BufferReader will give a -1 once there is no more letters left
            //TLDR keep reading each letter until there is no more left
            while ((c = reader.read()) != -1) {
                //Adds the letter to your text
                textBuilder.append((char) c);
            }
        }

        exchange.sendResponseHeaders(200, textBuilder.toString().getBytes().length);
        //Don't forget to call on the service layer and execute the method
        AuthService authService = new AuthService();
        authService.authenticateUser(textBuilder.toString());

        OutputStream os = exchange.getResponseBody();
        os.write(textBuilder.toString().getBytes());
        os.close();
    }
}

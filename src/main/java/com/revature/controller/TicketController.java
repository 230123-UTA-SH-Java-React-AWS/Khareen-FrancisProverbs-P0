package com.revature.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.URI;
import java.net.http.HttpHeaders;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import com.revature.service.TicketService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class TicketController implements HttpHandler {

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
                switch (uri.getPath()){
                    case "/viewPendingTickets":
                        viwPendigTickets(exchange);
                        break;
                    case "/viewTickets":
                        viewAllTickets(exchange);
                        break;
                }
                break;
            case "POST":
                switch (uri.getPath()){
                    case "/createTicket" :
                        createTicket(exchange);
                        break;
                    case "/viewPreviousTickets":
                        viewPreviousTickets(exchange);
                }
                break;
            case "PUT":
                updateTicketStatus(exchange);
                break;
            default:
                break;
        }
        System.out.println();
    }

    private void viewPreviousTickets(HttpExchange exchange) throws IOException {
        //create new object and call method get alltickets to retrieve from DB
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

        //call on the service layer and execute the method
        TicketService ticketService = new TicketService();
        String jsonCurrentList = ticketService.getPreviousTickets(textBuilder.toString());

        exchange.sendResponseHeaders(200, jsonCurrentList.getBytes().length);


        OutputStream os = exchange.getResponseBody();
        os.write(jsonCurrentList.getBytes());
        os.close();
    }


    private void updateTicketStatus(HttpExchange exchange) throws IOException {
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
        TicketService ticketService = new TicketService();
        ticketService.updateTicket(textBuilder.toString());

        OutputStream os = exchange.getResponseBody();
        os.write(textBuilder.toString().getBytes());
        os.close();
    }

    private void viewAllTickets(HttpExchange exchange) throws IOException {
        //create new object and call method get allusers to retrieve from DB
        TicketService serv = new TicketService();
        String jsonCurrentList = serv.getAllTickets();

        exchange.sendResponseHeaders(200, jsonCurrentList.getBytes().length);

        OutputStream os = exchange.getResponseBody();
        os.write(jsonCurrentList.getBytes());
        os.close();
    }

    private void viwPendigTickets(HttpExchange exchange)throws IOException {
        //create new object and call method get allusers to retrieve from DB
        TicketService serv = new TicketService();
        String jsonCurrentList = serv.viewPendingTickets();

        exchange.sendResponseHeaders(200, jsonCurrentList.getBytes().length);

        OutputStream os = exchange.getResponseBody();
        os.write(jsonCurrentList.getBytes());
        os.close();
    }

    /*
        Javelin
        HttpClient - library
    */

    private void createTicket(HttpExchange exchange) throws IOException {

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
        TicketService ticketService = new TicketService();
        ticketService.createTicket(textBuilder.toString());

        OutputStream os = exchange.getResponseBody();
        os.write(textBuilder.toString().getBytes());
        os.close();
    }


}

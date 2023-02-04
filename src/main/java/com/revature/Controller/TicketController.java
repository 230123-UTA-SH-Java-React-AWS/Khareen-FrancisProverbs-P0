package com.revature.Controller;

import com.revature.Service.TicketService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class TicketController implements HttpHandler {
    //Controller handles all requests and sends to the service
    final TicketService ticketServ = new TicketService();//anyone who makes this ob


    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String verb = exchange.getRequestMethod();//login
        String verb2 = exchange.getRequestMethod();


        //PUT - 3, updating
        //POST - infinite, create a new resource

        //URI uri = exchange.getRequestURI();
        //Parse it
        // "pokemon/login" => "login => http verb" && /pokemon/login/trainer => "login => trainer => each http verb"
        //Use switch statement to direct to specific private methods
        //use a nested switch statement that directs to a specific http verb

        switch (verb) {
            case "POST":

                switch (verb2){
                    case "LOGIN":
                        postLoginRequest(exchange);


                }
                break;
            case "GET":
                getRequest(exchange);
                break;
            case "PUT":
                putRequest(exchange);
                break;
            case "DELETE":
                deleteRequest(exchange);
                break;
            default:
                break;


        }
    }

    private void deleteRequest(HttpExchange exchange) {
    }

    private void putRequest(HttpExchange exchange) {
    }

    private void getRequest(HttpExchange exchange) {
    }

    private void postLoginRequest(HttpExchange exchange) {
    }
}

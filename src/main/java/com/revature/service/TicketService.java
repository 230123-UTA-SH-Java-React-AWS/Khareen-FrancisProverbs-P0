package com.revature.service;

import java.io.IOException;

import com.revature.GetPreviousTicketsRequest;
import com.revature.model.Ticket;
import com.revature.repository.TicketRepository;

import java.sql.SQLException;
import java.util.List;


import com.revature.utils.UpdateTicketRequest;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/*
    The service layer is responsible for hold behavior driven classes
    It might have further validation or information process within the service
*/
public class TicketService {


    public void createTicket(String userJson)
    {
        TicketRepository repo = new TicketRepository();
        //Conversion from string to ticket obj here?
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(userJson);
        System.out.println();

        try {
            Ticket newTicket = mapper.readValue(userJson, Ticket.class);
            newTicket.setTicketstatus("PENDING");//sets default status to pending
            repo.createTicket(newTicket);

        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void updateTicket(String ticketJson){
        TicketRepository repo = new TicketRepository();
        ObjectMapper mapper = new ObjectMapper();

        try {
            UpdateTicketRequest newTicket = mapper.readValue(ticketJson, UpdateTicketRequest.class);
            repo.updateTicket(newTicket);

        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public String getPreviousTickets(String ticketJson) {
        TicketRepository repo = new TicketRepository();
        List<Ticket> listOfTickets = repo.getTickets();

        ObjectMapper map = new ObjectMapper();
        String jsonString = "Could not write JSON to String";
        try {
            GetPreviousTicketsRequest ticketRequest = map.readValue(ticketJson, GetPreviousTicketsRequest.class);
            listOfTickets= repo.viewPreviousTickets(ticketRequest);
            jsonString = map.writeValueAsString(listOfTickets);

        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return jsonString;
    }

    //Converting List into 
    public String getAllTickets()
    {
        TicketRepository repo = new TicketRepository();
        List<Ticket> listOfTickets = repo.getTickets();

        ObjectMapper map = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = map.writeValueAsString(listOfTickets);

        } catch (JsonGenerationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonString;
    }

    public String viewPendingTickets(){
        TicketRepository repo = new TicketRepository();
        List<Ticket> listOfTickets = repo.viewPendingTickets();

        ObjectMapper map = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = map.writeValueAsString(listOfTickets);

        } catch (JsonGenerationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonString;
    }


}

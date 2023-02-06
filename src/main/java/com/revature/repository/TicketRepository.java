package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Ticket;
import com.revature.model.User;
import com.revature.utils.ConnectionUtil;

/*
    Repository layer is responsible for interacting with a database and sending/receiving information from the database
*/
public class TicketRepository {
    //Create a method in Ticketrepo that allows you to store in a file locally in your computer
    public void Save(Ticket ticket)
    {


        //NEW WAY TO SAVE TO DATABASE INSTEAD
        String sql = "insert into tickets (ticketID, ticketDes, amount, status) values (?, ?, ?, ?)";
        //JDBC API
        try (Connection con = ConnectionUtil.getConnection()) {

            PreparedStatement prstmt = con.prepareStatement(sql);

            //We are replacing the '?' into actual values from the ticket we received
            //Sadly, it uses one-based indexing so 1 is the very first parameter
            prstmt.setInt(1, ticket.getTicketID());
            prstmt.setString(2, ticket.getTicketDes());
            prstmt.setInt(3, ticket.getAmount());
            prstmt.setString(4, ticket.getStatus());



            //prstmt.setInt(5, employee.getSpeed());

            //execute() method does not expect to return anything from the statement
            //executeQuery() method does expect something to result after executing the statement
            prstmt.execute();


        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

    }

    public List<Ticket> getAllTickets() {
        String sql = "select * from tickets";
        List<Ticket> listOfTickets = new ArrayList<Ticket>();

        try (Connection con = ConnectionUtil.getConnection()) {

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            //Mapping information from a table to a DS instead
            while (rs.next()) {
                Ticket newTicket = new Ticket(rs.getInt(1),rs.getString(2),rs.getInt(3));

                listOfTickets.add(newTicket);
            }

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        return listOfTickets;
    }

}

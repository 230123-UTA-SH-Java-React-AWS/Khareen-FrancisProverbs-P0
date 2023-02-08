package com.revature.repository;

import com.revature.GetPreviousTicketsRequest;
import com.revature.model.Ticket;
import com.revature.utils.ConnectionUtil;
import com.revature.utils.UpdateTicketRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketRepository {
    public List<Ticket> getTickets() {
        //this query will call DB to get all contents of users table and store in a list
        String sql = "select * from tickets";
        List<Ticket> listOfTickets = new ArrayList<>();
        Ticket newTicket = new Ticket();
        try (Connection con = ConnectionUtil.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //Mapping information from a table to a DS instead
            while (rs.next()) {
                newTicket.setTicketid(rs.getInt("ticketid"));
                newTicket.setTicketamt(rs.getInt("ticketamt"));
                newTicket.setTicketdes(rs.getString("ticketdes"));
                newTicket.setTicketstatus(rs.getString("ticketstatus"));

                listOfTickets.add(newTicket);// this adds to ticket list as 1 item
            }
            // User listOf = listOfTickets.get(0);
            return listOfTickets;

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    public List<Ticket> viewPendingTickets(){
        String sql = "SELECT * FROM tickets WHERE ticketstatus = 'PENDING'";
        List<Ticket> listOfTickets = new ArrayList<>();
        try (Connection con = ConnectionUtil.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //Mapping information from a table to a DS instead
            while (rs.next()) {
                Ticket newTicket = new Ticket(rs.getInt(1), rs.getInt(2), rs.getString(3));
                listOfTickets.add(newTicket);
            }
            return listOfTickets;

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return null;

    }

    public void createTicket(Ticket ticket) {

        //NEW WAY TO SAVE TO DATABASE INSTEAD
        String sql = "insert into tickets(ticketamt,ticketdes,ticketstatus,ownerid) values (?, ?, ?, ?)";
        //JDBC API
        try (Connection con = ConnectionUtil.getConnection()) {

            PreparedStatement prstmt = con.prepareStatement(sql);
            //We are replacing the '?' into actual values from the pokemon we received
            //Sadly, it uses one-based indexing so 1 is the very first parameter
          //  prstmt.setInt(1, 0);
            prstmt.setInt(1, ticket.getTicketamt());
            prstmt.setString(2, ticket.getTicketdes());
            prstmt.setString(3, ticket.getStatus());
            prstmt.setLong(4, ticket.getOwnerid());


            //execute() method does not expect to return anything from the statement
            //executeQuery() method does expect something to result after executing the statement
            prstmt.execute();


        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

    }

    public void updateTicket(UpdateTicketRequest updateTicketRequest) throws SQLException {
        //error when sending request
        //operator does not exist: integer = character varying
        //  Hint: No operator matches the given name and argument types. You might need to add explicit type casts.
        //  Position
        //create a list to store resultset
        String sql = "UPDATE tickets " + "SET ticketstatus = ? " + "WHERE ticketid = ?";

        //JDBC API
        try (Connection con = ConnectionUtil.getConnection()) {
            PreparedStatement prstmt = con.prepareStatement(sql);
            prstmt.setString(1, updateTicketRequest.getTicketstatus());
            prstmt.setLong(2, updateTicketRequest.getTicketid());

            //execute() method does not expect to return anything from the statement
            //executeQuery() method does expect something to result after executing the statement
           prstmt.executeUpdate();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public List<Ticket> viewPreviousTickets(GetPreviousTicketsRequest previousTicketsRequest) throws SQLException {
        //error when sending request
        //operator does not exist: integer = character varying
        //  Hint: No operator matches the given name and argument types. You might need to add explicit type casts.
        //  Position
        //create a list to store resultset
        List<Ticket> listOfTickets = new ArrayList<>();
        String sql = "select * from tickets WHERE ownerid = '"+previousTicketsRequest.getEmpid()+"'";
        System.out.println(previousTicketsRequest.getEmpid());

        //JDBC API
        try (Connection con = ConnectionUtil.getConnection()) {
            Statement stmt = con.createStatement();

            //execute() method does not expect to return anything from the statement
            //executeQuery() method does expect something to result after executing the statement

            ResultSet rs = stmt.executeQuery(sql);

            //Mapping information from a table to a DS instead
            while (rs.next()) {
                Ticket newTicket = new Ticket();
                newTicket.setTicketid(rs.getInt("ticketid"));
                newTicket.setTicketamt(rs.getInt("ticketamt"));
                newTicket.setTicketdes(rs.getString("ticketdes"));
                newTicket.setTicketstatus(rs.getString("ticketstatus"));
                listOfTickets.add(newTicket);// this adds to ticket list as 1 item
            }
            return listOfTickets;

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }
}



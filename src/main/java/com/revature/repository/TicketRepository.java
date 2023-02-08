package com.revature.repository;

import com.revature.model.Authentication;
import com.revature.model.Ticket;
import com.revature.model.User;
import com.revature.utils.ConnectionUtil;

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
                newTicket.setTicketID(rs.getInt("ticketid"));
                newTicket.setTicketAmt(rs.getInt("ticketamt"));
                newTicket.setTicketDes(rs.getString("ticketdes"));
                newTicket.setTicketStatus(rs.getString("ticketstatus"));

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

    public List<Ticket> viewTickets(){
        String sql = "SELECT * FROM tickets WHERE ticketstats = PENDING";
        List<Ticket> listOfTickets = new ArrayList<>();
        try (Connection con = ConnectionUtil.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //Mapping information from a table to a DS instead
            while (rs.next()) {

                Ticket newTicket = new Ticket(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
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
        String sql = "insert into tickets(ticketid,ticketamt,ticketdes,ticketstatus) values (?, ?, ?, ?)";
        //JDBC API
        try (Connection con = ConnectionUtil.getConnection()) {

            PreparedStatement prstmt = con.prepareStatement(sql);
            //We are replacing the '?' into actual values from the pokemon we received
            //Sadly, it uses one-based indexing so 1 is the very first parameter
            prstmt.setInt(1, ticket.getTicketID());
            prstmt.setInt(2, ticket.getTicketAmt());
            prstmt.setString(3, ticket.getTicketDes());
            prstmt.setString(4, ticket.getStatus());

            //execute() method does not expect to return anything from the statement
            //executeQuery() method does expect something to result after executing the statement
            prstmt.execute();


        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

    }

    public void updateTicket(Ticket newTicket) throws SQLException {
        //error when sending request
        //operator does not exist: integer = character varying
        //  Hint: No operator matches the given name and argument types. You might need to add explicit type casts.
        //  Position
        //create a list to store resultset
        String sql = "UPDATE tickets " + "SET ticketstatus = ? " + "WHERE ticketid = ?";

//        st = con.createStatement();
//        ResultSet rs = st.executeQuery("SELECT * FROM tickets WHERE ticketstats != PENDING");
//        while (!rs.next()) {
//            /*
//            *store to variable and condition will be that if the set contains tickets with approved or denied
//            * the employee cannot update the tickets
//            * */
//        }
//        rs.close();
//        st.close();


        //JDBC API
        try (Connection con = ConnectionUtil.getConnection()) {

            PreparedStatement prstmt = con.prepareStatement(sql);

            prstmt.setInt(1, newTicket.getTicketID());
            prstmt.setString(2, newTicket.getStatus());

            //execute() method does not expect to return anything from the statement
            //executeQuery() method does expect something to result after executing the statement
            prstmt.executeUpdate();

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}



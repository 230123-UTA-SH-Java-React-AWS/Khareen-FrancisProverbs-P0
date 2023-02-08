package com.revature.model;
import com.revature.TicketStatus;

import java.util.*;


public class Ticket {
    public int ticketID;

    public int ticketAmt; //ticket amount
    public String ticketDes; //ticket description

    public String ticketStatus;

    public Ticket(int ticketID, int ticketAmt, String ticketDes, String ticketStatus) {
        this.ticketID = ticketID;
        this.ticketAmt = ticketAmt;
        this.ticketDes = ticketDes;
        this.ticketStatus = "PENDING";
    }

    public Ticket() {
    }
    //Constructor to initialize variables


    public String getStatus() {
        return ticketStatus;

    }
    public void setTicketStatus(String ticketStatus){
        this.ticketStatus = ticketStatus;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public int getTicketAmt() {
        return ticketAmt;
    }

    public void setTicketAmt(int ticketAmt) {
        this.ticketAmt = ticketAmt;
    }

    public String getTicketDes() {
        return ticketDes;
    }

    public void setTicketDes(String ticketDes) {
        this.ticketDes = ticketDes;
    }

    public String getDefaultStatus() {
        return ticketStatus;
    }


}
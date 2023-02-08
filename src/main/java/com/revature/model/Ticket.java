package com.revature.model;


public class Ticket {
    public long ticketid;

    public int ticketamt; //ticket amount
    public String ticketdes; //ticket description

    public String ticketstatus = "PENDING";

    public long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(long ownerid) {
        this.ownerid = ownerid;
    }

    public long ownerid;

    public Ticket(long ticketid, int ticketamt, String ticketdes) {
        this.ticketid = ticketid;
        this.ticketamt = ticketamt;
        this.ticketdes = ticketdes;
    }
    public Ticket( int ticketamt, String ticketdes, long ownerid) {
        this.ticketamt = ticketamt;
        this.ticketdes = ticketdes;
        this.ownerid = ownerid;
    }


    public Ticket() {
    }
    //Constructor to initialize variables


    public String getStatus() {
        return ticketstatus;

    }
    public void setTicketstatus(String ticketstatus){
        this.ticketstatus = ticketstatus;
    }

    public long getTicketid() {
        return ticketid;
    }

    public void setTicketid(int ticketid) {
        this.ticketid = ticketid;
    }

    public int getTicketamt() {
        return ticketamt;
    }

    public void setTicketamt(int ticketamt) {
        this.ticketamt = ticketamt;
    }

    public String getTicketdes() {
        return ticketdes;
    }

    public void setTicketdes(String ticketdes) {
        this.ticketdes = ticketdes;
    }

    public String getDefaultStatus() {
        return ticketstatus;
    }


}
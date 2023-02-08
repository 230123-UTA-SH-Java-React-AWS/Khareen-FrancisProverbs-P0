package com.revature.utils;

public class UpdateTicketRequest {
    public long getTicketid() {
        return ticketid;
    }

    public void setTicketid(long ticketid) {
        this.ticketid = ticketid;
    }

    public UpdateTicketRequest() {
    }

    public String getTicketstatus() {
        return tickestatus;
    }

    public void setTicketstatus(String tickestatus) {
        this.tickestatus = tickestatus;
    }

    public long ticketid;
    public String tickestatus;
    public UpdateTicketRequest(long ticketid, String tickestatus) {
        this.ticketid = ticketid;
        this.tickestatus = tickestatus;
    }
}

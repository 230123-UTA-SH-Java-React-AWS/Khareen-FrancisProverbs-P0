package com.revature.model;
import com.revature.TicketStatus;

import java.util.*;


public class Ticket {

    public int amount; //ticket amount
    public String ticketDes; //ticket description
    //private String status = "Pending"; //ticket default status
    public int ticketID;

    TicketStatus defaultStatus = TicketStatus.PENDING;//enum used to set default ticket status
    //Constructor to initialize variables
    public Ticket(int amount, String ticketDes, int ticketID){
        this.amount = amount;
        this.ticketDes = ticketDes;
        this.ticketID = ticketID;
    }
    public int getAmount(){
        return amount;
    }

    public int getTicketID() {
        return ticketID;
    }

    public String getTicketDes(){
        return ticketDes;
    }

    public void TicketPrompt(){

        System.out.println("Would you like to submit a ticket? Please enter yes or no");
        Scanner stringScanner = new Scanner(System.in); //Scanner keyword creates an instance of scanner class to accept input
        String prompt = stringScanner.next().toUpperCase(Locale.ROOT);
        System.out.println(prompt);


        if(prompt.equals("YES")){
            System.out.println("Ticket submitted");
            System.out.println("Ticket status: "+ defaultStatus);
        } else{
            //TODO
            //end program
        }

    }

    public String getStatus() {
        return defaultStatus.name();

    }
}
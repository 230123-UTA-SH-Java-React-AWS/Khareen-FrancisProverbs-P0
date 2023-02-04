package com.revature.Model;
import com.revature.TicketStatus;

import java.util.*;


public class Ticket {

    private int amount; //ticket amount
    private String des; //ticket description
   // private String status = "Pending"; //ticket default status

    TicketStatus defaultStatus = TicketStatus.PENDING;//enum used to set default ticket status


    //Constructor to initialize variables
    public Ticket(int amount, String des){
        this.amount = amount;
        this.des = des ;
    }

    public Ticket() {

    }

    public void TicketPrompt(){

        System.out.println("Would you like to submit a ticket? Please enter yes or no");
        Scanner stringScanner = new Scanner(System.in); //Scanner keyword creates an instance of scanner class to accept input
        String prompt = stringScanner.next().toUpperCase(Locale.ROOT);
        System.out.println(prompt);


        if(prompt == "YES"){
            System.out.println("Ticket submitted");
            System.out.println("Ticket status: "+ defaultStatus);
        } else{
            //TODO
            //end program
        }

    }

}
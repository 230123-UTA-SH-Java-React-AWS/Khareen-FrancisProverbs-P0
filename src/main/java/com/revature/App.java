package com.revature;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

import com.revature.controller.TicketController;
import com.revature.model.Ticket;
import com.revature.model.User;
import com.revature.repository.AuthRepository;
import com.revature.repository.TicketRepository;
import com.sun.net.httpserver.HttpServer;



/**
 * Hello world!
 */
public final class App {
    public App() {
    }
    public static User loginPrompt(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter email address in format abc@defg.com");
        String email = scanner.nextLine();
        System.out.println("Please enter your name.");
        String username = scanner.nextLine();
        System.out.println();
        System.out.println("Please enter password");
        String password = scanner.nextLine();
        System.out.println();


        AuthRepository authRepo = new AuthRepository();
        User currentUSer = authRepo.getUser(email,password);//gets current user password from authrepo

        //compares credentials entered to the credentials form database for login access
        if (Objects.equals(username, email) && Objects.equals(password, currentUSer.getPasswd())){
            //TODO
            //message to verify successful login
            System.out.println("You have successfully logged in");
            return currentUSer;

            //ticket menu

        }else{
            System.out.println("Incorrect username or password. Please reenter correct login credentials");
            return loginPrompt();
        }
    }

    private static User registerPrompt(String role){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter email address in format abc@defg.com");
        String email = scanner.nextLine();
        System.out.println("Please enter your name.");
        String username = scanner.nextLine();
        System.out.println();
        System.out.println("Please enter password");
        String password = scanner.nextLine();
        System.out.println();

        AuthRepository authRepo = new AuthRepository();
        return  authRepo.createUser(email,password,username,0,role);//sets current user
    }



    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws Exception{
        System.out.println("Starting backend server...");

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/employee/login", new TicketController());
        server.createContext("/manager/register", new TicketController());

        server.setExecutor(null);
        server.start();

//
        User currentUser = getUser();
        next();

    }


    public static User getUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you a new user YES or NO");
        String choice = scanner.nextLine().toUpperCase(Locale.ROOT);
        if (choice.equals("YES")){
            return registerPrompt("employee");
        }else if(choice.equals("NO")){
            return loginPrompt();
        }else{
            return getUser();
        }

        //next();
    }

    private static void ticketPrompt(){
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine().toUpperCase();

        System.out.println("Please enter amount.");
        String amount = scanner.nextLine();
        System.out.println("Please enter ticket description.");
        String ticketDes = scanner.nextLine();
        System.out.println();

    }

    private static void viewTickets(){
        //TODO
        TicketRepository ticketrepo = new TicketRepository();
        List<Ticket> listOfTickets = ticketrepo.getAllTickets();
        //this will display all tickets
        for (Ticket ticket : listOfTickets) {
            System.out.println(ticket.getTicketDes());
        }
        //display tickets
    }
    private static void next(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select A to submit ticket or B to view all tickets ");
        String option = scanner.nextLine().toUpperCase();
        if (option.equals("A")){
            ticketPrompt();
        }else if(option.equals("B")){
            viewTickets();
        }else{
            next();
        }

    }
}

///TODO
/*
Manager implementation add / den ticket
* */
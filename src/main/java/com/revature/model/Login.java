package com.revature.model;

import com.revature.repository.AuthRepository;

import java.util.Objects;
import java.util.Scanner;

public class Login {
    private String email;
    private String pass;
    //creat setters and getters

    public Login (String email, String pass){
        this.email = email;
        this.pass = pass;

    }
    //loginmethod
    public void loginPrompt(){
        System.out.println("Please enter email address in format abc@defg.com");
        String username = String.valueOf(new Scanner(System.in));
        System.out.println();
        System.out.println("Please enter password");
        String password = String.valueOf(new Scanner(System.in));
        System.out.println();




        if (Objects.equals(username, email) && Objects.equals(password, pass)){
            //TODO
            //message to verify successful login
            System.out.println("You have successfully logged in");
            //creates new authrepo object to login
            AuthRepository authRepo = new AuthRepository();
            authRepo.getUser(email,pass);

            //ticket menu

        }else{
            System.out.println("Incorrect username or password. Please reenter correct login credentials");
            loginPrompt();
        }


    }
    private void registerPrompt(String role){

        System.out.println("Please enter email address in format abc@defg.com");
        String email = String.valueOf(new Scanner(System.in));
        System.out.println("Please enter your name.");
        String username = String.valueOf(new Scanner(System.in));
        System.out.println();
        System.out.println("Please enter password");
        String password = String.valueOf(new Scanner(System.in));
        System.out.println();

        AuthRepository authRepo = new AuthRepository();
        authRepo.createUser(email,password,username,0,role);


    }

}



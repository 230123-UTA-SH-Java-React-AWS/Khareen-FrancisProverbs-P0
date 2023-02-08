package com.revature.service;

import java.io.IOException;

import com.revature.model.Authentication;
import com.revature.model.User;
import com.revature.repository.AuthRepository;

import java.util.List;


import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.util.ISO8601Utils;

/*
    The service layer is responsible for hold behavior driven classes
    It might have further validation or information process within the service
*/
public class AuthService {


    public void createUser(String userJson)
    {
        AuthRepository repo = new AuthRepository();
        //Conversion from string to pokemon obj here?
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(userJson);
        System.out.println();

        try {
            User newUser = mapper.readValue(userJson, User.class);
            repo.createUser(newUser);

        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Converting List into 
    public String getAllUsers()
    {
        AuthRepository repo = new AuthRepository();
        List<User> listOfUsers = repo.getAllUsers();
        ObjectMapper mapper = new ObjectMapper();

        ObjectMapper map = new ObjectMapper();
        String jsonString = "";

        try {
            jsonString = map.writeValueAsString(listOfUsers);//store list of users to json string

        } catch (JsonGenerationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonString;
    }

    public String authenticateUser(String authJson) {
        AuthRepository repo = new AuthRepository();
        //Conversion from string to pokemon obj here?
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(authJson);

        try {
            Authentication loginUser = mapper.readValue(authJson, Authentication.class);
            repo.loginUser(loginUser);

        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "login successfull";
    }

}

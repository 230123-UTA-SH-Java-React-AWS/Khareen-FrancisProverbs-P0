package com.revature.repository;

import com.revature.model.User;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthRepository {
    public User getUser(String email, String pass){
        //this query will call DB to get email and password for auth
        String sql = "select * from user where email ="+email+", pass ="+pass;
        List<User> listOfTickets = new ArrayList<User>();


        try (Connection con = ConnectionUtil.getConnection()) {

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            //Mapping information from a table to a DS instead
            while (rs.next()) {
                User newUser = new User(rs.getString(1),rs.getString(3),rs.getString(4),rs.getInt(2),rs.getString(5));


                listOfTickets.add(newUser);
            }
            //
            User currentUser = listOfTickets.get(0);
            return currentUser;

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return null;

    }
    public User createUser(String email, String pass, String name, int id,String role){

        //this query will create a new user and save to DB
        String sql = "insert into user(email,pass,username,userid,role) values (?, ?, ?, ?)"; //add role
        //JDBC API
        try (Connection con = ConnectionUtil.getConnection()) {

            PreparedStatement prstmt = con.prepareStatement(sql);
            System.out.println(con);

            //We are replacing the '?' into actual values from the user we received
            //it uses one-based indexing so 1 is the very first parameter
            prstmt.setString(1, email);
            prstmt.setString(2, pass);
            prstmt.setString(3, name);
            prstmt.setInt(4, id);
            prstmt.setString(5, role);

            //execute() method does not expect to return anything from the statement
            //executeQuery() method does expect something to result after executing the statement
            prstmt.execute();

            return new User(name,email,pass,id,role);


        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }


        return null;
    }
}

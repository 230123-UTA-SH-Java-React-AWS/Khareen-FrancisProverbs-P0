package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.User;
import com.revature.utils.ConnectionUtil;

/*
    Repository layer is responsible for interacting with a database and sending/receiving information from the database
*/
public class UserRepository {
    //Create a method in UserRepository that allows you to store in a file locally in your computer
    public void Save(User user)
    {


        //NEW WAY TO SAVE TO DATABASE INSTEAD
        String sql = "insert into user (userID, userID, email, password,role) values (?, ?, ?, ?,?)";
        //JDBC API
        try (Connection con = ConnectionUtil.getConnection()) {

            PreparedStatement prstmt = con.prepareStatement(sql);

            //We are replacing the '?' into actual values from the employee we received
            //Sadly, it uses one-based indexing so 1 is the very first parameter
            prstmt.setString(1, user.userName());
            prstmt.setInt(2, user.userID());
            prstmt.setString(3, user.getEmail());
            prstmt.setString(4, user.getPasswd());
            prstmt.setString(4, user.getRole());

            //prstmt.setInt(5, employee.getSpeed());

            //execute() method does not expect to return anything from the statement
            //executeQuery() method does expect something to result after executing the statement
            prstmt.execute();


        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

    }

    public List<User> getAllEmployees() {
        String sql = "select * from user";
        List<User> listOfTickets = new ArrayList<User>();

        try (Connection con = ConnectionUtil.getConnection()) {

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            //Mapping information from a table to a DS instead
            while (rs.next()) {
                User newUser = new User(rs.getString(1),rs.getString(3),rs.getString(4),rs.getInt(2),rs.getString(5));


                listOfTickets.add(newUser);
            }

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        return listOfTickets;
    }

}

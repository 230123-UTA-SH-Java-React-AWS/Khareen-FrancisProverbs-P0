package com.revature.repository;

import com.revature.model.Authentication;
import com.revature.model.User;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthRepository {
    public List<User> getAllUsers() {
        //this query will call DB to get all contents of users table and store in a list
        String sql = "select * from users";
        List<User> listOfUsers = new ArrayList<User>();
        try (Connection con = ConnectionUtil.getConnection()) {

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            //Mapping information from a table to a DS instead
            while (rs.next()) {
                User newUser = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                listOfUsers.add(newUser);
            }
            // User listOf = listOfUsers.get(0);
            return listOfUsers;

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return null;

    }

    public void createUser(User user) {
        //NEW WAY TO SAVE TO DATABASE INSTEAD
        String sql = "insert into users(empname,empemail,emppswd,emprole) values (?, ?, ?, ?)";
        //JDBC API
        try (Connection con = ConnectionUtil.getConnection()) {

            PreparedStatement prstmt = con.prepareStatement(sql);

            //We are replacing the '?' into actual values from the pokemon we received
            //Sadly, it uses one-based indexing so 1 is the very first parameter
            prstmt.setString(1, user.getEmpname());
            prstmt.setString(2, user.getEmpemail());
            prstmt.setString(3, user.getEmppswd());
            prstmt.setString(4, user.getEmprole());
            //prstmt.setInt(5, pokemon.getSpeed());

            //execute() method does not expect to return anything from the statement
            //executeQuery() method does expect something to result after executing the statement
            prstmt.execute();


        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

    }

    public String loginUser(Authentication loginUser) {
        var message = "user found";
        var email = loginUser.getEmpemail();
        var pswd = loginUser.getEmppswd();
        String sql = "SELECT * FROM users";

        try (Connection con = ConnectionUtil.getConnection()) {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            boolean userFound = false;

            //Mapping information from a table to a DS instead
            while (rs.next()) {
               // User newUser = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));

                String empName = rs.getString(1);
                String empEmail = rs.getString(2);
                String empPswd = rs.getString(3);
                String empRole = rs.getString(4);
               // int empID = rs.getInt(5);

                if(empEmail.matches(email) && empPswd.matches(pswd)){
                    userFound = true;
                }
               // System.out.println(empEmail + "     " + empPswd);
            }
            if(userFound){
                System.out.println(message);
            }else{
                System.out.println("This is not a valid user");
            }

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return email;
    }
}





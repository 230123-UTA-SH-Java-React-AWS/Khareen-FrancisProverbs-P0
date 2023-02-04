package com.revature.Model;

public class Manager extends Employee {
    private String title;

        //constructor
    public Manager(String empName, String email, String passwd, int empID) {
        super(empName, email, passwd, empID);
    }
}

package com.revature.Model;

/*
    Model layer is responsible for hold stateful objects
    objects that have information that differs from another object from the same class
*/

import java.util.ArrayList;

public class Employee {

    //Uniquely identifiable field that is numeric
    private int empID;

    //Fields that will be useful to uniquely identify this object
    private String empName;
    private String email;
    private String passwd;
    //private ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    //What data structure allows us to add multiple things
    //???????????????????????????????equivalent in project???????????

    public Employee(String empName, String email, String passwd, int empID) {
        // this.abilities = new ArrayList<>(); //this must be tickets
        // the sql requires a join and where clause
        this.empID = empID;
        this.empName = empName;
        this.email = email;
        this.passwd = passwd;
    }

    //right click, click source action, click generate getters and setters, select all fields, hit ok
    public int getemployeeID() {
        return empID;
    }

    public void setemployeeID(int employeeID) {
        this.empID = employeeID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    //     public List<Ability> getAbilities() {
    //         return abilities;
    //     }

    //     public void setAbilities(List<Ability> abilities) {
    //         this.abilities = abilities;
    //     }
}
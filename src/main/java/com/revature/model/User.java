package com.revature.model;

/*
    Model layer is responsible for hold stateful objects
    objects that have information that differs from another object from the same class
*/

public class User {
    private String empName;
    private String empEmail;
    private String empPswd;

    private String empRole;
    private int empID;

    public User(){

    }

    public User(String empName, String empEmail, String empPswd, String empRole, int empID) {
        this.empName = empName;
        this.empEmail = empEmail;
        this.empPswd = empPswd;
        this.empRole = empRole;
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpPswd() {
        return empPswd;
    }

    public void setEmpPswd(String empPswd) {
        this.empPswd = empPswd;
    }

    public String getEmpRole() {
        return empRole;
    }

    public void setEmpRole(String empRole) {
        this.empRole = empRole;
    }

    public int getEmpID() {
        return empID;
    }

}
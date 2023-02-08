package com.revature.model;

/*
    Model layer is responsible for hold stateful objects
    objects that have information that differs from another object from the same class
*/

public class User {
    private String empname;
    private String empemail;
    private String emppswd;

    private String emprole = "Employee";

    private long empid;

    public User(){

    }

    public User(String empname, String empemail, String emppswd, int empid) {
        this.empname = empname;
        this.empemail = empemail;
        this.emppswd = emppswd;
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpemail() {
        return empemail;
    }

    public void setEmpemail(String empemail) {
        this.empemail = empemail;
    }

    public String getEmppswd() {
        return emppswd;
    }

    public void setEmppswd(String emppswd) {
        this.emppswd = emppswd;
    }

    public String getEmprole() {
        return emprole;
    }

    public void setEmprole(String emprole) {
        this.emprole = emprole;
    }

    public long getEmpid() {
        return empid;
    }

}
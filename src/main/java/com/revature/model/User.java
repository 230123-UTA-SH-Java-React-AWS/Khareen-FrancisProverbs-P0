package com.revature.model;

/*
    Model layer is responsible for hold stateful objects
    objects that have information that differs from another object from the same class
*/

public class User {

    //Uniquely identifiable field that is numeric
    private int empID;

    //Fields that will be useful to uniquely identify this object
    private String empName;
    private String email;
    private String passwd;

    private String role;
    //private ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    //What data structure allows us to add multiple things
    //???????????????????????????????equivalent in project???????????

    public User(String empName, String email, String passwd, int empID, String role) {
        // the sql requires a join and where clause
        this.empID = empID;
        this.empName = empName;
        this.email = email;
        this.passwd = passwd;
        this.role = role;
    }

    //right click, click source action, click generate getters and setters, select all fields, hit ok
    public int userID() {
        return empID;
    }

    public void setemployeeID(int employeeID) {
        this.empID = employeeID;
    }

    public String userName() {
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

    public String getRole() { return role;
    }

    public void setRole(String role){ this.role=role;


    }
    //     public List<Ability> getAbilities() {
    //         return abilities;
    //     }

    //     public void setAbilities(List<Ability> abilities) {
    //         this.abilities = abilities;
    //     }
}
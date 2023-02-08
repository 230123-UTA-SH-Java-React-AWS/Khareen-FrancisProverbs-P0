package com.revature.model;

public class Authentication {

    private String email;
    private String pswd;

    public Authentication(String email, String pswd) {
        this.email = email;
        this.pswd = pswd;
    }

    public Authentication() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
}

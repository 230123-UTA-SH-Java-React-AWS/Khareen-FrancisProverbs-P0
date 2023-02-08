package com.revature.model;

public class Authentication {

    private String empemail;
    private String emppswd;

    public Authentication(String empemail, String emppswd) {
        this.empemail = empemail;
        this.emppswd = emppswd;
    }

    public Authentication() {
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
}

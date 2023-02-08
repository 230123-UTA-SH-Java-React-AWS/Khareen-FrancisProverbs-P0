package com.revature;

public class GetPreviousTicketsRequest {
    public long empid;

    public GetPreviousTicketsRequest() {
    }

    public GetPreviousTicketsRequest(long empid) {
        this.empid = empid;
    }

    public long getEmpid() {
        return empid;
    }

    public void setEmpid(long empid) {
        this.empid = empid;
    }
}

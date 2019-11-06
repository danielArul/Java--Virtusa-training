package com.example.emsui2.model;

public class Employee {
    private Integer eid;
    private String name;
    private String email;
    private String desig;

    public Employee() {
    }

    public Employee(Integer eid, String name, String email, String desig) {
        this.eid = eid;
        this.name = name;
        this.email = email;
        this.desig = desig;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }
}

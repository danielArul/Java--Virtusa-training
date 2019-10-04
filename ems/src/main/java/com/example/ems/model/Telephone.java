package com.example.ems.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;
    private String number;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Employee employee;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Employee getStudent() {
        return employee;
    }

    public void setStudent(Employee employee) {
        this.employee = employee;
    }
}
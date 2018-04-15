package com.mycorp.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalcLog implements Serializable {

    private int id;
    private double param1;
    private double param2;
    private double result;
    private String operation;
    private Date creationDate;


    public CalcLog(double param1, double param2, double result, String operation) {
        this.param1 = param1;
        this.param2 = param2;
        this.result = result;
        this.operation = operation;
    }

    public CalcLog(int id, double param1, double param2, double result, String operation, Date creationDate) {
        this.id = id;
        this.param1 = param1;
        this.param2 = param2;
        this.result = result;
        this.operation = operation;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getParam1() {
        return param1;
    }

    public void setParam1(double param1) {
        this.param1 = param1;
    }

    public double getParam2() {
        return param2;
    }

    public void setParam2(double param2) {
        this.param2 = param2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public String getCreationDateAsString() {
        return creationDate != null ? new SimpleDateFormat("dd.MM.yyyy hh:mm:ss").format(creationDate) : "";
    }
}
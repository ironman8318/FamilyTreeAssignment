package com.familytree.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SimpleDate {
    private int date;
    private int month;
    private int year;

    public SimpleDate(int year) {
        this.year = year;
    }

    public int getDate() {
        return date;
    }

    public SimpleDate(int date, int month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public SimpleDate(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public void setDate(int year) {
        this.date = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;

    }

    public Date generateDate() throws ParseException {
        String s = this.date+"/"+this.month+"/"+this.year;
        return new SimpleDateFormat("dd/MM/yyyy").parse(s);
    }



}


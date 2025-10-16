package com.YearUpUnited;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class transactions {// what i will be using to set the transactions and later save into csv
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public double getAmount() {
        return amount;
    }

    public transactions(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public String addToCsv() {
        return String.format("%s|%s|%s|%s|%.2f", date, time, description, vendor, amount);
    }

    @Override//this will be what will then print out the transaction
    public String toString() {
        return "\n" + date + "|" + time + "|" + description + "|" + vendor + "|" + amount ;
    }
}

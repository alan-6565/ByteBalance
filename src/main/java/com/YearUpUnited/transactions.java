package com.YearUpUnited;

import java.time.LocalDate;
import java.time.LocalTime;//importing the time that i need

public class transactions {// what i will be using to set the transactions and later save into csv
    private LocalDate date;
    private String time;
    private String description;
    private String vendor;
    private double amount;

    public transactions(LocalDate date, String time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    @Override//this will be what will then print out the transaction
    public String toString() {
        return "\n" + date + "|" + time + "|" + description + "|" + vendor + "|" + amount ;
    }
}

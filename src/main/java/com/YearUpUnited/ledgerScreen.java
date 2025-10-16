package com.YearUpUnited;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class ledgerScreen {

    private static final String fileName = "transactions.csv";
    private static final List<transactions> transaction = reader();

    public static void showLedgerMenu(Scanner sc){
        boolean running = true;

        while (running){
            System.out.println("=====================");
            System.out.println("     LEDGER HOME     ");
            System.out.println("=====================");
            System.out.println("A) All Entries");
            System.out.println("D) All Deposits");
            System.out.println("P) All Payments");
            System.out.println("R) Reports");
            System.out.println("X) Back to Home");
            System.out.println("Choose: ");
            String choice = sc.nextLine().toUpperCase().trim();

            switch (choice) {
                case "A":
                    displayAll(transaction);
                    break;
                case "D":
                    System.out.println("All Deposits");
                    break;
                case "P":
                    System.out.println("All Payments");
                    break;
                case "R":
                    System.out.println("Reports");
                    break;
                case "X":
                    System.out.println("Back To Home");
                    running = false;

            }
        }
    }
    private static List<transactions> reader(){
        List<transactions> list = new ArrayList<transactions>();
        try {
            // create a FileReader object connected to the File
            FileReader fileReader = new FileReader(fileName);
            // create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            // read until there is no more data
            while((input = bufReader.readLine()) != null) {
                //2023-04-15|10:13:25|ergonomic keyboard|Amazon|-89.50
                String[] info = input.split("\\|");
                LocalDate date = LocalDate.parse(info[0]);
                LocalTime time = LocalTime.parse(info[1]);
                String description = info[2];
                String vendor = info[3];
                double amount = Double.parseDouble(info[4]);

                transactions entry = new transactions(date, time, description, vendor, amount);
                list.add(entry);
            }
            // close the stream and release the resources
            bufReader.close();
        }
        catch(IOException e) {
            // display stack trace if there was an error
            e.printStackTrace();
        }
        return list;
    }

    private static void displayAll(List<transactions> list) {
        for(var i = 0; i < list.size(); i++){
            System.out.println(list.get(i).toString());
        }
    }
}

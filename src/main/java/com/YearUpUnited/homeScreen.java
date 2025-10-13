package com.YearUpUnited;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class homeScreen {
    public static void showHomeScreen(){
        Scanner sc = new Scanner(System.in);
        boolean running = true;


        while(running) {
            System.out.println("//Welcome Fellow Ledger//");
            System.out.println("To get started pick an option from the following:");
            System.out.println("D) Add a Deposit");
            System.out.println("P) Make a Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.println("Input: ");
            String input = sc.nextLine().toUpperCase().trim();

            switch (input) {
                case "D":
                    addDeposit();
                    break;
                case "P":
                    System.out.println("Payment Completed");
                    break;
                case "L":
                    System.out.println("Taking you to Ledger");
                    break;
                case "X":
                    System.out.println("Goodbye");
                    running = false;
                    break;
            }
        }
    }

    private static void addDeposit() {
        System.out.println("Enter deposit amount:");
        try {
            Scanner sc = new Scanner(System.in);
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            String formattedTime = time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));//i added the time and format to keep the decimals from appearing

            String description = "Deposit";
            String vendor = "Shikamaru Ledger";

            double amount = sc.nextDouble();

            transactions t = new transactions(date, formattedTime, description, vendor, amount);
            sc.nextLine();
            try (FileWriter writer = new FileWriter("transactions.csv", true)) {
                writer.write(t.toString());
            }

            System.out.println("Deposit saved");

        } catch (IOException e) {
            System.out.println("Could not save");
        }

    }

}

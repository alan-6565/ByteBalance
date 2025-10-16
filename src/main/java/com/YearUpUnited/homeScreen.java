package com.YearUpUnited;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static com.YearUpUnited.ledgerScreen.showLedgerMenu;

public class homeScreen {

    private static final String fileName = "transactions.csv";
    private static final DateTimeFormatter TimeFormatted = DateTimeFormatter.ofPattern("HH:mm:ss");



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
            String input = sc.nextLine().trim().toUpperCase();

            switch (input) {
                case "D":
                    addDeposit(sc);
                    break;
                case "P":
                    addPayment(sc);
                    break;
                case "L":
                    ledgerScreen.showLedgerMenu(sc);
                    break;
                case "X":
                    System.out.println("Goodbye");
                    running = false;

            }
        }
        sc.close();

    }



    private static void addDeposit(Scanner sc) {

        try {
            System.out.println("Enter deposit amount:");
            double amount = sc.nextDouble();
            sc.nextLine();

            if (amount <= 0){
                System.out.println("Amount must be positive.");
                return;
            }
            String description = "Deposit";
            String vendor = "Shikamaru Ledger";


            LocalDate date = LocalDate.now();
            String time = LocalTime.now().format(TimeFormatted);

            transactions t = new transactions(date, time, description, vendor, amount);
            try (BufferedWriter br = new BufferedWriter(new FileWriter(fileName, true))) {
                br.write(t.addToCsv());
                br.newLine();
            }

            System.out.println("Deposit saved");
            System.out.println(t);

        } catch (NumberFormatException e){
            System.out.println("That wasn’t a valid number.");
        }
        catch (IOException e) {
            System.out.println("Could not save");
        }

    }

    private static void addPayment(Scanner sc) {
        try {
            System.out.println("Enter the amount you would like to pay: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            if (amount <= 0) {
                System.out.println("Amount must be positive.");
                return;
            }

            amount = (amount - amount) - amount;

            System.out.println("Who will this payment be for: ");
            String vendor = sc.nextLine().trim();

            System.out.println("Description (Optional): ");
            String description = sc.nextLine().trim();

            if (description.equals("")) {
                description = "Payment";
            }

            LocalDate date = LocalDate.now();
            String time = LocalTime.now().format(TimeFormatted);

            transactions t = new transactions(date, time, description, vendor, amount);

            try (BufferedWriter br = new BufferedWriter(new FileWriter(fileName, true))) {
                br.write(t.addToCsv());
                br.newLine();
            }

            System.out.println("Payment Completed");
            System.out.println(t);


        }catch (NumberFormatException e){
            System.out.println("That wasn’t a valid number.");
        }
        catch (IOException e) {
            System.out.println("Could not save");
        }

    }
}

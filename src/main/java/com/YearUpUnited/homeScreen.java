package com.YearUpUnited;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static com.YearUpUnited.ledgerScreen.showLedgerMenu;
import static com.YearUpUnited.start.simulateLoading;

public class homeScreen {

    private static final String fileName = "transactions.csv";
    private static final DateTimeFormatter TimeFormatted = DateTimeFormatter.ofPattern("HH:mm:ss");



    public static void showHomeScreen(){
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while(running) {
            System.out.println("===============================================");
            System.out.println("   🌀 Shikamaru’s Shadow Ledger 🌀");
            System.out.println("===============================================");
            System.out.println("\"What a drag... But let’s get this accounting done.\"");
            System.out.println("Choose your next move, genius ninja:");
            System.out.println("D) 💰 Add a Deposit");
            System.out.println("P) 💸 Make a Payment");
            System.out.println("L) 📜 Open the Ledger");
            System.out.println("X) 🍃 Call it a Day (Exit)");
            System.out.print("Input: ");
            String input = sc.nextLine().trim().toUpperCase();

            switch (input) {
                case "D":
                    simulateLoading("Entering The Deposit Page");
                    addDeposit(sc);
                    break;
                case "P":
                    simulateLoading("Entering The Payment Page");
                    addPayment(sc);
                    break;
                case "L":
                    simulateLoading("Opening The Ledger");
                    ledgerScreen.showLedgerMenu(sc);
                    break;
                case "X":
                    System.out.println("Come Back Soon");
                    running = false;

            }
        }


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
            System.out.println("Enter Deposit Description: ");
            String description = sc.nextLine();

            System.out.println("Enter Vendor : ");
            String vendor = sc.nextLine();


            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now().truncatedTo(java.time.temporal.ChronoUnit.SECONDS);;
                    //.format(TimeFormatted);

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
            LocalTime time = LocalTime.now().truncatedTo(java.time.temporal.ChronoUnit.SECONDS);;
                    //.format(TimeFormatted);

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

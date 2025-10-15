package com.YearUpUnited;

import java.util.Scanner;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class ledgerScreen {

    private static final String fileName = "transactions.csv";

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
                    displayAll();
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

    private static void displayAll() {

    }
}

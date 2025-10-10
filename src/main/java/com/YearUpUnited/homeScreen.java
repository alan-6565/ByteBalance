package com.YearUpUnited;

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
            String input = sc.nextLine().toUpperCase().trim();

            switch (input) {

                case "D":
                    System.out.println("You have deposited xyz");
                    break;
                case "P":
                    System.out.println("Payment Completed");
                    break;
                case "L":
                    System.out.println("Taking you to Ledger");
                    break;
                case "X":
                    System.out.println("Goodbye");
            }
        }
    }

}

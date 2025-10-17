package com.YearUpUnited;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reports {

    private static final String fileName = "transactions.csv";
    private static final List<transactions> transaction = reader();

    public static void showReportsMenu(Scanner sc) {
        boolean running = true;

        while (running) {
            System.out.println("=====================");
            System.out.println("     REPORTS MENU    ");
            System.out.println("=====================");
            System.out.println("1) Month to Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back To Ledger Page");
            System.out.println("H) Back  To Home Page");
            String choice = sc.nextLine().toUpperCase().trim();

            switch (choice) {
                case "1":
                    displayMonthToDate(transaction);
                    break;
                case "2":
                    displayPreviousMonth(transaction);
                    break;
                case "3":
                    displayYearToDate(transaction);
                    break;
                case "4":
                    displayPreviousYear(transaction);
                    break;
                case "5":
                    SearchForVendor(sc, transaction);
                    break;
                case "0":
                    running = false;
                    break;
                case "H":
                    System.out.println("Back To Home");
                    homeScreen.showHomeScreen();
                    break;
            }
        }
    }

    private static List<transactions> reader() {
        List<transactions> list = new ArrayList<transactions>();
        try {
            // create a FileReader object connected to the File
            FileReader fileReader = new FileReader(fileName);
            // create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            // read until there is no more data
            while ((input = bufReader.readLine()) != null) {
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
        } catch (IOException e) {
            // display stack trace if there was an error
            e.printStackTrace();
        }
        return list;
    }

    private static void displayMonthToDate(List<transactions> list) {
        LocalDate today = LocalDate.now();
        int currentMonth = today.getMonthValue();//these will get the current date currently
        int currentYear = today.getYear();

        for (int i = list.size() - 1; i >= 0; i--) {//loops backwards
            transactions t = list.get(i);
            LocalDate date = t.getDate();
            if (date.getYear() == currentYear && date.getMonthValue() == currentMonth) {
                System.out.println(t.toString());
            }
        }
    }

    private static void displayPreviousMonth(List<transactions> list) {
        java.time.LocalDate today = java.time.LocalDate.now();
        java.time.LocalDate prev = today.minusMonths(1);
        int yr = prev.getYear();
        int mo = prev.getMonthValue();

        for (int i = list.size() - 1; i >= 0; i--) {
            java.time.LocalDate d = list.get(i).getDate();
            if (d.getYear() == yr && d.getMonthValue() == mo) {
                System.out.println(list.get(i).toString());
            }
        }
    }

    private static void displayYearToDate(List<transactions> list) {
        int yr = java.time.LocalDate.now().getYear();

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).getDate().getYear() == yr) {
                System.out.println(list.get(i).toString());
            }
        }
    }

    private static void displayPreviousYear(List<transactions> list){
        java.time.LocalDate today = java.time.LocalDate.now();
        java.time.LocalDate prev = today.minusYears(1);
        int yr = prev.getYear();

        for (int i = list.size() - 1; i >= 0; i--) {
            java.time.LocalDate d = list.get(i).getDate();
            if (d.getYear() == yr) {
                System.out.println(list.get(i).toString());
            }
        }
    }

    private static void SearchForVendor(Scanner sc,List<transactions> list){
        System.out.println("Type In Vendor: ");
        String input = sc.nextLine().trim().toLowerCase();

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).getVendor().toLowerCase().contains(input)) {
                System.out.println(list.get(i).toString());
            }
        }
    }
}
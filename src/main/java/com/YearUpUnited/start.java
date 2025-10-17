package com.YearUpUnited;

import java.io.BufferedReader;
import java.io.FileReader;

public class start {
    public static void main(String[] args) {
        homeScreen.showHomeScreen();
    }

    public static void simulateLoading(String message) {
        System.out.println("\n" + message + "...");
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

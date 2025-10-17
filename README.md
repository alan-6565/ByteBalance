# 🌀 Shikamaru Nara’s Shadow Ledger

## 📘 Project Overview
The **Shadow Ledger** is a console-based Java accounting system designed to help users manage their financial transactions — tracking deposits, payments, and generating summary reports — all with a touch of *Naruto’s* tactical flair.  

The program stores and reads all transactions from a `.csv` file and organizes them using Object-Oriented Programming principles.  
It demonstrates structured Java programming, file I/O, and data management in a creative and interactive theme inspired by **Shikamaru Nara** from *Naruto*.

---

## 🧱 Core Features

### 🏠 Home Screen
Main entry point for all user actions.

**Menu Options:**
- **D) Add Deposit** – Record a deposit and save it to the ledger.  
- **P) Make Payment** – Record a payment (negative transaction).  
- **L) Ledger** – View all transaction history.  
- **X) Exit** – End the program.  

Transactions are time-stamped automatically with the current date and time.

---

### 📜 Ledger Screen
Displays stored transactions directly from the `transactions.csv` file.  

**Menu Options:**
- **A) All Entries** – Show every transaction (newest first).  
- **D) Deposits Only** – Filter only positive entries.  
- **P) Payments Only** – Filter only negative entries.  
- **R) Reports** – Access detailed transaction reports.  
- **X) Back to Home** – Return to the main menu.  

All entries are displayed in reverse order (latest to earliest) for convenience.

---

### 📊 Reports Screen
Generates predefined or custom financial reports based on stored transactions.

**Menu Options:**
- **1) Month to Date** – Displays all entries from the current month.  
- **2) Previous Month** – Displays last month’s entries.  
- **3) Year to Date** – Displays all transactions from the current year.  
- **4) Previous Year** – Displays all transactions from the previous year.  
- **5) Search by Vendor** – Finds transactions by vendor name.  
- **0) Back to Ledger** – Return to Ledger screen.  
- **H) Back to Home** – Return to Home screen.  

Each report filters data by comparing the `LocalDate` of each entry against current system time and prints results in descending order.

---

### 💾 File System
All data is stored and read from a **CSV file** named `transactions.csv`.

Each record follows this structure:

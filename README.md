# 🌀 Shikamaru Ledger

## 📘 Project Overview
The **Shadow Ledger** is a console-based Java accounting system designed to help users manage their financial transactions — tracking deposits, payments, and generating summary reports — all with a touch of *Naruto’s* tactical flair.  

The program stores and reads all transactions from a `.csv` file and organizes them using Object-Oriented Programming principles.  
It demonstrates structured Java programming, file I/O, and data management in a creative and interactive theme inspired by **Shikamaru Nara** from *Naruto*.

---

## 🧱 Core Features

### 🏠 Home Screen
Main entry point for all user actions.

**Menu Options:**
  <img width="465" height="390" alt="4909A11D-CAC2-4550-964D-976B637878B2" src="https://github.com/user-attachments/assets/44a2501d-eea6-4d97-ab3b-cb78af397620" />


Transactions are time-stamped automatically with the current date and time.

---

### 📜 Ledger Screen
Displays stored transactions directly from the `transactions.csv` file.  

**Menu Options:**

![AEFD8778-E962-4C7A-A6D0-71ED7C60A7FD](https://github.com/user-attachments/assets/73c7e401-08fd-4670-8db6-8085aa37cb5a)

All entries are displayed in reverse order (latest to earliest) for convenience.

---

### 📊 Reports Screen
Generates predefined or custom financial reports based on stored transactions.

**Menu Options:**
![EDBCE605-2BEA-4B2A-80CD-6BA433E22822](https://github.com/user-attachments/assets/73e95b18-7877-468c-9cd5-ad2cab3fa5b7)


Each report filters data by comparing the `LocalDate` of each entry against current system time and prints results in descending order.

---

### 💾 File System
All data is stored and read from a **CSV file** named `transactions.csv`.
![1B1C1949-9576-40F4-BE61-6AD91F2000E5](https://github.com/user-attachments/assets/fdb54ea7-e6cd-451d-bd3f-143231db4ee2)

Each record follows this structure:

### Interesting Code
i found this code interesting as it was introduced to me by my peer aaron but aswell we had a small view on it in my class its interesting to me as it can create a loading section and pause the code for a few seconds to give the act of the code loading
![5C8BB15B-4ABC-44E3-80D8-A2D615E2EE89](https://github.com/user-attachments/assets/1dc71d3b-4aa9-47d2-9a32-725ba8ee7b99)

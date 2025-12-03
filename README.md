# 🏦 ATM Interface

The ATM Interface is a console-based Java application that simulates basic ATM functionalities such as withdrawing, depositing, transferring funds, and viewing transaction history.
This project follows clean Object-Oriented Programming (OOP) principles and includes enhanced UI elements, encrypted security, and multi-user support.

## Features

###  User Authentication

Login using User ID and PIN

PINs are stored securely using SHA-256 encryption

Supports multiple user accounts

### Banking Operations

Deposit money into your account

Withdraw money with balance validation

Transfer funds to another user

View Transaction History with date & time logs

### Enhanced Console UI

Colored text for better readability

Stylish borders and menu layout

Clear prompts and feedback messages

### System Enhancements

Automatic account number generation

Input validation (numbers only, positive amounts, valid options)

Error handling for invalid inputs

Clean modular code using multiple classes

## 🗂 Project Structure
ATM-Interface/
 ├── Main.java             # Entry point
 ├── ATM.java              # Menu + ATM functions
 ├── User.java             # User details + encrypted PIN
 ├── BankAccount.java      # Balance, transactions, account number
 ├── ConsoleColors.java    # ANSI color codes for styling
 └── Transaction.java      # (Optional) Transaction message class

## Technologies Used

Java (JDK 17+)

IntelliJ IDEA

OOP Concepts

SHA-256 Encryption

ANSI Colors for Console UI

## ▶ How to Run the Project

### 1️⃣ Clone or Download the Repository
git clone <repository-link>

### 2️⃣ Open the Project in IntelliJ IDEA

Go to File → Open

Select the project folder

Ensure Project SDK = Java 17 or above

### 3️⃣ Run the Application

Open Main.java → Click the green Run ▶ button.

### 👥 Default Test Users

You can log in using:

User ID	PIN
user1	1234
user2	5678
asha	9999

Each user has a separate account number, balance, and transaction history.

### 📌 Sample Operations

Login → deposit ₹2000 → withdraw ₹1000 → transfer → view history

Invalid amount/choice handling

Error messages for insufficient balance

Secure login using encrypted PIN checks

## 🎯 Learning Goals

This project helps practice:

Java console application development

Working with classes, objects, and methods

Handling user input & validation

Implementing security (encryption)

Managing lists, loops, and error handling

Creating clean modular code

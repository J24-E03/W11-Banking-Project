package com.bankApp;


import java.io.Serializable;

class SavingsAccount extends BankAccount implements Serializable {

    // Declare a private double variable withdrawalLimit
    private double withdrawalLimit;

    // Define a constructor that takes a double initialBalance and a double withdrawalLimit as parameters
    public SavingsAccount(double initialBalance, double withdrawalLimit) {
        // Assign the parameter withdrawalLimit to the instance variable withdrawalLimit
        this.withdrawalLimit = withdrawalLimit;
    }

    // Override the withdraw method from the BankAccount class
    @Override
    public boolean withdraw(double amount) {
        // Check if the amount to be withdrawn is less than or equal to the withdrawal limit
        if (amount <= withdrawalLimit) {
            // Call the withdraw method of the superclass BankAccount with amount
            super.withdraw(amount);
        } else {
            // Print "Withdrawal limit exceeded." to the console if the amount exceeds the withdrawal limit
            System.out.println("Withdrawal limit exceeded.");
        }
        return false;
    }
} 
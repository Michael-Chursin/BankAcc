package Addons;

import java.util.ArrayList;
import java.util.Date;

public class  Account {
    private int id;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    public Account(){
        id = 0;
        balance = 0;
        dateCreated = new Date();
        annualInterestRate = 0;
    }
    public Account(int num, double bal) {
        id = num;
        balance = bal;
        dateCreated = new Date();
    }
    public int getID() {
        return id;
    }
    public void setID(int num) {
        id = num;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double bal) {
        balance = bal;
    }
    public static double getAnnualInterestRate() {
        return annualInterestRate * 100;
    }
    public static void setAnnualInterestRate(double AIR) {
        annualInterestRate = AIR / 100;
    }
    public Date getDateCreated() {
        return dateCreated;
    }
    public double getMonthlyInterest() {
        double monthlyInterestRate = annualInterestRate / 12;
        return balance * monthlyInterestRate;
    }
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void withdraw(double sum) {
        if(balance - sum > 0) {
            balance -= sum;
            transactions.add(new Transaction('-', sum, balance, "Withdrawal " + sum + "$"));
            System.out.println("Withdrawal successful\n");
        }
        else {
            System.out.println("Not enough money on your account");
            System.out.println("Withdrawal failed\n");
        }
    }
    public void deposit(double sum) {
        balance += sum;
        transactions.add(new Transaction('+', sum, balance, "Depositing " + sum + "$"));
        System.out.println("Deposit successful\n");
    }
}

package Addons;

import java.util.Date;

public class  Account {
    private int id;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated;
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
    public void withdraw(double sum) {
        if(balance - sum > 0) {
            balance -= sum;
        }
        else {
            System.out.println("Not enough money on your account");
        }
    }
    public void deposit(double sum) {
        balance += sum;
    }
}

package Addons;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {
    private double amount;
    private double balance;
    private String description;
    private char type;
    private Date date;
    public Transaction(char t, double a, double b, String desc){
        type = t;
        amount = a;
        balance = b;
        description = desc;
        date = new Date();
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double num) {
        amount = num;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double num) {
        balance = num;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String s) {
        description = s;
    }
    public char getType() {
        return type;
    }
    public Date getDate() {
        return date;
    }
}

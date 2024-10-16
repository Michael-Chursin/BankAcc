package Addons;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class  Account implements Serializable {
    private int id;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated;
    private Date dateInterestCredited;
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
    public Date getDateInterestCredited() {
        return dateCreated;
    }
    public void setBalance(Date DIC) {
        dateInterestCredited = DIC;
    }
    public double getMonthlyInterest() {
        double monthlyInterestRate = annualInterestRate / 12;
        return balance * monthlyInterestRate;
    }
    public void creditMonthlyInterest() {
        double monthlyInterestRate = annualInterestRate / 12;
        dateInterestCredited = new Date();
        balance += getMonthlyInterest();
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
    public static void serializeDataOut(Account acc, String fileName)throws IOException{
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(acc);
        oos.close();
        fos = null;
        oos = null;
    }

    public static void serializeDataOut(Account acc, File f)throws IOException{
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(acc);
        oos.close();
        fos = null;
        oos = null;
    }

    public static Account serializeDataIn(String fileName){
        Account acc;
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fin);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            acc= (Account) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            ois.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fin = null;
        ois = null;
        return acc;
    }

    public static Account serializeDataIn(File f){
        Account acc;
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fin);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            acc= (Account) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            ois.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fin = null;
        ois = null;
        return acc;
    }
}

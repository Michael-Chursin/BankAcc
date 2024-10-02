package Main;

import Addons.Account;


public class Main {
    public static void main(String[] args){
        Account client = new Account(1155, 300000);
        Account.setAnnualInterestRate(6.5);
        client.withdraw(16500);
        client.deposit(50000);
        System.out.println("Balance of client: " + client.getBalance());
        System.out.println("Monthly interest of client: " + client.getMonthlyInterest());
        System.out.println("Date of client's creation: " + client.getDateCreated());
    }
}
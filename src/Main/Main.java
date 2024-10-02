package Main;

import Addons.Account;


public class Main {
    public static void main(String[] args){
        Account client = new Account(1155, 300000);
        Account.setAnnualInterestRate(6.5);
    }
}
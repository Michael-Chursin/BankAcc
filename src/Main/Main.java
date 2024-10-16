package Main;

import Addons.Account;
import Addons.Transaction;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        Account[] clients = new Account[10];
        for(int i = 0; i < 10; i++){
            clients[i] = new Account(i, 10000);
        }
        System.out.println("Input your ID");
        int input = sc.nextInt();
        while(input >= 10){
            System.out.println("Incorrect ID\nInput correct ID");
            input = sc.nextInt();
        }
        int currAcc = input;
        while(input != 5){
            double sum;
            System.out.println("Main menu");
            System.out.println("1::Check on your balance");
            System.out.println("2::Withdraw");
            System.out.println("3::Deposit");
            System.out.println("4::Transactions");
            System.out.println("5::LOG OUT");
            System.out.println("Input menu item");
            input = sc.nextInt();
            switch (input){
                case 1:
                    System.out.println("Your balance: " + clients[currAcc].getBalance());
                    break;
                case 2:
                    System.out.println("Input sum, you want to withdraw:");
                    sum = sc.nextDouble();
                    clients[currAcc].withdraw(sum);
                    break;
                case 3:
                    System.out.println("Input sum, you want to deposit:");
                    sum = sc.nextDouble();
                    clients[currAcc].deposit(sum);
                    break;
                case 4:
                    System.out.println("Transactions:");
                    ArrayList<Transaction> temp = clients[currAcc].getTransactions();
                    if(temp.isEmpty()){
                        System.out.println(":*:*:*:*: No tRaNsAcTiOnS YeT :*:*:*:*:\n");
                        break;
                    }
                    for(Transaction t: temp){
                        System.out.println("\tType: " + t.getType());
                        System.out.println("\tDate: " + t.getDate());
                        System.out.println("\tAmount: " + t.getAmount());
                        System.out.println("\tBalance after transaction: " + t.getBalance());
                        System.out.println("\tDescription: " + t.getDescription() + "\n");
                    }
                    break;
                case 5:
                    System.out.println("|||LOGGING OUT||||");
                    break;
                default:
                    System.out.println("Wrong input\n");
                    break;
            }
        }
    }
}
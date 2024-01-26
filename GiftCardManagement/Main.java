package PracticeOOP.GiftCardManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int id=101;

        while(true){
            System.out.println("__________GIFTCARD SYSTEM__________");
            System.out.println("1.Create BankAccount");
            System.out.println("2.Login to BankAccount");
            System.out.println("3.Deposit money to BankAccount");
            System.out.println("4.Withdraw money from BankAccount");
            System.out.println("5.Generate giftcard");
            System.out.println("6.Giftcard topUp");
            System.out.println("7.Giftcard purchase");
            System.out.println("8.Print all transactions from an account");
            System.out.println("9.Print all Giftcard transactions of an customer");
            System.out.println("10.Block giftCard");
            System.out.println("11.Exit");

            System.out.print("Enter your choice: ");
            int choice = in.nextInt();
            while(choice<1|| choice>11){
                System.out.println("incorrect option,try again");
                System.out.print("Enter your choice: ");
                choice = in.nextInt();
            }

            if (choice == 1){
                Account.createAccount(id);
                id++;
            }
            if (choice == 2) {
                while (true) {
                    if (Account.login()) {
                        System.out.println("Login successful");
                        break;
                    } else {
                        System.out.println("Check the details");
                        System.out.println("Login unsuccessful");
                        }
                    }
                }

            if(choice == 3){
                    System.out.print("Enter accountId: ");
                    int accountId = in.nextInt();
                    System.out.print("Enter amount: ");
                    double amount = in.nextDouble();
                    Account.deposit(accountId,amount);
            }
            if(choice==4){
                System.out.print("Enter accountId: ");
                int accountId = in.nextInt();
                System.out.print("Enter amount: ");
                double amount = in.nextDouble();
                Account.withdraw(accountId,amount);
            }
            if(choice == 5){
                    GiftCard.generateGiftCard();
            }
            if(choice == 6){
                System.out.println("Enter cardNumber: ");
                int cardNo = in.nextInt();
                System.out.print("Enter amount: ");
                double amount = in.nextDouble();
                GiftCard.topUp(cardNo,amount);
            }
            if(choice == 7){
                System.out.println("Enter cardNumber: ");
                int cardNo = in.nextInt();
                System.out.print("Enter amount: ");
                double amount = in.nextDouble();
                GiftCard.purchase(cardNo,amount);
            }
            if(choice == 8){
                System.out.println("Enter the accountId: ");
                int accountId = in.nextInt();
                Account.printAccountTransaction(accountId);
            }
            if(choice == 9){
                System.out.println("Enter cardNumber: ");
                int cardNo = in.nextInt();
                GiftCard.printGCTransaction(cardNo);
            }
            if(choice == 10){
                System.out.println("Enter cardNumber: ");
                int cardNo = in.nextInt();
                GiftCard.blockCard(cardNo);
            }
            if(choice == 11){
                break;
            }
        }
    }
}

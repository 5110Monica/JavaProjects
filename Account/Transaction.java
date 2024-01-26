package PracticeOOP.Account;

import java.util.Date;

public class Transaction {
   private char type;
   private double balance;
   private double amount;
   private Date date;
   private String description;

    public Transaction(char type, double balance, double amount, String description) {
        this.type = type;
        this.balance = balance;
        this.amount = amount;
        this.description = description;

        date =new Date();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type=" + type +"\n"+
                "balance=" + balance +"\n"+
                "amount=" + amount +"\n"+
                "date=" + date +"\n"+
                "description='" + description + "\n";
    }

    public char getType() {
        return type;
    }

}

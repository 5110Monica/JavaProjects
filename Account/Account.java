package PracticeOOP.Account;

import java.util.ArrayList;
import java.util.Date;

public class Account {
    private int id;
    private double annualInterestRate;
    private double balance;
    private final Date dateCreated;
    private Client client;
    private ArrayList<Transaction> transactions;

    public Account(int id, double annualInterestRate, double balance, Client client) {
        this.id = id;
        this.annualInterestRate = annualInterestRate;
        this.balance = balance;
        this.client = client;

        this.transactions = new ArrayList<>();
        dateCreated = new Date();
    }

    public boolean withdraw(double amount){
        if(balance > amount){
            balance = balance-amount;
            this.transactions.add(new Transaction('W',this.balance,amount,"withdrawn "+amount));
            return true;
        }
       return false;
    }

    public void deposit(double amount){
        balance = balance + amount;
        this.transactions.add(new Transaction('D',this.balance,amount,"deposited "+amount));

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public int transactionCount(char type){
        int count=0;
        for(Transaction transaction:transactions){
            if(transaction.getType()==type)
                count++;
        }
        return count;
    }
    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +"\n"+
                ", annualInterestRate=" + annualInterestRate +"\n"+
                ", balance=" + balance +"\n"+
                ", dateCreated=" + dateCreated +"\n"+
                ", client=" + client.toString() +"\n"+
                ", transactions=" + transactions.toString() +"\n"+
                '}';
    }

}

package PracticeOOP.GiftCardManagement;


import java.util.ArrayList;
import java.util.Scanner;

public class Account {
    int cust_id;
    int id;
    private String password;
    public static ArrayList<Account> accounts = new ArrayList<>();
    private double balance;
    boolean login;
    private static ArrayList<Transactions> transactions = new ArrayList<>();

    public Account(int id) {
        this.id = id;
    }

    public static void createAccount(int id) {
        Scanner in = new Scanner(System.in);
        Account account = new Account(id);
        System.out.print("Enter customer id: ");
        account.cust_id = in.nextInt();
        System.out.println("Your account id:" + id);
        System.out.print("enter password for your account: ");
        String userPass = in.next();
        account.password = Account.encryptPassword(userPass);
        account.balance = 5000;
        account.login = false;
        System.out.println("Account balance: " + account.balance);
        accounts.add(account);
    }

    public static boolean login() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter login details");
        System.out.print("Enter customerId: ");
        int customerId = in.nextInt();
        System.out.print("Enter accountId: ");
        int accountId = in.nextInt();
        System.out.print("Enter password: ");
        String password = in.next();
        for (Account account : accounts) {
            if (account.id == accountId) {
                if (account.cust_id == customerId && account.password.equals(encryptPassword(password))) {
                    account.login = true;
                    return true;
                }
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    private static String encryptPassword(String password) {
        StringBuilder str = new StringBuilder(password);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'z') {
                str.setCharAt(i, 'a');
            }
            if (str.charAt(i) == 'Z') {
                str.setCharAt(i, 'A');
            }
            if (str.charAt(i) == '9') {
                str.setCharAt(i, '0');
            }
            str.setCharAt(i, (char) (str.charAt(i) + 1));
        }
        return str.toString();
    }

    private String decryptPassword(String password) {
        StringBuilder str = new StringBuilder(password);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'A') {
                str.setCharAt(i, 'Z');
            }
            if (str.charAt(i) == 'a') {
                str.setCharAt(i, 'z');
            }
            if (str.charAt(i) == '0') {
                str.setCharAt(i, '9');
            }
            str.setCharAt(i, (char) (str.charAt(i) - 1));
        }
        return str.toString();
    }

    public static boolean withdraw(int id, double amount) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                if (account.login) {
                    if (account.balance > amount) {
                        account.balance -= amount;
                        transactions.add(new Transactions(id, amount, account.balance, "withdraw"));
                        System.out.println("withdraw successful");
                        System.out.println("Account balance: " + account.balance);
                        return true;
                    } else {
                        System.out.println("insufficient balance");
                        break;
                    }
                } else {
                    System.out.println("Login to ur account");
                    break;
                }
            } else {
                System.out.println("invalid account id");
                break;
            }
        }
        return false;
    }

    public static void deposit(int id, double amount) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                if (account.login) {
                    account.balance += amount;
                    transactions.add(new Transactions(id, amount, account.balance, "deposit"));
                    System.out.println("deposit successfully");
                    System.out.println("Account balance: " + account.balance);
                } else {
                    System.out.println("login to ur account");
                    break;
                }
            }
        }
        System.out.println("invalid account id");

    }

    public double getBalance(int id) {
        return balance;
    }

    public static void printAccountTransaction(int accountId) {
        for (Account account : accounts) {
            if (account.id == accountId) {
                System.out.println("CustomerId: " + account.cust_id);
                System.out.println("AccountId: " + account.id);
                System.out.println("AccountBalance: " + account.balance);
            } else {
                System.out.println("incorrect accountId");
            }
        }
        System.out.println("Account Transactions");
        System.out.println("TransId      AccountId       TransAmount      description      Balance");
        for (Transactions t : transactions) {
            if (accountId == t.id) {
                System.out.println(t.trans_id + "              " + t.id + "                 " + t.trans_amount + "       " + t.description +
                        "        " + t.balance);
            }
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "cust_id=" + cust_id +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}

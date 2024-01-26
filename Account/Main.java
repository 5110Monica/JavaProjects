package PracticeOOP.Account;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*// create two clients and add two acc for one and three account for another
        Client[] client = new Client[2];

        //creating client
        client[0] = new Client(12,"moni","4568266");
        client[1] = new Client(13,"varssha","4425673");

        //creating two accounts for client moni
        client[0].addAccount(new Account(1201,2.3,80000));
        client[0].addAccount(new Account(1202,1.3,900000));

        //creating three accounts for client varssha
        client[1].addAccount(new Account(1301,1.2,67453));
        client[1].addAccount(new Account(1302,1.4,536827));
        client[1].addAccount(new Account(1303,1.6,62172));

        System.out.println(client[0]);
        System.out.println(client[1]);*/

        ArrayList<Account> accounts = new ArrayList<>();
        Client client = new Client(12,"moni","4568266");

         accounts.add(new Account(1,2.6,5000,client));
         accounts.add(new Account(2,2.6,7000,client));

         accounts.get(0).deposit(1000);
         accounts.get(0).withdraw(500);
         System.out.println( accounts.get(0).getBalance());

        accounts.get(1).deposit(2000);
        accounts.get(1).withdraw(2500);
        accounts.get(1).withdraw(2500);
        System.out.println( accounts.get(1).getBalance());

        System.out.println(accounts.get(0));
        System.out.println(client);








    }
}

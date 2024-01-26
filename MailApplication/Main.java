package PracticeOOP.MailApplication;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String firstname,lastname,company,department;
        System.out.print("Enter FirstName: ");
        firstname = in.next();
        System.out.print("Enter LastName:");
        lastname=in.next();
        System.out.print("Enter company:");
        company=in.next();
        System.out.print("Enter department:");
        department=in.next();

        mailApp mp = new mailApp(firstname,lastname,company,department);
        System.out.println(mp.getMailId());
        System.out.println(mp.getPassword());

    }
}

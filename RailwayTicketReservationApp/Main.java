package PracticeOOP.RailwayTicketReservationApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean bool = true;
        Scanner in = new Scanner(System.in);
        int id = 0;

        while (bool) {
            System.out.println("_____________Railway Ticket Booking______________");
            System.out.println("1.Book ticket");
            System.out.println("2.Cancel ticket");
            System.out.println("3.Print booked ticket details");
            System.out.println("4.Print available tickets");
            System.out.println("5.Exit");

            int choice;
            System.out.print("Enter ur choice: ");
            choice = in.nextInt();

            if(choice == 1){
                System.out.print("Enter ur name: ");
                String name = in.next();
                System.out.print("Enter age: ");
                int age = in.nextInt();
                System.out.print("Enter BirthPreferences(L,M,U): ");
                char bp = in.next().charAt(0);

                Passenger passenger = new Passenger(id,name,age,bp);
                TicketBooker.bookTicket(passenger);
                id++;
            }

            if(choice == 2){
                int passenger_id;
                System.out.print("Enter passengerId to cancel ticket: ");
                passenger_id = in.nextInt();
                TicketBooker.cancelTicket(passenger_id);
            }

            if(choice == 3)
                TicketBooker.printBookedList();

            if(choice == 4)
                TicketBooker.printAvailableTickets();

            if(choice == 5)
                bool=false;

        }
    }
}

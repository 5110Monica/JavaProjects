package PracticeOOP.FlightTicketBooking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean bool = true;
        Scanner in = new Scanner(System.in);

        while (bool) {
            System.out.println("_____________Flight Ticket Booking______________");
            System.out.println("1.Book ticket");
            System.out.println("2.Cancel ticket");
            System.out.println("3.Print passenger details");
            System.out.println("4.Print available tickets");
            System.out.println("5.Exit");
            System.out.println();

            int choice;
            System.out.print("Enter ur choice: ");
            choice = in.nextInt();
            if(choice<1 || choice>5){
                System.out.print("enter valid choice: ");
                choice = in.nextInt();
            }

            if(choice == 1){
                TicketBooker.printAvailableTickets();
                int flightId;
                int nofTickets;
                System.out.print("Enter flightId: ");
                flightId = in.nextInt();
                while(flightId<=0 || flightId>2){
                    System.out.println("Enter valid flightId: ");
                    flightId = in.nextInt();
                }
                System.out.print("Enter number of tickets: ");
                nofTickets = in.nextInt();
                TicketBooker.bookTicket(flightId,nofTickets);
            }
            if(choice == 2){
                int flightId;
                int nofTickets;
                System.out.print("Enter flightId: ");
                flightId = in.nextInt();
                if (flightId<=0 || flightId>2){
                    System.out.println("Enter valid flightId: ");
                    flightId = in.nextInt();
                }
                System.out.println("Enter no of tickets: ");
                nofTickets= in.nextInt();
                System.out.println("Enter the passenger id to cancel");
                int[] passId = new int[nofTickets];
                for(int i = 0 ; i<passId.length;i++){
                    passId[i]= in.nextInt();
                }
                TicketBooker.cancelTicket(flightId,nofTickets,passId);
            }
            if(choice==3)
                TicketBooker.printPassengerDetails();

            if(choice==4)
                TicketBooker.printAvailableTickets();

            if(choice == 5)
                bool = false;
        }
    }
}

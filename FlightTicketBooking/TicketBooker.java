package PracticeOOP.FlightTicketBooking;

import java.util.ArrayList;
import java.util.Iterator;

public class TicketBooker {
    static int f1SeatsAvailable = 50;
    static int f2SeatsAvailable = 50;
    static int f1Price = 5000;
    static int f2Price = 5000;
    static ArrayList<Passenger>f1PassengerDetails = new ArrayList<>(50);
    static ArrayList<Passenger>f2PassengerDetails = new ArrayList<>(50);

    static void bookTicket(int flightId,int nofTickets){
        if(flightId == 1){
            int id =0;
            for(int i =0;i<nofTickets;i++) {
                f1PassengerDetails.add(new Passenger(id, flightId, f1Price));
                id++;
                f1SeatsAvailable--;
            }
            int totalAmount = f1Price*nofTickets;
            System.out.println("Booking successful");
            System.out.println("Total Amount: "+totalAmount);
            f1Price= f1Price + (200*nofTickets);
        }
        else if(flightId==2){
            int id =0;
            for(int i =0;i<nofTickets;i++) {
                f2PassengerDetails.add(new Passenger(id, flightId,f1Price));
                id++;
                f2SeatsAvailable--;
            }
            int totalAmount = f2Price*nofTickets;
            System.out.println("Booking successful");
            System.out.println("Total Amount: "+totalAmount);
            f2Price= f2Price + (200*nofTickets);
        }
    }
    public static void cancelTicket(int flightId, int nofTickets, int[] passId) {
        if (flightId == 1) {
            int refundAmount = 0;
            Iterator<Passenger> iterator = f1PassengerDetails.iterator();
            while (iterator.hasNext()) {
                Passenger p = iterator.next();
                for (int i : passId) {
                    if (p.id == i) {
                        iterator.remove();
                        refundAmount += p.amount;
                        f1SeatsAvailable++;
                    }
                }
            }
            System.out.println("Ticket cancellation successful");
            System.out.println("Refund Amount: " + refundAmount);
            f1Price -= (200 * nofTickets);
        }
        else if (flightId == 2) {
            int refundAmount = 0;
            Iterator<Passenger> iterator = f2PassengerDetails.iterator();
            while (iterator.hasNext()) {
                Passenger p = iterator.next();
                for (int j : passId) {
                    if (p.id == j) {
                        iterator.remove();
                        refundAmount += p.amount;
                        f2SeatsAvailable++;
                        f2Price -= 200;
                    }
                }
            }
            System.out.println("Ticket cancellation successful");
            System.out.println("Refund Amount: " + refundAmount);
        }
    }

    static void printAvailableTickets(){
        System.out.println("FlightId: 1");
        System.out.println("Available tickets: "+f1SeatsAvailable+"       "+"Price: "+f1Price);
        System.out.println("FlightId: 2");
        System.out.println("Available tickets: "+f2SeatsAvailable+"       "+"Price: "+f2Price);
    }
    static void printPassengerDetails(){
        System.out.println(" F1 Passenger Details");
        if(f1PassengerDetails.size()>0) {
            for (Passenger p : f1PassengerDetails) {
                System.out.println("PassengerId: " + p.id);
                System.out.println("FlightId: " + p.flightId);
                System.out.println("Amount: " + p.amount);
                System.out.println();
            }
        }
        else
            System.out.println("f1: No bookings");
        System.out.println("________________________________");

        if(f2PassengerDetails.size()>0) {
            System.out.println(" F2 Passenger Details");
            for (Passenger p : f2PassengerDetails) {
                System.out.println("PassengerId: " + p.id);
                System.out.println("FlightId: " + p.flightId);
                System.out.println("Amount: " + p.amount);
                System.out.println();
            }
        }
        else
            System.out.println("f2: No bookings");
    }

}

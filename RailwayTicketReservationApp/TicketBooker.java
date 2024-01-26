package PracticeOOP.RailwayTicketReservationApp;

import java.util.ArrayList;

public class TicketBooker {

    static int lowerBthTicketAvailable = 2;
    static int middleBthTicketAvailable = 1;
    static int upperBthTicketAvailable = 1;
    static int RACTicketAvailable = 1;
    static int wlTicketAvailable = 1;

    static ArrayList<Integer> lowerBthPositions = new ArrayList<>(2);
    static ArrayList<Integer> middleBthPositions = new ArrayList<>(1);
    static ArrayList<Integer> upperBthPositions = new ArrayList<>(1);
    static ArrayList<Integer> RACPositions = new ArrayList<>(1);
    static ArrayList<Integer> wlPositions = new ArrayList<>(1);

    static ArrayList<Passenger> bookedList = new ArrayList<>();
    static ArrayList<Passenger> RACList = new ArrayList<>();
    static ArrayList<Passenger> wlList = new ArrayList<>();

    public static void bookTicket(Passenger passenger) {
        if (passenger.birthPreference == 'l' && lowerBthTicketAvailable >= 1) {
            if (lowerBthPositions.contains(-1))
                lowerBthPositions.add(lowerBthPositions.indexOf(-1), passenger.id);
            else
                lowerBthPositions.add(passenger.id);
            int position = lowerBthPositions.indexOf(passenger.id) + 1;
            passenger.allotted='l';
            passenger.ticketStatus = new Ticket(position, passenger.allotted);
            System.out.println("Ticket booked");
            System.out.println("Status: " + passenger.ticketStatus);
            bookedList.add(passenger);
            lowerBthTicketAvailable--;
        }
        else if (passenger.birthPreference == 'm' && middleBthTicketAvailable >= 1) {
            if (middleBthPositions.contains(-1))
                middleBthPositions.add(middleBthPositions.indexOf(-1), passenger.id);
            else
                middleBthPositions.add(passenger.id);
            int position = middleBthPositions.indexOf(passenger.id) + 1;
            passenger.allotted='m';
            passenger.ticketStatus = new Ticket(position, passenger.allotted);
            System.out.println("Ticket booked");
            System.out.println("Status: " + passenger.ticketStatus);
            bookedList.add(passenger);
            middleBthTicketAvailable--;
        }
        else if (passenger.birthPreference == 'u' && upperBthTicketAvailable >= 1) {
            if (upperBthPositions.contains(-1))
                upperBthPositions.add(upperBthPositions.indexOf(-1), passenger.id);
            else
                upperBthPositions.add(passenger.id);
            int position = upperBthPositions.indexOf(passenger.id) + 1;
            passenger.allotted='u';
            passenger.ticketStatus = new Ticket(position, passenger.allotted);
            System.out.println("Ticket booked");
            System.out.println("Status: " + passenger.ticketStatus);
            bookedList.add(passenger);
            upperBthTicketAvailable--;
        }
        else if (lowerBthTicketAvailable >= 1) {
            if (lowerBthPositions.contains(-1))
                lowerBthPositions.add(lowerBthPositions.indexOf(-1), passenger.id);
            else
                lowerBthPositions.add(passenger.id);
            passenger.allotted='l';
            int position = lowerBthPositions.indexOf(passenger.id) + 1;
            passenger.ticketStatus = new Ticket(position, passenger.allotted);
            System.out.println("Ticket given");
            System.out.println("Status: " + passenger.ticketStatus);
            bookedList.add(passenger);
            lowerBthTicketAvailable--;
        }
        else if (middleBthTicketAvailable >= 1) {
            if (middleBthPositions.contains(-1))
                middleBthPositions.add(middleBthPositions.indexOf(-1), passenger.id);
            else
                middleBthPositions.add(passenger.id);
            int position = middleBthPositions.indexOf(passenger.id) + 1;
            passenger.allotted='m';
            passenger.ticketStatus = new Ticket(position, passenger.allotted);
            System.out.println("Ticket given");
            System.out.println("Status: " + passenger.ticketStatus);
            bookedList.add(passenger);
            middleBthTicketAvailable--;
        }
        else if (upperBthTicketAvailable >= 1) {
            if (upperBthPositions.contains(-1))
                upperBthPositions.add(upperBthPositions.indexOf(-1), passenger.id);
            else
                upperBthPositions.add(passenger.id);
            int position = upperBthPositions.indexOf(passenger.id) + 1;
            passenger.allotted='u';
            passenger.ticketStatus = new Ticket(position, passenger.allotted);
            System.out.println("Ticket given");
            System.out.println("Status: " + passenger.ticketStatus);
            bookedList.add(passenger);
            upperBthTicketAvailable--;
        }
        else if (RACTicketAvailable >= 1) {
            RACPositions.add(passenger.id);
            int position = RACPositions.indexOf(passenger.id) + 1;
            passenger.allotted='r';
            passenger.ticketStatus = new Ticket(position, passenger.allotted);
            System.out.println("Ticket given(RAC)");
            System.out.println("Status: " + passenger.ticketStatus);
            RACList.add(passenger);
            RACTicketAvailable--;
        }
        else if (wlTicketAvailable >= 1) {
            wlPositions.add(passenger.id);
            int position = wlPositions.indexOf(passenger.id) + 1;
            passenger.allotted='w';
            passenger.ticketStatus = new Ticket(position, passenger.allotted);
            System.out.println("Ticket given(waiting list)");
            System.out.println("Status: " + passenger.ticketStatus);
            wlList.add(passenger);
            wlTicketAvailable--;
        }
        else {
            System.out.println("Booking failed");
        }
    }

    public static void cancelTicket(int id) {
        int position = 0;
        char birth = ' ';

        for (Passenger passenger : bookedList) {
            if (passenger.id == id) {
                position = passenger.ticketStatus.getPosition();
                birth = passenger.ticketStatus.getBirth();
                bookedList.remove(passenger);
                System.out.println("Ticket cancellation successful");
                break;
            }
        }
        if (birth == 'l') {
            lowerBthPositions.remove(position - 1);
            lowerBthTicketAvailable++;
            lowerBthPositions.add(position - 1, -1);
        }
        else if (birth == 'm') {
            middleBthPositions.remove(position - 1);
            middleBthTicketAvailable++;
            middleBthPositions.add(position - 1, -1);
        }
        else if (birth == 'u') {
            upperBthPositions.remove(position - 1);
            upperBthTicketAvailable++;
            upperBthPositions.add(position - 1, -1);
        }
        if (RACPositions.size() >= 1) {
            TicketBooker.bookTicket(RACList.get(0));
            RACList.remove(0);
            RACPositions.remove(0);
            RACTicketAvailable++;

            if (wlPositions.size() >= 1) {
                RACPositions.add(wlPositions.get(0));
                RACTicketAvailable--;
                RACList.add(wlList.get(0));

                wlPositions.remove(0);
                wlList.remove(0);
                wlTicketAvailable++;
            }
        }
    }

    public static void printBookedList(){
        if(bookedList.size()>=1) {
            for (Passenger p : bookedList) {
                System.out.println();
                System.out.println("PassengerId: " + p.id);
                System.out.println("Name: " + p.name);
                System.out.println("Age: " + p.age);
                System.out.println("BirthPreference: " + p.birthPreference);
                System.out.println("TicketBooked: " + p.ticketStatus);
                System.out.println("_______________________________________");
            }
        }
        else
            System.out.println("bookedList is empty");
    }

    public static void printAvailableTickets() {

        System.out.println("LowerBirth ticket available: " + lowerBthTicketAvailable);
        System.out.println("MiddleBirth ticket available: " + middleBthTicketAvailable);
        System.out.println("UpperBirth ticket available: " + upperBthTicketAvailable);
        System.out.println("RAC ticket available: " + RACTicketAvailable);
        System.out.println("WaitingList ticket available: " + wlTicketAvailable);

    }
}




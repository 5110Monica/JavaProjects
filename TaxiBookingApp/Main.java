package PracticeOOP.TaxiBookingApp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArrayList<Taxi> taxis = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        taxis.add(new Taxi(1));
        taxis.add(new Taxi(2));
        taxis.add(new Taxi(3));
        taxis.add(new Taxi(4));

        int choice;
        int booking_id = 0;
        boolean n = true;
        Scanner in = new Scanner(System.in);

        while (n) {
            System.out.println("__________Call_Taxi_Booking___________");
            System.out.println("1.Booking");
            System.out.println("2.Booking Details");
            System.out.println("3.Taxi Details");
            System.out.println("4.Booking details for a taxi");
            System.out.println("5.Exit");

            System.out.print("Enter ur choice: ");
            choice = in.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("enter customer id: ");
                    int customer_id = in.nextInt();
                    System.out.print("Enter pickupPoint(a-f): ");
                    char pickup_point = in.next().charAt(0);
                    char drop_point;
                    while (true) {
                        System.out.print("Enter dropPoint(a-f): ");
                        drop_point = in.next().charAt(0);
                        if (pickup_point == drop_point)
                            System.out.print("enter a valid dropPoint");
                        else
                            break;
                    }
                    System.out.print("Enter pickupTime: ");
                    int pickup_time = in.nextInt();
                    Booking booking = new Booking(customer_id, pickup_point, drop_point, pickup_time);
                    booking.bookingId = booking_id;
                    ArrayList<Taxi> freeTaxis = getFreeTaxis(taxis, pickup_point, pickup_time);
                    getBookTaxi(freeTaxis, booking);
                    bookings.add(booking);
                    booking_id++;
                }
                break;
                case 2: {
                    System.out.println("BookingId     CustomerId      TaxiNo      PickupPoint     DropPoint      PickupTime      DropTime      Earnings");
                    for (Booking b : bookings) {
                        System.out.println("    " + b.bookingId + "          " + b.customerId + "           " + b.taxiNo + "           "
                                + b.pickupPoint + "           " + b.dropPoint + "           " + b.pickupTime + "           "
                                + b.dropTime + "           " + b.earnings);
                    }
                }
                break;
                case 3: {
                    System.out.println("TaxiNo      CurrentPosition      FreeTime      TotalEarnings");
                    for (Taxi t : taxis) {
                        System.out.println("   " + t.taxiNo + "            " + t.currentPosition + "             " + t.freeTime +
                                "            " + t.totalEarnings);
                    }
                }
                break;
                case 4: {
                    int taxi_no;
                    System.out.print("Enter taxiId: ");
                    taxi_no = in.nextInt();
                    System.out.println("BookingId     CustomerId      TaxiNo      PickupPoint     DropPoint      PickupTime      DropTime      Earnings");
                    for (Booking b : bookings) {
                        if (b.taxiNo == taxi_no) {
                            System.out.println("    " + b.bookingId + "          " + b.customerId + "           " + b.taxiNo + "           "
                                    + b.pickupPoint + "           " + b.dropPoint + "           " + b.pickupTime + "           "
                                    + b.dropTime + "           " + b.earnings);
                        }

                    }
                    break;
                }
                case 5: {
                    n = false;
                }
            }
        }
    }

    public static void getBookTaxi(ArrayList<Taxi> freeTaxis, Booking booking) {
        if (freeTaxis.size() == 0) {
            System.out.println("booking failed");
        }
        if (freeTaxis.size() == 1) {
            System.out.println("booked taxi successfully");
            System.out.println("Taxi Id: " + freeTaxis.get(0).taxiNo);
            booking.calcDropTime(booking.pickupPoint, booking.dropPoint);
            freeTaxis.get(0).freeTime = booking.dropTime;
            booking.calcEarnings(booking.pickupPoint, booking.dropPoint);
            freeTaxis.get(0).totalEarnings += booking.earnings;
        }
        freeTaxis.sort(Comparator.comparingInt(a -> a.totalEarnings));

        int minDistance = 1000;
        int distanceBetweenCustomerAndTaxi;
        Taxi bookedTaxi = null;
        for (Taxi t : freeTaxis) {
            distanceBetweenCustomerAndTaxi = Math.abs(booking.pickupPoint - t.currentPosition) * 15;
            if (distanceBetweenCustomerAndTaxi < minDistance) {
                bookedTaxi = t;
                minDistance = distanceBetweenCustomerAndTaxi;
            }
        }

        if (bookedTaxi != null) {
            System.out.println("Taxi booked successfully");
            System.out.println("Taxi Id: " + bookedTaxi.taxiNo);
            booking.taxiNo = bookedTaxi.taxiNo;
            booking.calcDropTime(booking.pickupPoint, booking.dropPoint);
            bookedTaxi.freeTime = booking.dropTime;
            booking.calcEarnings(booking.pickupPoint, booking.dropPoint);
            bookedTaxi.totalEarnings += booking.earnings;
            bookedTaxi.currentPosition = booking.dropPoint;
        }
    }

    public static ArrayList<Taxi> getFreeTaxis(ArrayList<Taxi> taxis, int pickup_point, int pickup_time) {
        ArrayList<Taxi> freeTaxis = new ArrayList<>();
        for (Taxi t : taxis) {
            if (!t.booked && (t.freeTime + (Math.abs(t.currentPosition - pickup_point)) <= pickup_time))
                freeTaxis.add(t);
        }

        return freeTaxis;
    }

}


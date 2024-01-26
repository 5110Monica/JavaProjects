package PracticeOOP.TollManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("____________Toll Management____________");
            System.out.println("1.Find shortest route and Toll covered");
            System.out.println("2.All details of toll");
            System.out.println("3.All vehicle details");
            System.out.println("4.Exit");
            System.out.print("Enter choice: ");
            int choice = in.nextInt();
            while (choice < 1 || choice > 4) {
                System.out.println("Invalid choice!try again");
                System.out.print("Enter choice: ");
                choice = in.nextInt();
            }
            if (choice == 1) {
                System.out.println("Enter the vehicle type:");
                System.out.println("1.Bike");
                System.out.println("2.Car");
                System.out.println("3.Bus");
                System.out.print("Select option: ");
                int op = in.nextInt();
                while (op < 1 || op > 3) {
                    System.out.println("Invalid option!try again");
                    System.out.print("Enter choice: ");
                    op = in.nextInt();
                }
                System.out.print("Enter vehicle id: ");
                int vehicleId = in.nextInt();
                System.out.println("Enter journey details: ");
                System.out.print("Enter start point(A-F): ");
                char start = in.next().charAt(0);
                System.out.print("Enter destination point(A-F): ");
                char end = in.next().charAt(0);
                System.out.println("Are you a vip vehicle user(y/n): ");
                char op1;
                while (true) {
                    op1 = in.next().charAt(0);
                    if (op1 != 'y' && op1 != 'n') {
                        System.out.println("Invalid option!try again");
                        System.out.print("Enter choice: ");
                    } else {
                        break;
                    }
                }
                boolean bool = false;
                if (op1 == 'y') {
                    bool = true;
                }
                System.out.println("Your Journey!!!!!");
                System.out.println("Start point: " + start);
                System.out.println("Destination point: " + end);
                System.out.print("route: ");
                ArrayList<Character> path = Highway.route(start, end);
                for (Character point : path) {
                    System.out.print(point + "->");
                }
                System.out.println("reached destination");
                System.out.print("Tolls crossed: ");
                ArrayList<Character> tollsCrossed = Highway.tollsCrossed(path);
                System.out.println(tollsCrossed);
                Vehicle vehicle = new Vehicle(null, vehicleId, start, end, bool, tollsCrossed, 0);
                vehicle.calculateTollCharge(op);
                System.out.println("Total tollCharge: " + vehicle.amount);
            }
            if (choice == 2) {
                Vehicle.displayVehicleDetails();
            }
            if (choice == 3) {
                TollA.printTollDetails();
                TollB.printTollDetails();
                TollC.printTollDetails();
            }
            if (choice == 4) {
                break;
            }
        }
    }
}

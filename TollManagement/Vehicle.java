package PracticeOOP.TollManagement;

import java.util.ArrayList;

public class Vehicle {
    String vehicleType;
    int id;
    char start;
    char end;
    boolean vip;
    ArrayList<Character> tollsPassed;
    int amount;
    static ArrayList<Vehicle>vehicles=new ArrayList<>();
    public Vehicle(String vehicleType,int id, char start, char end, boolean vip, ArrayList<Character> tollsPassed,int amount) {
        this.vehicleType=vehicleType;
        this.id = id;
        this.start = start;
        this.end = end;
        this.vip = vip;
        this.tollsPassed = tollsPassed;
        this.amount=amount;
    }
    public void calculateTollCharge(int vType) {
        if (vType == 1) {
            Bike bike = new Bike(vehicleType,id, start, end, vip, tollsPassed, amount);
            bike.calculateAmount(bike, tollsPassed, vip);
            this.amount = bike.amount;
            vehicles.add(bike);
        } else if (vType == 2) {
            Car car = new Car(vehicleType,id, start, end, vip, tollsPassed, amount);
            car.calculateAmount(car, tollsPassed, vip);
            this.amount = car.amount;
            vehicles.add(car);
        } else if (vType == 3) {
            Bus bus = new Bus(vehicleType,id, start, end, vip, tollsPassed, amount);
            bus.calculateAmount(bus, tollsPassed, vip);
            this.amount = bus.amount;
            vehicles.add(bus);
        }
    }
    public static void displayVehicleDetails(){
        System.out.println("Type     VehicleId     StartPt     DestinationPt     TollPassed     TotalAmtPaid");
        for(Vehicle v:vehicles){
            System.out.println(v.vehicleType+"         "+v.id+"           "+v.start+"           "+v.end+
                    "          "+v.tollsPassed+"          "+v.amount);
        }
    }
    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                ", vip=" + vip +
                ", tollsPassed=" + tollsPassed +
                ", amount=" + amount +
                '}';
    }
}

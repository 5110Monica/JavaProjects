package PracticeOOP.TollManagement;

import java.util.ArrayList;

public class Car extends Vehicle{
    public Car(String vehicleType, int id, char start, char end, boolean vip, ArrayList<Character> tollsPassed, int amount) {
        super("Car", id, start, end, vip, tollsPassed, amount);
    }

    public void calculateAmount(Car car, ArrayList<Character> tollsPassed, boolean vip) {
        if(tollsPassed.isEmpty()){
            System.out.println("No tolls involved");
        }
        TollA toll1 = new TollA();
        TollB toll2 = new TollB();
        TollC toll3 = new TollC();
        int amt=0;
        if (tollsPassed.size()==2){
            amt=amt+toll1.CalculatePrice(car,vip)+toll2.CalculatePrice(car,vip);
        }
        else if (tollsPassed.size()==1) {
            if (tollsPassed.get(0) == 'a') {
                amt += toll1.CalculatePrice(car, vip);
            } else if (tollsPassed.get(0) == 'b') {
                amt += toll2.CalculatePrice(car, vip);
            } else if (tollsPassed.get(0) == 'c') {
                amt += toll3.CalculatePrice(car, vip);
            }
        }
        this.amount=amt;
    }
}

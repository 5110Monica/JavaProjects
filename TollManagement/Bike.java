package PracticeOOP.TollManagement;

import java.util.ArrayList;

public class Bike extends Vehicle {

    public Bike(String vehicleType, int id, char start, char end, boolean vip, ArrayList<Character> tollsPassed, int amount) {
        super("Bike", id, start, end, vip, tollsPassed, amount);
    }

    public void calculateAmount(Bike bike, ArrayList<Character> tollsPassed, boolean vip) {
        if(tollsPassed.isEmpty()){
            System.out.println("No tolls involved");
        }
        TollA toll1 = new TollA();
        TollB toll2 = new TollB();
        TollC toll3 = new TollC();
        int amt=0;
        if (tollsPassed.size()==2){
            amt=amt+toll1.CalculatePrice(bike,vip)+toll2.CalculatePrice(bike,vip);
        }
        else if (tollsPassed.size()==1) {
            if (tollsPassed.get(0) == 'a') {
                amt += toll1.CalculatePrice(bike, vip);
            } else if (tollsPassed.get(0) == 'b') {
                amt += toll2.CalculatePrice(bike, vip);
            } else if (tollsPassed.get(0) == 'c') {
                amt += toll3.CalculatePrice(bike, vip);
            }
        }
       bike.amount=amt;
    }


}

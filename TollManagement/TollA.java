package PracticeOOP.TollManagement;

import java.util.ArrayList;

public  class TollA extends Toll {
     static ArrayList<TollDetails>tollDetails=new ArrayList<>();
     static int tollPrice;
     static int discount=20;

    public int CalculatePrice(Car car,boolean vip) {
        int price=150;
        if(vip){
            int discountPrice = price-calculateDiscount(price);
            tollDetails.add(new TollDetails(car.vehicleType,car.id,discountPrice));
            tollPrice+=discountPrice;
            return discountPrice;
        }
        tollDetails.add(new TollDetails(car.vehicleType,car.id,price));
        tollPrice+=price;
        return price;
    }
    @Override
    public int CalculatePrice(Bike bike,boolean vip) {
        int price=100;
        if(vip){
            int discountPrice = price-calculateDiscount(price);
            tollDetails.add(new TollDetails(bike.vehicleType, bike.id,discountPrice));
            tollPrice+=discountPrice;
            return discountPrice;
        }
        tollDetails.add(new TollDetails(bike.vehicleType, bike.id,price));
        tollPrice+=price;
        return price;
    }
    @Override
    public int CalculatePrice(Bus bus,boolean vip) {
        int price=200;
        if(vip){
            int discountPrice = price-calculateDiscount(price);
            tollDetails.add(new TollDetails(bus.vehicleType,bus.id,discountPrice));
            tollPrice+=discountPrice;
            return discountPrice;
        }
        tollDetails.add(new TollDetails(bus.vehicleType,bus.id,price));
        tollPrice+=price;
        return price;
    }
    public static void printTollDetails(){
        System.out.println("TollA vehicle details");
        System.out.println("Toll discount: "+discount+"%");
        System.out.println("Total amount collected: "+tollPrice);
        System.out.println("VehicleType       vehilceId       AmountPaid");
        for (TollDetails td : tollDetails){
            System.out.println("    "+td.description+"              "+td.vehicleId+"              "+td.price);
        }
    }
}

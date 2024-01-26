package PracticeOOP.TollManagement;

public abstract class Toll {
    public abstract int CalculatePrice(Car car,boolean vip);
    public abstract int CalculatePrice(Bike bike,boolean vip);
    public abstract int CalculatePrice(Bus bus,boolean vip);
    public static int  calculateDiscount(int price) {
        return (int) (price * 0.20);
    }// Calculate 20% of the price


}

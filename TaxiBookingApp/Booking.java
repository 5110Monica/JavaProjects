package PracticeOOP.TaxiBookingApp;

public class Booking {
      int bookingId;
      int customerId;
      int taxiNo;
      char pickupPoint;
      char dropPoint;
      int pickupTime;
      int dropTime;
      int earnings;

    public Booking(int customerId, char pickupPoint, char dropPoint, int pickupTime) {
        this.customerId = customerId;
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.pickupTime = pickupTime;

        this.bookingId=0;
        this.dropTime=0;
        this.earnings=0;
    }
    public void calcDropTime(char pickupPoint, char dropPoint){
        this.dropTime=pickupTime+(Math.abs(pickupPoint-dropPoint));
    }
    public void calcEarnings(char pickupPoint, char dropPoint){
        int totalDistance = Math.abs(pickupPoint-dropPoint)*15;
        this.earnings = (100)+(totalDistance-5)*10;
    }
}

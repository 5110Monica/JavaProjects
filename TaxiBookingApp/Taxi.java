package PracticeOOP.TaxiBookingApp;

public class Taxi {
    int taxiNo;
    char currentPosition;
    int totalEarnings;
    boolean booked;
    int freeTime;

    public Taxi(int taxiNo) {
        this.taxiNo = taxiNo;
        this.currentPosition = 'a';
        this.booked = false;
        this.freeTime =6;
        this.totalEarnings=0;

    }


    public int getTaxiNo() {
        return taxiNo;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "taxiNo=" + taxiNo +
                ", currentPosition=" + currentPosition +
                ", totalEarnings=" + totalEarnings +
                ", booked=" + booked +
                ", freeTime=" + freeTime +
                '}';
    }
}

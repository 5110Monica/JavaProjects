package PracticeOOP.FlightTicketBooking;

public class Passenger {
    int id;

    int flightId;
    int amount;

    public Passenger(int id,int flightId,int amount) {
        this.id = id;
        this.flightId = flightId;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }
}

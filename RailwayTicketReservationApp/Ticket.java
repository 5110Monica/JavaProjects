package PracticeOOP.RailwayTicketReservationApp;

public  class Ticket {
    int position;
    char birthAllotted;

    public Ticket(int position, char birthAlloted) {
        this.position = position;
        this.birthAllotted = birthAlloted;
    }

    @Override
    public String toString() {
        return position+""+birthAllotted;
    }

    public int getPosition() {
        return position;
    }

    public char getBirth() {
        return birthAllotted;
    }
}

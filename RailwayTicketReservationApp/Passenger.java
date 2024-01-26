package PracticeOOP.RailwayTicketReservationApp;

public class Passenger {
    int id;
    String name;
    int age;
    char birthPreference;
    char allotted;
    Ticket ticketStatus;

    public Passenger(int id, String name, int age, char birthPreference) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthPreference = birthPreference;

    }

}

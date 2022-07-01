package ru.netology.domain;


import java.util.Objects;

public class Ticket implements Comparable<Ticket> {


    protected int id;
    protected int cost;
    protected String airportDeparture;
    protected String airportArrival;
    protected int timeInWay;


    public Ticket(int id, int cost, String airportDeparture, String airportArrival, int timeInWay) {
        this.id = id;
        this.cost = cost;
        this.airportDeparture = airportDeparture;
        this.airportArrival = airportArrival;
        this.timeInWay = timeInWay;
    }

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public String getAirportDeparture() {
        return airportDeparture;
    }

    public String getAirportArrival() {
        return airportArrival;
    }

    public int getTimeInWay() {
        return timeInWay;
    }


    @Override
    public String toString() {
        return airportDeparture;
    }

    @Override
    public int compareTo(Ticket otherTicket) {
        if (cost < otherTicket.cost) {
            return -1;
        }
        if (cost > otherTicket.cost) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && cost == ticket.cost
                && timeInWay == ticket.timeInWay
                && Objects.equals(airportDeparture, ticket.airportDeparture)
                && Objects.equals(airportArrival, ticket.airportArrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cost, airportDeparture, airportArrival, timeInWay);
    }
}

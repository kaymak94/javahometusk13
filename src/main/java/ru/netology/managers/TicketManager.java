package ru.netology.managers;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.addTicket(ticket);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }


    public Ticket[] findNeedTickets(String from, String to) {

        Ticket[] ans = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (ticket.getAirportDeparture() == from && ticket.getAirportArrival() == to) {
                Ticket[] tmp = new Ticket[ans.length + 1];
                for (int i = 0; i < ans.length; i++) {
                    tmp[i] = ans[i];
                }
                tmp[tmp.length - 1] = ticket;
                ans = tmp;

            }
        }
        Arrays.sort(ans);
        return ans;
    }
}
package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.TicketRepository;
import ru.netology.managers.TicketManager;

public class TicketManagerTest {
    private TicketRepository repo = new TicketRepository();

    private TicketManager manager = new TicketManager(repo);
    Ticket ticket1 = new Ticket(1, 12500, "AER", "PES", 675);
    Ticket ticket2 = new Ticket(2, 8750, "MRV", "BZK", 60);
    Ticket ticket3 = new Ticket(3, 10350, "AER", "PES", 675);
    Ticket ticket4 = new Ticket(4, 11600, "ROV", "SKG", 170);
    Ticket ticket5 = new Ticket(5, 14700, "AER", "PES", 675);
    Ticket ticket6 = new Ticket(6, 5800, "AER", "ROV", 100);

    @Test
    public void addAllTicketsTest() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] actual = repo.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addNotAllTicketsTest() {
        manager.add(ticket1);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket6);
        Ticket[] actual = repo.findAll();
        Ticket[] expected = {ticket1, ticket3, ticket4, ticket6};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdTickets() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.removeById(4);
        Ticket[] actual = repo.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket5, ticket6};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findNeedTicketsAndSortTest() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.findNeedTickets("AER", "PES");
        Ticket[] expected = {ticket3, ticket1, ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findNotNeedTicketsTest() {

        manager.add(ticket2);
        manager.add(ticket4);
        manager.add(ticket6);

        Ticket[] actual = manager.findNeedTickets("AER", "PES");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findOneNeedTicketsTest() {

        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket6);

        Ticket[] actual = manager.findNeedTickets("AER", "PES");
        Ticket[] expected = {ticket3};
        Assertions.assertArrayEquals(expected, actual);
    }
}
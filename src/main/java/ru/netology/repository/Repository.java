package ru.netology.repository;

import ru.netology.domain.TicketsService;

public class Repository {
    TicketsService[] tickets = new TicketsService[0];

    public void save(TicketsService ticket) {
        int length = tickets.length + 1;
        TicketsService[] tmp = new TicketsService[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public TicketsService[] getAll() {
        return tickets;
    }

    public TicketsService findById(int id) {
        for (TicketsService ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public TicketsService[] removeById(int id) {
        int length = tickets.length - 1;
        TicketsService[] tmp = new TicketsService[length];
        int index = 0;
        for (TicketsService ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
        return tmp;
    }
}
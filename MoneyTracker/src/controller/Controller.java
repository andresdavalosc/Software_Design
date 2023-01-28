package controller;

import ticket.Ticket;
import user.User;

public interface Controller {
    void addTicket(Ticket t);

    void addUser(User u);

    void removeUser(User u);

}

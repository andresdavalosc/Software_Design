package controller;

import ticket.Ticket;
import user.User;

public interface Controller {

    void UserAdd(User u);

    void UserRemove(User u);

    void TicketAdd(Ticket t);


}

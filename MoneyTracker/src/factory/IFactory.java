package factory;

import ticket.Ticket;
import user.User;

import java.util.ArrayList;

public interface IFactory {
    User getUser(String name, int balance);

    Ticket getTicket(double amount, User paidBy, String event, boolean splitEven, ArrayList paidFor);
}

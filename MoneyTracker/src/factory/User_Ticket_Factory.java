package factory;

import ticket.Ticket;
import user.User;

import java.util.ArrayList;

public class User_Ticket_Factory implements IFactory {
    @Override
    public User getUser(String name, int balance) {
        return new User(name, balance);
    }
    @Override
    public Ticket getTicket(double amount, User paidBy, String event, boolean splitEven, ArrayList paidFor){
        return new Ticket(amount, paidBy, event, splitEven, paidFor);
    }
}

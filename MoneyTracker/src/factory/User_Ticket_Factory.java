package factory;
import ticket.Ticket;
import user.User;
import java.util.ArrayList;

public class User_Ticket_Factory implements IFactory {
    @Override
    public User getUser(String Username, int Saldo) {
        return new User(Username, Saldo);
    }
    @Override
    public Ticket getTicket(double amount, User paidBy, String event, boolean splitEven, ArrayList<User> paidFor){
        return new Ticket(amount, paidBy, event, splitEven, paidFor);
    }
}

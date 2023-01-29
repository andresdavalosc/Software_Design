package observers;

import ticket.Ticket;
import user.User;
import java.util.Observable;
import java.util.Observer;

import static java.lang.Math.abs;

public class Calculate_observer implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Ticket ticket = (Ticket) arg;
        User PaidBy = ticket.getPaidBy();
        for (User i : ticket.getPaidFor()) {
                System.out.println(i.getName());
                System.out.println(i.getName() + " needs to pay in total " + abs(i.getamountToPay()) + "€ to " + PaidBy.getName());
            }
    }
}

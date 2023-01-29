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
        if(ticket.isSplitEven()){
            for (User i : ticket.getPaidFor()) {
                if(!i.getName().equals(PaidBy.getName())){
                    System.out.println(i.getName() + " needs to pay in total " +  String.format("%.2f",abs(ticket.getAmount() / ticket.getPaidFor().size())) + "€ to " + PaidBy.getName());
                }
            }
        }else{
            for (User i : ticket.getPaidFor()) {
                System.out.println(i.getName() + " needs to pay in total " + abs(i.getamountToPay()) + "€ to " + PaidBy.getName());
            }
        }

    }
}

package observers;

import ticket.Ticket;
import user.User;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Saldo_observer implements Observer {

    double Saldo_users=0;
    @Override
    public void update(Observable o, Object arg) {
        Ticket ticket = (Ticket) arg;
        String ticket_name = ticket.getEvent();
        System.out.println("-------------Ticket:"+ ticket_name + "--------------");
        boolean Even = ticket.isSplitEven();

        ArrayList<User> PaidForList = ticket.getPaidFor();
        User PaidBy = ticket.getPaidBy();
        double Saldo = ticket.getAmount();
        Saldo_users = Saldo/PaidForList.size();
        if(Even){
            for(User user: PaidForList){
                user.setSaldo(user.getSaldo() - Saldo_users);
                System.out.println(user.getName()+ " Saldo: " +Math.round(user.getSaldo() * 100) / 100.0 + "€");
            }
        }else{
            PaidBy.setSaldo(PaidBy.getSaldo()+Saldo);
            for (User i : PaidForList) {
                i.setSaldo(i.getSaldo() - Saldo_users);
                System.out.println(i.getName()+ " Saldo: " + Math.round(i.getSaldo() * 100) / 100.0 + "€");
            }
        }

    }
}

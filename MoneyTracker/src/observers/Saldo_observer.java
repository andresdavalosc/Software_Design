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
        boolean Even = ticket.isSplitEven();
        String ticket_name = ticket.getEvent();
        System.out.println("----------****** Ticket:" + ticket_name + " ******--------");
        ArrayList<User> PaidForList = ticket.getPaidFor();
        User PaidBy = ticket.getPaidBy();
        double Saldo = ticket.getAmount();
        Saldo_users = Saldo / PaidForList.size();
        if (Even) {
            for (User user : PaidForList) {
                /*if(user.getName().equals(PaidBy.getName())){
                    user.setSaldo((user.getSaldo() - Saldo) + (Saldo_users * PaidForList.size()-1) );
                }else{
                    user.setSaldo(user.getSaldo() - Saldo_users);
                }*/
                user.setSaldo(user.getSaldo() - Saldo_users);
                System.out.println(user.getName() + " Current Saldo: " + String.format("%.2f", user.getSaldo()) + "€");
            }
        } else {

            int numUsers = PaidForList.size() + 1;
            double totalPercentage = 100.0;

            double currentPercentage = 5.0;
            double amountToPay = 0;

            amountToPay = (Saldo * currentPercentage) / 100.0;
            PaidBy.setSaldo(PaidBy.getSaldo() - amountToPay);
            PaidBy.setamountToPay(PaidBy.getamountToPay() - amountToPay);
            currentPercentage += 10.0;
            System.out.println(PaidBy.getName() + " paid " + String.format("%.2f", amountToPay) + "€, Current Saldo: " + String.format("%.2f", PaidBy.getSaldo()) + "€");

            for (int i = 0; i < PaidForList.size(); i++) {
                User user = PaidForList.get(i);
                if (i == PaidForList.size() - 1) {
                    amountToPay = (Saldo * (totalPercentage-(currentPercentage-10.0))) / 100.0;
                    user.setamountToPay(user.getamountToPay() - amountToPay);

                } else {
                    amountToPay = (Saldo * currentPercentage) / 100.0;
                    user.setamountToPay(user.getamountToPay() - amountToPay);
                    currentPercentage += 10.0;

                }
                user.setSaldo(user.getSaldo() - amountToPay);
                System.out.println(user.getName() + " paid " + String.format("%.2f", amountToPay) + "€, Current Saldo: " + String.format("%.2f", user.getSaldo()) + "€");
            }
        }
    }
}

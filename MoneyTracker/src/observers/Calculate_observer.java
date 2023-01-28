package observers;

import ticket.Ticket;
import user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import static java.lang.Math.abs;

public class Calculate_observer implements Observer {




    @Override
    public void update(Observable o, Object arg) {
        Ticket ticket = (Ticket) arg;
        User PaidBy = ticket.getPaidBy();
        boolean Even = ticket.isSplitEven();
        ArrayList<User> PaidForList = ticket.getPaidFor();
        HashMap<User, Double> users = new HashMap<>();
        double upper = 0;
        double lower = 0;
        User User_withMoreMoney= null;
        User User_withLessMoney=null;
        for (User i : PaidForList) {              // zet users in hashmap die balance niet op 0 hebben staan
            if (i.getSaldo() != 0)
                users.put(i, i.getSaldo());
        }

        if(!Even){
            if (PaidBy.getSaldo() != 0)
                users.put(PaidBy, PaidBy.getSaldo());
        }

        System.out.println(users.size());
        while (users.size() >= 2) {
            for (User i : users.keySet()) {  // overloopt alle users
                if (users.get(i) > upper) {
                    User_withMoreMoney = i;
                    upper = users.get(i);
                }
                if (users.get(i) < lower) {
                    User_withLessMoney = i;
                    lower = users.get(i);
                }
            }

            if (abs(upper) == abs(lower)) {
                System.out.println(User_withLessMoney.getName() + " has to pay " + Math.round(abs(lower * 100)) / 100.0 + "€ to " + User_withMoreMoney.getName());
                users.remove(User_withLessMoney);
                users.remove(User_withMoreMoney);
            } else if (abs(upper) < abs(lower)) {
                System.out.println(User_withLessMoney.getName() + " has to pay " + Math.round(abs(upper * 100)) / 100.0 + "€ to " + User_withMoreMoney.getName());
                users.remove(User_withMoreMoney);
                users.replace(User_withLessMoney, users.get(User_withLessMoney) + upper);
            } else {
                System.out.println(User_withLessMoney.getName() + " has to pay " + Math.round(abs(lower * 100)) / 100.0 + "€ to " + User_withMoreMoney.getName());
                users.remove(User_withLessMoney);
                users.replace(User_withMoreMoney, users.get(User_withMoreMoney) - lower);
            }
        }
    }
}

package observers;

import database.TicketDB;
import database.UserDB;
import register_entry.RegisterEntry;
import user.User;

import java.util.Observable;
import java.util.Observer;

public class User_observer implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        User user_name = (User) arg;
        RegisterEntry r = UserDB.getInstance().getEntry_user((User) arg);
        String name = user_name.getName();
        System.out.println(name+ " " + r);
    }
}

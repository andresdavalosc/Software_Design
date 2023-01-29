package database;

import register_entry.RegisterEntry;
import register_entry.RegisterEntryNull;
import ticket.Ticket;
import user.User;

import java.util.HashMap;

public class UserDB extends Database_Users {
    private final HashMap<User, RegisterEntry> db;
    private static UserDB Instance;

    public UserDB()
    {
        this.db = new HashMap<>();
    }
    public static UserDB getInstance(){
        if(Instance == null)
            Instance= new UserDB();
        return Instance;
    }
    @Override
    public void addEntry_user(User u, RegisterEntry re) {
        this.db.put(u, re);
        setChanged();
        notifyObservers(u);
    }

    @Override
    public RegisterEntry getEntry_user(User u) {
        return this.db.getOrDefault(u, new RegisterEntryNull());
    }
}

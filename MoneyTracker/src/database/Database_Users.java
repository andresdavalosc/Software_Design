package database;

import register_entry.RegisterEntry;
import user.User;

import java.util.Observable;

public abstract class Database_Users extends Observable {
    public Database_Users(){

    }

    public abstract void addEntry_user(User u, RegisterEntry re);
    public abstract RegisterEntry getEntry_user(User u);

}

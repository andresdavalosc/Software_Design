package database;

import register_entry.RegisterEntry;
import ticket.Ticket;

import java.util.Observable;

public abstract class Database_Tickets extends Observable {
    public Database_Tickets(){

    }

    public abstract void addEntry_Ticket(Ticket t, RegisterEntry re);
    public abstract RegisterEntry getEntry_Ticket(Ticket t);

}

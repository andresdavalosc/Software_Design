package database;

import register_entry.RegisterEntry;
import register_entry.RegisterEntryNull;
import ticket.Ticket;
import user.User;

import java.util.HashMap;

public class TicketDB extends Database_Tickets {
    private final HashMap<Ticket, RegisterEntry> db;
    private static TicketDB Instance;

    public TicketDB()
    {
        this.db = new HashMap<>();
    }
    public static TicketDB getInstance(){

        if(Instance == null)
            Instance= new TicketDB();
        return Instance;
    }
    @Override
    public void addEntry_Ticket(Ticket t, RegisterEntry re) {
        this.db.put(t, re);
        setChanged();
        notifyObservers(t);
    }

    @Override
    public RegisterEntry getEntry_Ticket(Ticket t) {
        return this.db.getOrDefault(t, new RegisterEntryNull());    }
}

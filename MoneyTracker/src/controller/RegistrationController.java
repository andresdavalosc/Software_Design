package controller;

import database.Database_Tickets;
import database.Database_Users;
import register_entry.RegisterEntry;
import ticket.Ticket;
import user.User;

public class RegistrationController implements Controller{
    private Database_Users db_u;
    private Database_Tickets db_t;
    public RegistrationController(Database_Tickets db_t, Database_Users db_u){
        this.db_t = db_t;
        this.db_u =db_u;
    }

    @Override
    public void UserAdd(User u) {
        RegisterEntry entry = new RegisterEntry(true);
        db_u.addEntry_user(u,entry);
    }

    @Override
    public void UserRemove(User u) {
        RegisterEntry entry = new RegisterEntry(false);
        db_u.addEntry_user(u,entry);

    }
    @Override
    public void TicketAdd(Ticket t) {
        RegisterEntry entry = new RegisterEntry(true);
        db_t.addEntry_Ticket(t, entry);
    }
}

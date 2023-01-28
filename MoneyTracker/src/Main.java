import controller.RegistrationController;
import database.Database_Tickets;
import database.Database_Users;
import database.TicketDB;
import database.UserDB;
import observers.Calculate_observer;
import observers.DBupdate_observer;
import observers.Saldo_observer;
import observers.User_observer;
import view.*;

public class Main {
    public static void main(String[] args) {
        Database_Users Db_u = UserDB.getInstance();
        Database_Tickets Db_t = TicketDB.getInstance();
        RegistrationController register = new RegistrationController(Db_t,Db_u);
        ViewFrame draw = new ViewFrame(register);
        draw.initialize();
        DBupdate_observer db_o = new DBupdate_observer();
        User_observer u_o = new User_observer();
        Saldo_observer s_o = new Saldo_observer();
        Calculate_observer c_o = new Calculate_observer();
        Db_u.addObserver(db_o);
        Db_u.addObserver(u_o);
        Db_u.addObserver(draw);
        Db_t.addObserver(s_o);
        Db_t.addObserver(c_o);
        Db_t.addObserver(draw);
    }
}
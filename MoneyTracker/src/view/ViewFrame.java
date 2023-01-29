package view;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;
import controller.RegistrationController;
import database.TicketDB;
import database.UserDB;
import ticket.Ticket;
import user.User;
import view.panels.*;

public class ViewFrame extends JFrame implements Observer {
    RegistrationController controller;

    DrawPanel extra;
    ListPanel panel;

    public ViewFrame(RegistrationController controller)
    {
        super("MoneyTracker");
        this.controller=controller;
    }

    public void initialize() {
        setSize(480, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel = new ListPanel();
        extra = new DrawPanel(this.controller,panel);
        this.add(extra);
        this.setVisible(true);
    }


    @Override
    public void update(Observable o, Object arg) {
        if( arg instanceof User){
            this.panel.addEntry(UserDB.getInstance().getEntry_user((User)arg));
        }else{
            this.panel.addEntry(TicketDB.getInstance().getEntry_Ticket((Ticket) arg));
        }
    }
}

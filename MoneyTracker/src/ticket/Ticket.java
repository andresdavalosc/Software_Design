package ticket;

import user.User;

import java.util.ArrayList;

public class Ticket {
    private final double amount;
    private final User paidBy;
    private final String event;
    private final boolean splitEven;
    private final ArrayList<User> paidFor;


    public Ticket(double amount, User paidBy, String event, boolean splitEven, ArrayList<User> paidFor) {
        this.amount = amount;
        this.paidBy = paidBy;
        this.event = event;
        this.splitEven = splitEven;
        this.paidFor = paidFor;
    }

    public boolean isSplitEven() {
        return splitEven;
    }

    public String getEvent() {
        return event;
    }


    public double getAmount() {
        return amount;
    }


    public User getPaidBy() {
        return paidBy;
    }


    public ArrayList<User> getPaidFor() {
        return paidFor;
    }

}

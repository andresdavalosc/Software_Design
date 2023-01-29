package factory;

public class Factory {
    public static IFactory IFactory() {
        return new User_Ticket_Factory();
    }
}

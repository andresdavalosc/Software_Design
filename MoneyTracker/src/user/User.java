package user;

public class User {
    private String name;
    private double balance;

    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;

    }

    public String getName() {
        return name;
    }


    public double getSaldo() {
        return balance;
    }

    public void setSaldo(double balance) {
        this.balance = balance;
    }
}

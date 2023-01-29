package user;

public class User {
    private String name;
    private double Saldo;
    private double Pay;

    public User(String name, double Saldo) {
        this.name = name;
        this.Saldo = Saldo;

    }

    public String getName() {
        return name;
    }


    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    public double getamountToPay(){
        return Pay;
    }

    public void setamountToPay(double pay){
        this.Pay = pay;
    }
}

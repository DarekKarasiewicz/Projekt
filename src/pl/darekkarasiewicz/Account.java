package pl.darekkarasiewicz;

public class Account {
    private int pin ;
    private int number;
    private int balance;

    public Account() {
    }

    public Account(int pin, int number, int balance) {
        this.pin = pin;
        this.number = number;
        this.balance = balance;
    }


    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

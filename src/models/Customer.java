package models;

import java.util.ArrayList;

public class Customer extends User {

    private int balance;
    private final ArrayList<Sellable> purchasedSellables;

    public Customer(String username, String password) {
        super(username, password);
        this.purchasedSellables = new ArrayList<>();
        this.balance = 0;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int amount) {
        this.balance = amount;
    }

    public void increaseBalance(int amount) {
        this.setBalance(this.getBalance() + amount);
    }

    public void decreaseBalance(int amount) {
        this.setBalance(this.getBalance() - amount);
    }

    public void addPurchasedSellables(Sellable sellable) {
        this.purchasedSellables.add(sellable);
    }
}

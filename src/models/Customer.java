package models;

import java.util.ArrayList;

public class Customer extends User {

    private final static ArrayList<Customer> ALL_CUSTOMERS = new ArrayList<>();
    private final ArrayList<String> accountNumbers;
    private int accountCredit;

    public Customer(String username, String password) {
        super(username, password);
        this.accountNumbers = new ArrayList<>();
        this.accountCredit = 0;
        Customer.ALL_CUSTOMERS.add(this);
    }

    public static ArrayList<Customer> getAllCustomers() {
        return Customer.ALL_CUSTOMERS;
    }

    public ArrayList<String> getAccountNumbers() {
        return accountNumbers;
    }

    public static Customer getCustomerByUsername(String username) {
        for (Customer customer : Customer.ALL_CUSTOMERS) {
            if (customer.getUsername().equals(username))
                return customer;
        }
        return null;
    }

    public int getAccountCredit() {
        return accountCredit;
    }

    public void setAccountCredit(int accountCredit) {
        this.accountCredit = accountCredit;
    }
}

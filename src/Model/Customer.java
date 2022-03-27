package Model;

import java.util.ArrayList;

public class Customer extends User {

    private static ArrayList<Customer> allCustomers;
    private ArrayList<String> accountNumbers;
    private int accountCredit;

    {
        allCustomers = new ArrayList<>();
    }

    public Customer(String username, String Password) {
        super();
        this.accountNumbers = new ArrayList<>();
        this.accountCredit = 0;
        this.setUsername(username);
        this.setPassword(password);
        allCustomers.add(this);
    }


    public static ArrayList<Customer> getAllCustomers() {
        return allCustomers;
    }

    public ArrayList<String> getAccountNumbers() {
        return accountNumbers;
    }

    public static Customer getCustomerByUsername(String username) {
        for (Customer customer : allCustomers) {
            if (customer.getUsername().equals(username)) return customer;
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

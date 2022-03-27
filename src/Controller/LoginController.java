package Controller;

import Model.Customer;

public class LoginController {

    public String canRegister(String username, String password, String repeatPassword) {
        if (isCustomerFound(username)) return "repeated username";
        String error = validatePassword(password, repeatPassword);
        if (!error.equals("OK")) return error;
        Customer customer = new Customer(username, password);
        return "done";
    }

    private String validatePassword(String password, String repeated) {
        if (!password.equals(repeated)) return "passwords doesn't match";
        if (password.length() < 5) return "password too short";
        if (password.length() > 20) return "password too long";
        if (!isAlphaNumeric(password)) return "password should contain alphaNumeric Characters";
        return "OK";
    }

    private Boolean isAlphaNumeric(String string) {
        return string.matches("[a-zA-Z0-9]+");
    }

    private Boolean isCustomerFound(String username) {
        for (Customer customer : Customer.getAllCustomers()) {
            if (customer.getUsername().equals(username)) return true;
        }
        return false;
    }
}

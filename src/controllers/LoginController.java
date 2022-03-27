package controllers;

import enums.ACCESS;
import models.Admin;
import models.Customer;
import models.User;
import views.Menu;

public class LoginController {
    private static LoginController instance = null;

    private LoginController() {
    }

    private static void setInstance(LoginController instance) {
        LoginController.instance = instance;
    }

    public static LoginController getInstance() {
        if (LoginController.instance == null) {
            LoginController.setInstance(new LoginController());
        }
        return LoginController.instance;
    }

    public String canRegister(String username, String password, String repeatPassword) {
        if (isCustomerFound(username))
            return "repeated username";
        String error = validatePassword(password, repeatPassword);
        if (!error.equals("OK"))
            return error;
        Customer customer = new Customer(username, password);
        return "done";
    }

    public String createAdmin(String username, String password, String repeatPassword, String accessLevel) {
        if (isCustomerFound(username))
            return "repeated username";
        String error = validatePassword(password, repeatPassword);
        if (!error.equals("OK"))
            return error;
        ACCESS accessModifier;
        if (accessLevel.equalsIgnoreCase("ceo"))
            accessModifier = ACCESS.CEO;
        else if (accessLevel.equalsIgnoreCase("manager"))
            accessModifier = ACCESS.MANAGER;
        else if (accessLevel.equalsIgnoreCase("accountant"))
            accessModifier = ACCESS.ACCOUNTANT;
        else if (accessLevel.equalsIgnoreCase("simple"))
            accessModifier = ACCESS.SIMPLE;
        else {
            return "wrong access level";
        }
        Admin admin = new Admin(username, password, accessModifier);
        return "done";
    }

    public String login(String username, String password) {
        User user = User.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            Menu.setLoggedInUser(user);
            return "done";
        }
        return "Wrong Credentials !";
    }

    private String validatePassword(String password, String repeated) {
        if (!password.equals(repeated))
            return "passwords doesn't match";
        if (password.length() < 5)
            return "password too short";
        if (password.length() > 20)
            return "password too long";
        if (!isAlphaNumeric(password))
            return "password should contain alphaNumeric Characters";
        return "OK";
    }

    private Boolean isAlphaNumeric(String string) {
        return string.matches("[a-zA-Z0-9]+");
    }

    private Boolean isCustomerFound(String username) {
        for (Customer customer : Customer.getAllCustomers()) {
            if (customer.getUsername().equals(username))
                return true;
        }
        return false;
    }
}

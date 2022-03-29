package controllers;

import enums.Message;
import enums.Role;
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

    public Message handleLogin(String username, String password) {
        User user = User.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            Menu.setLoggedInUser(user);
            return Message.SUCCESS;
        }
        return Message.WRONG_CREDENTIALS;
    }

    private Message validatePassword(String password, String repeatedPassword) {
        if (!password.equals(repeatedPassword))
            return Message.MISMATCH_PASSWORD;
        if (password.length() < 5)
            return Message.SHORT_PASSWORD;
        if (password.length() > 20)
            return Message.LONG_PASSWORD;
        if (!isAlphaNumeric(password))
            return Message.NON_ALPHANUMERIC_PASSWORD;
        return Message.SUCCESS;
    }

    private Boolean isAlphaNumeric(String string) {
        return string.matches("[a-zA-Z0-9]+");
    }

    private Boolean doesUsernameExist(String username) {
        return User.getUserByUsername(username) != null;
    }

    public Message handleCreateCustomer(String username, String password, String repeatedPassword) {
        if (this.doesUsernameExist(username)) {
            return Message.USERNAME_EXIST;
        }
        Message message;
        if ((message = this.validatePassword(password, repeatedPassword)) != Message.SUCCESS) {
            return message;
        }
        new Customer(username, password);
        return Message.SUCCESS;
    }

    public Message handleCreateAdmin(String username, String password, String repeatedPassword, String role) {
        if (this.doesUsernameExist(username)) {
            return Message.USERNAME_EXIST;
        }

        Message message;
        if ((message = this.validatePassword(password, repeatedPassword)) != Message.SUCCESS) {
            return message;
        }

        Role adminRole = Role.getRoleFromString(role);
        if (adminRole == null) {
            return Message.WRONG_ROLE_LEVEL;
        }
        new Admin(username, password, adminRole);

        return Message.SUCCESS;

    }

}

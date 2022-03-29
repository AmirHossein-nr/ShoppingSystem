package views;

import java.util.Scanner;

import controllers.LoginController;
import enums.Message;

public class LoginMenu extends Menu {
    // Singleton Pattern
    private static LoginMenu instance = null;

    private LoginController controller;

    // Singleton Pattern
    private LoginMenu() {
        super("login menu");
        this.controller = LoginController.getInstance();
    }

    // Singleton Pattern
    private static void setInstance(LoginMenu instance) {
        LoginMenu.instance = instance;
    }

    // Singleton Pattern
    public static LoginMenu getInstance() {
        if (LoginMenu.instance == null) {
            LoginMenu.setInstance(new LoginMenu());
        }
        return LoginMenu.instance;
    }

    @Override
    protected void showOptions() {
        System.out.println("Please Enter One of the options below:");
        System.out.println("1. register");
        System.out.println("2. login");
        System.out.println("3. exit");
    }

    @Override
    public void run() {
        this.showOptions();

        String choice = this.getChoice();

        switch (choice) {
            case "register":
            case "1":
                this.register();
                break;
            case "login":
            case "2":
                this.login();
                break;
            case "exit":
            case "3":
                this.exit();
                break;
            default:
                System.out.println(Message.INVALID_CHOICE);
                break;
        }
    }

    private void exit() {
        System.out.println("goodbye :(");
        Menu.getScanner().close();
    }

    private void login() {
        String username = this.getInput("username");
        String password = this.getInput("password");

        Message message = this.controller.handleLogin(username, password);

        if (message == Message.SUCCESS) {
            System.out.println("Logged in Successfully!");
            MainMenu.getInstance().run();
            this.run();
            return;
        }
        System.out.println(message);
        this.run();
    }

    private void registerCustomer() {
        String username = this.getInput("username");
        String password = this.getInput("password");
        String repeatedPassword = this.getInput("Repeat Password");

        Message message = this.controller.handleCreateCustomer(username, password, repeatedPassword);

        System.out.println(message == Message.SUCCESS ? "Customer Created Successfully!" : message);
    }

    private void registerAdmin() {

        String username = this.getInput("username");
        String password = this.getInput("password");
        String repeatedPassword = this.getInput("Repeat Password");
        String role = this.getInput("Enter Role of this user: (CEO/MANAGER/ACCOUNTANT/SIMPLE)");

        Message message = this.controller.handleCreateAdmin(username, password, repeatedPassword, role);

        System.out.println(message == Message.SUCCESS ? "admin created Successfully!" : message);
    }

    private void register() {
        System.out.println("Now, please enter \"admin\" or \"customer\" for specific registration:");

        String choice = this.getChoice();

        if (choice.equals("customer")) {
            this.registerCustomer();
        } else if (choice.equals("admin")) {
            this.registerAdmin();
        } else {
            System.out.println(Message.INVALID_CHOICE);
        }

        this.run();
    }
}

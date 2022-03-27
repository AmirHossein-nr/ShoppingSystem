package views;

import java.util.Scanner;

import controllers.LoginController;
import enums.Messages;

public class LoginMenu extends Menu {
    private static LoginMenu instance = null;

    private LoginController controller;

    private static void setInstance(LoginMenu instance) {
        LoginMenu.instance = instance;
    }

    public static LoginMenu getInstance() {
        if (LoginMenu.instance == null) {
            LoginMenu.setInstance(new LoginMenu());
        }
        return LoginMenu.instance;
    }

    private LoginMenu() {
        super("login menu");
        this.controller = LoginController.getInstance();
    }

    protected void showOptions() {
        System.out.println("Hello! Please Enter One of the options below: ");
        System.out.println("1. register");
        System.out.println("2. login");
        System.out.println("3. exit");
    }

    @Override
    public void run() {
        this.showOptions();
        String input = LoginMenu.getScanner().nextLine().trim().toLowerCase();

        switch (input) {
            case "register":
            case "1":
                this.register();
                this.run();
                break;
            case "login":
            case "2":
                this.login();
                break;
            case "exit":
            case "3":
                break;
            default:
                System.out.println(Messages.INVALID_CHOICE);
                this.run();
                break;
        }
    }

    private void login() {
        Scanner scanner = LoginMenu.getScanner();
        System.out.println("username: ");
        String username = scanner.nextLine().trim();
        System.out.println("password: ");
        String password = scanner.nextLine().trim();
        String validate = this.controller.login(username, password);
        if (validate.equalsIgnoreCase("done")) {
            System.out.println("Logged in Successfully!");
            MainMenu.getInstance().run();
            return;
        }
        System.out.println(validate);
        this.run();
    }

    private void registerCustomer() {
        Scanner scanner = LoginMenu.getScanner();

        System.out.println("username: ");
        String username = scanner.nextLine().trim();
        System.out.println("Password: ");
        String password = scanner.nextLine().trim();
        System.out.println("Repeat Password: ");
        String repeatPassword = scanner.nextLine().trim();
        String validate = controller.canRegister(username, password, repeatPassword);
        if (!validate.equals("done")) {
            System.out.println(validate);
            return;
        }
        System.out.println("Customer Created Successfully!");
    }

    private void registerAdmin() {
        Scanner scanner = LoginMenu.getScanner();

        System.out.println("username: ");
        String username = scanner.nextLine().trim();
        System.out.println("Password: ");
        String password = scanner.nextLine().trim();
        System.out.println("repeat password: ");
        String repeatPassword = scanner.nextLine().trim();
        System.out.println("Enter Access Level of this user: (CEO/MANAGER/ACCOUNTANT/SIMPLE)");
        String access = scanner.nextLine().trim();
        String validate = this.controller.createAdmin(username, password, repeatPassword, access);
        if (!validate.equals("done")) {
            System.out.println(validate);
            return;
        }
        System.out.println("admin created Successfully!");
    }

    private void register() {
        System.out.println("Now, please enter \"admin\" or \"customer\" for specific registration: ");

        String choice = LoginMenu.getScanner().nextLine().trim().toLowerCase();
        if (choice.equals("customer")) {
            this.registerCustomer();
        } else if (choice.equals("admin")) {
            this.registerAdmin();
        } else {
            System.out.println(Messages.INVALID_CHOICE);
        }
    }
}

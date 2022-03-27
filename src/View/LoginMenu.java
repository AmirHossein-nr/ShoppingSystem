package View;

import Controller.LoginController;

public class LoginMenu extends Menu {

    private static LoginMenu instance = null;
    private static LoginController controller = null;

    public static LoginMenu getInstance() {
        if (instance == null) {
            instance = new LoginMenu();
            controller = new LoginController();
        }
        return instance;
    }

    private LoginMenu() {
        super("login menu");
        this.run();
    }

    private void run() {
        System.out.println("Hello! Please Enter One of the options below: ");
        System.out.println("1. register");
        System.out.println("2. login");

        label:
        while (true) {
            String input = this.getScanner().nextLine().trim().toLowerCase();
            switch (input) {
                case "register":
                case "1":
                    register();
                    this.run();
                    break;
                case "login":
                case "2":
                    login();
                    break;
                case "end":
                    break label;
                default:
                    System.out.println("Invalid Input. Please Try Again ...");
                    break;
            }
        }

    }

    private void login() {
        System.out.println("username: ");
        String username = getScanner().nextLine().trim();
        System.out.println("password: ");
        String password = getScanner().nextLine().trim();
        String validate = controller.login(username, password);
        if (validate.equalsIgnoreCase("done")) {
            System.out.println("Logged in Successfully!");
            return;
        }
        System.out.println(validate);
    }

    private void register() {
        System.out.println("Now, please enter \"admin\" or \"customer\" for specific registration: ");
        String choice = this.getScanner().nextLine().trim().toLowerCase();
        if (choice.equals("customer")) {
            System.out.println("username: ");
            String username = getScanner().next().trim();
            System.out.println("Password: ");
            String password = getScanner().next().trim();
            System.out.println("Repeat Password: ");
            String repeatPassword = getScanner().next().trim();
            String validate = controller.canRegister(username, password, repeatPassword);
            if (!validate.equals("done")) {
                System.out.println(validate);
                return;
            }
            System.out.println("Customer Created Successfully!");
        } else if (choice.equals("admin")) {
            System.out.println("username: ");
            String username = getScanner().next().trim();
            System.out.println("Password: ");
            String password = getScanner().next().trim();
            System.out.println("repeat password: ");
            String repeatPassword = getScanner().next().trim();
            System.out.println("Enter Access Level of this user: (CEO/MANAGER/ACCOUNTANT/SIMPLE");
            String access = getScanner().next().trim();
            String validate = controller.createAdmin(username, password, repeatPassword, access);
            if (!validate.equals("done")) {
                System.out.println(validate);
                return;
            }

            System.out.println("admin created Successfully!");
        } else {
            System.out.println("Invalid Choice! Please Try Again ...");
        }
    }
}

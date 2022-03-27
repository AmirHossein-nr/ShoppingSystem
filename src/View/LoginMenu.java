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

        while (true) {
            String input = this.getScanner().nextLine().trim().toLowerCase();
            if (input.equals("register") || input.equals("1")) {
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
                        continue;
                    }
                    System.out.println("Customer Created Successfully!");
                } else if (choice.equals("admin")) {
                    System.out.println("username: ");
                    String username = getScanner().next().trim();
                    System.out.println("Password: ");
                    String password = getScanner().next().trim();
                    System.out.println("repeat password: ");
                    String repeatPassword = getScanner().next().trim();
                } else {
                    System.out.println("Invalid Choice! Please Try Again ...");
                }
            } else if (input.equals("login") || input.equals("2")) {

            } else {
                System.out.println("Invalid Input. Please Try Again ...");
            }
        }
    }
}

package views;

import java.util.Scanner;

import controllers.MainController;
import enums.Messages;
import models.Customer;
import models.Product;
import models.Sellable;
import models.User;

public class MainMenu extends Menu {
    private static MainMenu instance = null;

    private MainController controller;

    private MainMenu() {
        super("main menu");
        this.controller = MainController.getInstance();
    }

    private static void setInstance(MainMenu instance) {
        MainMenu.instance = instance;
    }

    public static MainMenu getInstance() {
        if (MainMenu.instance == null) {
            MainMenu.setInstance(new MainMenu());
        }
        return MainMenu.instance;
    }

    @Override
    protected void showOptions() {
        User loggedInUser = Menu.getLoggedInUser();
        System.out.println("Hello " + loggedInUser.getUsername() + " !");
        System.out.println("Please Enter one of the choices below: ");
        int logoutOptionNumber = 0;
        if (loggedInUser instanceof Customer) {
            System.out.println("1. See All of Products and Services");
            System.out.println("2. Send Message to Support");
            logoutOptionNumber = 3;
        } else { // Admin
            System.out.println("1. See All of Products and Services");
            System.out.println("2. Add a new Product");
            System.out.println("3. Edit existing product");
            logoutOptionNumber = 4;
        }
        System.out.println(String.format("%d. logout", logoutOptionNumber));

    }

    private void handleCustomerChoice() {
        String choice = MainMenu.getScanner().nextLine().trim();

        if (choice.equals("1")) {
            this.printAllProducts();
            this.run();

        } else if (choice.equals("2")) {
            this.sendMessage();
            this.run();

        } else if (choice.equals("3")) {
            this.logout();
        } else {
            System.out.println(Messages.INVALID_CHOICE);
            this.run();
        }

    }

    private void logout() {
        Menu.setLoggedInUser(null);
        LoginMenu.getInstance().run();
    }

    private void addNewProduct() {
        Scanner scanner = MainMenu.getScanner();
        System.out.println("now, enter the information below: ");
        System.out.println("Product name : ");
        String name = scanner.nextLine().trim();
        System.out.println("Product Price");
        float price = scanner.nextFloat();
        String validate = this.controller.createProduct(name, price);
        if (!validate.equals("done")) {
            System.out.println(validate);
            this.run();
        }
        System.out.println("Product Created Successfully ! Here is the information : ");
        System.out.println(Product.getSellableByName(name)); // why using model methods in view?
    }

    private void editProduct() {
        // todo: edit product
    }

    private void handleAdminChoice() {
        String choice = MainMenu.getScanner().nextLine().trim();

        if (choice.equals("1")) {
            this.printAllProducts();
            this.run();
        } else if (choice.equals("2")) {
            this.addNewProduct();
            this.run();
        } else if (choice.equals("3")) {
            this.editProduct();
            this.run();
        } else if (choice.equals("4")) {
            this.logout();
        } else {
            System.out.println(Messages.INVALID_CHOICE);
            this.run();
        }
    }

    @Override
    public void run() {
        this.showOptions();
        if (getLoggedInUser() instanceof Customer) {
            this.handleCustomerChoice();
        } else {
            this.handleAdminChoice();
        }
    }

    private void sendMessage() {
        // todo: send message
    }

    private void printAllProducts() {
        for (Sellable product : Product.getAllItems()) {
            System.out.println(product);
        }
    }

}

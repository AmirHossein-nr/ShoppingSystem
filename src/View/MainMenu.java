package View;

import Controller.MainController;
import Model.Customer;
import Model.Product;
import Model.Sellable;

public class MainMenu extends Menu {
    private static MainMenu instance;
    private static MainController controller;

    private MainMenu() {
        super("main menu");
        this.run();
    }

    private void run() {
        if (getLoggedUser() instanceof Customer) {
            System.out.println("Hello " + getLoggedUser().getUsername() + " !");
            System.out.println("Please Enter one of the choices below: ");
            System.out.println("1. See All of Products and Services");
            System.out.println("2. Send Message to Support");
            String choice = getScanner().nextLine().trim();
            if (choice.equals("1")) {
                this.printAllProducts();
            } else if (choice.equals("2")) {
                this.sendMessage();
            } else {
                System.out.println("Invalid Choice . Try Again !");
                this.run();
            }
        } else {
            System.out.println("Hello " + getLoggedUser().getUsername() + " !");
            System.out.println("Please Enter one of the choices below: ");
            System.out.println("1. See All of Products and Services");
            System.out.println("2. Add a new Product");
            System.out.println("3. Edit existing product");
            String choice = getScanner().nextLine().trim();
            if (choice.equals("1")) {
                this.printAllProducts();
            } else if (choice.equals("2")) {
                System.out.println("now, enter the information below: ");
                System.out.println("Product name : ");
                String name = getScanner().nextLine().trim();
                System.out.println("Product Price");
                float price = getScanner().nextFloat();
                String validate = controller.createProduct(name, price);
                if (!validate.equals("done")) {
                    System.out.println(validate);
                    this.run();
                }
                System.out.println("Product Created Successfully ! Here is the information : ");
                System.out.println(Product.getSellableByName(name));
            } else if (choice.equals("3")) {
                //todo: edit product
            } else {
                System.out.println("Invalid Choice! please try again.");
            }
        }
    }

    private void sendMessage() {
        //todo: send message
    }

    private void printAllProducts() {
        for (Sellable product : Product.getAllItems()) {
            System.out.println(product);
        }
    }

    public static MainMenu getInstance() {
        if (instance == null) {
            instance = new MainMenu();
            controller = new MainController();
        }
        return instance;
    }

}

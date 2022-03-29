package views;

import controllers.MainController;
import enums.Message;
import models.Admin;
import models.Customer;
import models.Sellable;
import models.User;

public class MainMenu extends Menu {
    // Singleton Pattern
    private static MainMenu instance = null;

    private MainController controller;

    // Singleton Pattern
    private MainMenu() {
        super("main menu");
        this.controller = MainController.getInstance();
    }

    // Singleton Pattern
    private static void setInstance(MainMenu instance) {
        MainMenu.instance = instance;
    }

    // Singleton Pattern
    public static MainMenu getInstance() {
        if (MainMenu.instance == null) {
            MainMenu.setInstance(new MainMenu());
        }
        return MainMenu.instance;
    }

    @Override
    public void run() {
        this.showOptions();

        String choice = this.getChoice();

        if (Menu.getLoggedInUser() instanceof Customer) {
            this.handleCustomerChoice(choice);
        } else if (Menu.getLoggedInUser() instanceof Admin) {
            this.handleAdminChoice(choice);
        }
    }

    @Override
    protected void showOptions() {
        User loggedInUser = Menu.getLoggedInUser();
        System.out.println("Hello " + loggedInUser.getUsername() + "!");
        System.out.println("Please Enter one of the choices below:");
        System.out.println("1. Profile");
        System.out.println("2. See All products");
        if (loggedInUser instanceof Customer) {
            System.out.println("3. Buy a product");
            System.out.println("4. increase balance");
            System.out.println("5. logout");

        } else if (loggedInUser instanceof Admin) {
            System.out.println("3. Add new product");
            System.out.println("4. logout");
        }

    }

    private void handleCustomerChoice(String choice) {
        if (choice.equals("1")) {
            this.showProfile();
        } else if (choice.equals("2")) {
            this.printAllProducts();

        } else if (choice.equals("3")) {
            this.buyProduct();

        } else if (choice.equals("4")) {
            this.increaseBalance();
        } else if (choice.equals("5")) {
            this.logout();
        } else {
            System.out.println(Message.INVALID_CHOICE);
            this.run();
        }

    }

    private void increaseBalance() {
        int amount = Integer.parseInt(this.getInput("amount"));
        Message message = this.controller.handleIncreaseBalance((Customer) Menu.getLoggedInUser(), amount);
        System.out.println(message == Message.SUCCESS ? "increased" : message);
        this.run();
    }

    private void buyProduct() {
        int sellableId = Integer.parseInt(getInput("Enter product id"));
        Message message = this.controller.handleBuyProduct((Customer) Menu.getLoggedInUser(), sellableId); // downCasting
        System.out.println(message == Message.SUCCESS ? "Product purchased Successfully" : message);
        this.run();
    }

    private void handleAdminChoice(String choice) {
        if (choice.equals("1")) {
            this.showProfile();
        } else if (choice.equals("2")) {
            this.printAllProducts();

        } else if (choice.equals("3")) {
            this.addNewProduct();
        } else if (choice.equals("4")) {
            this.logout();
        } else {
            System.out.println(Message.INVALID_CHOICE);
            this.run();
        }
    }

    private void showProfile() {
    }

    private void logout() {
        Menu.setLoggedInUser(null);
    }

    private void addNewProduct() {

        System.out.println("now, enter the information below: ");

        String name = this.getInput("Product name");
        int price = Integer.parseInt(this.getInput("Product price"));
        String description = this.getInput("Description");

        Message message = this.controller.handleAddProduct(name, price, description);
        System.out.println(message == Message.SUCCESS ? "Product Created Successfully !" : message);
        this.run();
    }

    private void printAllProducts() {
        for (Sellable sellable : Sellable.getAllItems()) {
            System.out.println(sellable);
        }
        this.run();
    }

}

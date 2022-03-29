package controllers;

import enums.Message;
import models.Customer;
import models.Product;
import models.Sellable;
import models.User;

public class MainController {
    private static MainController instance = null;

    private MainController() { // singleton
    }

    private static void setInstance(MainController instance) {
        MainController.instance = instance;
    }

    public static MainController getInstance() {
        if (MainController.instance == null) {
            MainController.setInstance(new MainController());
        }
        return MainController.instance;
    }

    public Message handleAddProduct(String name, int price, String description) {
        for (Sellable sellable : Sellable.getAllItems()) {
            if (sellable instanceof Product && sellable.getName().equals(name) && sellable.getPrice() == price
                    && ((Product) sellable).getDescription().equals(description)) {
                return Message.PRODUCT_EXIST;
            }
        }

        new Product(name, price, description);

        return Message.SUCCESS;
    }

    public Message handleBuyProduct(Customer loggedInUser, int sellableId) {
        Sellable item = Sellable.getSellableById(sellableId);
        if (item == null) {
            return Message.SELLABLE_NOT_EXIST;
        }
        if (loggedInUser.getBalance() < item.getPrice()) {
            return Message.NOT_ENOUGH_MONEY;
        }
        loggedInUser.decreaseBalance(item.getPrice());
        loggedInUser.addPurchasedSellables(item);
        return Message.SUCCESS;
    }

    public Message handleIncreaseBalance(Customer customer, int amount) {
        customer.increaseBalance(amount);
        return Message.SUCCESS;
    }
}

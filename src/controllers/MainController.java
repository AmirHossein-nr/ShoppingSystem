package controllers;

import models.Product;
import models.Sellable;

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

    public String createProduct(String name, float price) {
        for (Sellable product : Product.getAllItems()) {
            if (product.getName().equals(name))
                return "This name already exists";
        }
        if (price <= 0) {
            return "Invalid price";
        }
        Product product = new Product(name, price);
        return Product.getSellableByName(name).toString();
    }
}

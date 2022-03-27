package Controller;

import Model.Product;
import Model.Sellable;

public class MainController {
    public String createProduct(String name, float price) {
        for (Sellable product : Product.getAllItems()) {
            if (product.getName().equals(name)) return "This name already exists";
        }
        if (price <= 0) {
            return "Invalid price";
        }
        Product product = new Product(name, price);
        return "done";
    }
}

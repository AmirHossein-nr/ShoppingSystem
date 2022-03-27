package models;

public class Product extends Sellable {

    private String description;

    public Product(String name, float price) {
        super();
        this.setName(name);
        this.setPrice(price);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}

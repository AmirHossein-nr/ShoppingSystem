package models;

public class Product extends Sellable {

    private String description;

    public Product(String name, int price, String description) {
        super(name, price);

        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    // public void setAmount(int amount) {
    // this.amount = amount;
    // }

    // public int getAmount() {
    // return this.amount;
    // }

    // public void decreaseAmount(int amount) {
    // this.setAmount(this.getAmount() - amount);
    // }

    @Override
    public String toString() {
        return super.toString() + "| description: " + this.getDescription();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Product)) {
            return false;
        }

        Product product = (Product) obj;

        return this.getName().equals(product.getName()) && this.getPrice() == product.getPrice()
                && this.getDescription().equals(product.getDescription());
    }

}

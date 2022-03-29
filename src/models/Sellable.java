package models;

import java.util.ArrayList;

public abstract class Sellable implements Comparable<Sellable> {
    private static int idCounter = 0;
    private final static ArrayList<Sellable> ALL_ITEMS = new ArrayList<>();

    private final int id;
    private final ArrayList<Comment> comments;
    private String name;
    private int price;

    // static {
    // idCounter = 0;
    // allItems = new ArrayList<>();
    // }

    public Sellable(String name, int price) {
        this.comments = new ArrayList<>();
        this.id = ++idCounter;
        this.name = name;
        this.price = price;
        Sellable.ALL_ITEMS.add(this);
    }

    public static ArrayList<Sellable> getAllItems() {
        return Sellable.ALL_ITEMS;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public static Sellable getSellableById(int id) {
        for (Sellable sellable : Sellable.ALL_ITEMS) {
            if (sellable.getId() == id)
                return sellable;
        }
        return null;
    }

    @Override
    public int compareTo(Sellable obj) {
        if (!this.name.equals(obj.name)) {
            return this.name.compareTo(obj.name);
        }
        if (this.price > obj.price) {
            return 1;
        }
        if (this.price < obj.price) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "id: " + this.getId() + "| name: " + this.getName() + " | price: " + this.getPrice();
    }
}

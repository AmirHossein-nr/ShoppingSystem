package Model;

import java.util.ArrayList;

public abstract class Sellable {
    private static int idCounter;
    private static ArrayList<Sellable> allItems;
    private int id;
    private String name;
    private float price;
    private ArrayList<Comment> comments;

    static {
        idCounter = 0;
        allItems = new ArrayList<>();
    }

    public Sellable() {
        comments = new ArrayList<>();
        idCounter++;
        this.id = idCounter;
        allItems.add(this);
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static ArrayList<Sellable> getAllItems() {
        return allItems;
    }

    public static void setAllItems(ArrayList<Sellable> allItems) {
        Sellable.allItems = allItems;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}

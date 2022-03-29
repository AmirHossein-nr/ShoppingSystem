package views;

import java.util.Scanner;

import models.User;

public abstract class Menu {
    private final static Scanner SCANNER = new Scanner(System.in);
    private static User loggedInUser = null;

    protected final String menuName;

    protected Menu(String name) {
        this.menuName = name;
    }

    public abstract void run(); // All children should implement this method.

    protected abstract void showOptions(); // All children should implement this method.

    protected static Scanner getScanner() {
        return Menu.SCANNER;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public static void setLoggedInUser(User loggedInUser) {
        Menu.loggedInUser = loggedInUser;
    }

    public static User getLoggedInUser() {
        return Menu.loggedInUser;
    }

    protected String getInput(String message) {
        System.out.println(message + ":");
        return Menu.getScanner().nextLine().trim();
    }

    protected String getChoice() {
        return Menu.getScanner().nextLine().trim().toLowerCase();
    }

}

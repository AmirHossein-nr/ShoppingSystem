package views;

import java.util.Scanner;

import models.User;

public abstract class Menu {
    private final static Scanner SCANNER = new Scanner(System.in);
    private static User loggedInUser = null;

    protected final String menuName;
    protected Menu lastMenu;

    public Menu(String name) {
        this.menuName = name;
    }

    public abstract void run(); // All children should implement this method.

    protected abstract void showOptions();

    protected static Scanner getScanner() {
        return Menu.SCANNER;
    }

    public void setLastMenu(Menu lastMenu) {
        this.lastMenu = lastMenu;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public static void setLoggedInUser(User loggedInUser) {
        Menu.loggedInUser = loggedInUser;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public Menu getLastMenu() {
        return lastMenu;
    }

}

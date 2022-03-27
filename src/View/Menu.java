package View;

import Model.User;

import java.util.Scanner;

public abstract class Menu {
    protected String menuName;
    protected Menu lastMenu;
    private static Scanner scanner;
    private static User loggedUser;

    public Menu(String name) {
        this.menuName = name;
    }

    protected Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public void setLastMenu(Menu lastMenu) {
        this.lastMenu = lastMenu;
    }

    public String getMenuName() {
        return menuName;
    }

    public static void setLoggedUser(User loggedUser) {
        Menu.loggedUser = loggedUser;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Menu getLastMenu() {
        return lastMenu;
    }

    public static User getLoggedUser() {
        return loggedUser;
    }

}

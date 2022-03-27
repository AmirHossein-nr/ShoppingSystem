package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class User {
    private final static ArrayList<User> ALL_USERS = new ArrayList<>();
    private static int id = 0;

    private String username;
    private String password;
    private final int userId;
    private final String creationTime;

    public User(String username, String password) {
        id++;
        this.userId = id;
        this.username = username;
        this.password = password;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd | HH:mm:ss");
        this.creationTime = now.format(formatter);

        User.ALL_USERS.add(this);
    }

    public static User getUserByUsername(String username) {
        for (User user : User.ALL_USERS) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static int getId() {
        return User.id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getCreationTime() {
        return this.creationTime;
    }

}

package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class User {
    private static int id = 0;
    protected String username;
    protected String password;
    protected int userId;
    protected String creationTime;

    public User() {
        id++;
        this.userId = id;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd | HH:mm:ss");
        this.creationTime = now.format(formatter);
    }

    public static int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}

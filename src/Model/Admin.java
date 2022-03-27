package Model;

import java.util.UUID;

public class Admin extends User {

    private final String personalUnifiedId;
    private ACCESS accessLevel;

    public Admin(String username, String password, ACCESS accessLevel) {
        super();
        this.setUsername(username);
        this.setPassword(password);
        this.personalUnifiedId = UUID.randomUUID().toString();
        this.accessLevel = accessLevel;
    }

    public String getPersonalUnifiedId() {
        return personalUnifiedId;
    }

    public ACCESS getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(ACCESS accessLevel) {
        this.accessLevel = accessLevel;
    }
}

package models;

import java.util.UUID;

import enums.Role;

public class Admin extends User {

    private final String personalUnifiedId;
    private Role role;

    public Admin(String username, String password, Role role) {
        super(username, password);
        this.personalUnifiedId = UUID.randomUUID().toString();
        this.role = role;
    }

    public String getPersonalUnifiedId() {
        return personalUnifiedId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

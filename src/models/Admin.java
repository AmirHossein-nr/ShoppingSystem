package models;

import java.util.ArrayList;
import java.util.UUID;

import enums.ACCESS;

public class Admin extends User {

    private static final ArrayList<Admin> ALL_ADMINS = new ArrayList<>();
    private final String personalUnifiedId;
    private ACCESS accessLevel;

    public Admin(String username, String password, ACCESS accessLevel) {
        super(username, password);
        this.personalUnifiedId = UUID.randomUUID().toString();
        this.accessLevel = accessLevel;
        Admin.ALL_ADMINS.add(this);
    }

    public static ArrayList<Admin> getAllAdmins() {
        return Admin.ALL_ADMINS;
    }

    public static Admin getAdminByUsername(String username) {
        for (Admin admin : Admin.getAllAdmins()) {
            if (admin.getUsername().equals(username))
                return admin;
        }
        return null;
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

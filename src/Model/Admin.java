package Model;

import java.util.ArrayList;
import java.util.UUID;

public class Admin extends User {

    private static ArrayList<Admin> allAdmins;
    private final String personalUnifiedId;
    private ACCESS accessLevel;

    static {
        allAdmins = new ArrayList<>();
    }

    public Admin(String username, String password, ACCESS accessLevel) {
        super();
        this.setUsername(username);
        this.setPassword(password);
        this.personalUnifiedId = UUID.randomUUID().toString();
        this.accessLevel = accessLevel;
        allAdmins.add(this);
    }

    public static ArrayList<Admin> getAllAdmins() {
        return allAdmins;
    }

    public static Admin getAdminByUsername(String username) {
        for (Admin admin : Admin.getAllAdmins()) {
            if (admin.getUsername().equals(username)) return admin;
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

package enums;

public enum Messages {
    INVALID_CHOICE("Invalid Choice! Please Try Again ...");

    private String message;

    Messages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}

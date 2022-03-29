package enums;

public enum Message {
    INVALID_CHOICE("Invalid Choice! Please Try Again ..."),
    MISMATCH_PASSWORD("passwords doesn't match"),
    SHORT_PASSWORD("password is too short"),
    LONG_PASSWORD("password too long"),
    NON_ALPHANUMERIC_PASSWORD("password should contains alphaNumeric Characters"),
    USERNAME_EXIST("username has already exists"),
    WRONG_ROLE_LEVEL("wrong role level"),
    WRONG_CREDENTIALS("Wrong Credentials!"),
    SELLABLE_NOT_EXIST("Sellable does not exist"),
    NOT_ENOUGH_MONEY("you don't have enough money in your account"),
    PRODUCT_EXIST("Product has already exist"),
    SUCCESS("OK");

    private String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}

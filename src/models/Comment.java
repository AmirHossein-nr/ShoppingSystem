package models;

public class Comment {
    private String text;
    private User relatedUser;
    private Comment repliedTo;

    public Comment(String text, User relatedUser) {
        this.text = text;
        this.relatedUser = relatedUser;
        this.repliedTo = null;
    }

    public Comment(String text, User relatedUser, Comment repliedTo) {
        this.text = text;
        this.relatedUser = relatedUser;
        this.repliedTo = repliedTo;
    }

    public Comment getRepliedTo() {
        return repliedTo;
    }

    public String getText() {
        return text;
    }

    public User getRelatedUser() {
        return relatedUser;
    }
}

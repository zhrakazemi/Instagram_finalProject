package com.instagram_finalproject;

import java.util.ArrayList;

public class Notification {
    private final String text;
    private Post post;
    private Message message;
    private Account account;

    public Notification(String text, Post post) {
        this.text = text;
        this.post = post;
    }

    public Notification(String text, Message message) {
        this.text = text;
        this.message = message;
    }

    public Notification(String text, Account account) {
        this.text = text;
        this.account = account;
    }

    public String getText() {
        return text;
    }

    public Post getPost() {
        return post;
    }

    public Message getMessage() {
        return message;
    }

    public Account getAccount() {
        return account;
    }
}

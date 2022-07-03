package com.instagram_finalproject;

import java.util.ArrayList;

public class Message {
    private ArrayList<String> text = new ArrayList<>();
    private final Account person1;
    private final Account person2;

    public Message(Account person1, Account person2) {
        this.person1 = person1;
        this.person2 = person2;
    }

    public ArrayList<String> getText() {
        return text;
    }

    public void setText(ArrayList<String> text) {
        this.text = text;
    }

    public Account getPerson1() {
        return person1;
    }

    public Account getPerson2() {
        return person2;
    }
}

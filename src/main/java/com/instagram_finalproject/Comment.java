package com.instagram_finalproject;

public class Comment {

    private String com ;
    Comment x ;
    Account y ;

////////////////////////////////////// Set & Get  //////////////////////////////////////

    public String getCom() { return com; }

    public void setCom(String com) { this.com = com; }

    public Comment getX() { return x; }

    public void setX(Comment x) { this.x = x; }

    public Account getY() { return y; }

    public void setY(Account y) { this.y = y; }

//////////////////////////////////////////////////////////////////////////////////////////////

    public Comment(String com, Comment x, Account y) {
        this.com = com;
        this.x = x;
        this.y = y;
    }
}

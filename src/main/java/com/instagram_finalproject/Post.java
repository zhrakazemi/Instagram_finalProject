package com.instagram_finalproject;

import java.util.ArrayList;

public class Post
{
    private String text ;
    ArrayList<Account> likeAccount = new ArrayList<>() ;       //برای لایک ها
    ArrayList<Comment> CommentAccount = new ArrayList<>() ;   //برای کامنت ها

////////////////////////////////////// Set & Get  //////////////////////////////////////

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public ArrayList<Account> getLikeAccount() { return likeAccount; }

    public void setLikeAccount(ArrayList<Account> likeAccount) { this.likeAccount = likeAccount; }

    public ArrayList<Comment> getCommentAccount() { return CommentAccount; }

    public void setCommentAccount(ArrayList<Comment> commentAccount) { CommentAccount = commentAccount; }

/////////////////////////////////////////////////////////////////////////////////////////////

    public Post(String text, ArrayList likeAccount, ArrayList commentAccount) {
        this.text = text;
        this.likeAccount = likeAccount;
        CommentAccount = commentAccount;
    }

}


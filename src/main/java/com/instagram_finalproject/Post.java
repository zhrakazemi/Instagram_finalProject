package com.instagram_finalproject;

import java.util.ArrayList;

public class Post
{
    private String text ;
    private int like ;
    private int dislike ;
    ArrayList<Account> likeAccount = new ArrayList<>() ;       //برای لایک ها
    ArrayList<Account> disLikeAccount = new ArrayList<>() ;       //برای دیس لایک ها
    ArrayList<Comment> CommentAccount = new ArrayList<>() ;   //برای کامنت ها
    Account account;
    static ArrayList<Post> popularPost = new ArrayList<>() ;

////////////////////////////////////// Set & Get  //////////////////////////////////////

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public ArrayList<Account> getLikeAccount() { return likeAccount; }

    public void setLikeAccount(ArrayList<Account> likeAccount) { this.likeAccount = likeAccount; }

    public ArrayList<Comment> getCommentAccount() { return CommentAccount; }

    public void setCommentAccount(ArrayList<Comment> commentAccount) { CommentAccount = commentAccount; }

    public ArrayList<Account> getDisLikeAccount() {
        return disLikeAccount;
    }

    public void setDisLikeAccount(ArrayList<Account> disLikeAccount) {
        this.disLikeAccount = disLikeAccount;
    }

    public Account getAccount() {
        return account;
    }

    public int getLike() { return like; }

    public void setLike(int like) { this.like = like; }

    public int getDislike() { return dislike; }

    public void setDislike(int dislike) { this.dislike = dislike; }

    public void setAccount(Account account) {
        this.account = account;
    }

    public static ArrayList<Post> getPopularPost() { return popularPost; }

    public static void setPopularPost(ArrayList<Post> popularPost) { Post.popularPost = popularPost; }

///////////////////////////////////////////////////////////////////////////////////////////////

    public Post(String text,Account account) {
        this.text = text;
        this.account = account;
    }

}


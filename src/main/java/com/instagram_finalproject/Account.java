package com.instagram_finalproject;

import java.util.ArrayList;

public class Account
{
    private String username ;
    private String password ;
    private String name ;
    private String lastName ;
    private String email ;
    private String birthDate ;   //
    private String bio ;

    static ArrayList<Account> AllAccount = new ArrayList<>() ;


////////////////////////////////////// Set & Get  //////////////////////////////////////

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getBirthDate() { return birthDate; }

    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    public String getBio() { return bio; }

    public void setBio(String bio) { this.bio = bio; }

    public static ArrayList<Account> getAllAccount() { return AllAccount; }

    public static void setAllAccount(ArrayList<Account> allAccount) { AllAccount = allAccount; }

///////////////////////////////////////////////////////////////////////////////////////////////////

    public Account(String username, String password, String name, String lastName, String email, String birthDate, String bio) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.bio = bio;
    }
}

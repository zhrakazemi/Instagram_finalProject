package com.instagram_finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AccountManagementSettingController {
static ArrayList<Account> accounts = new ArrayList<>();
    @FXML
    private Button btnBack;

    @FXML
    private Button btnDeleteAccount;

    @FXML
    private Button btnFans;

    @FXML
    private Button btnFavoritePost;

    @FXML
    private Button btnHatedPosts;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnMyFollowers;

    @FXML
    private Button btnMyFollowing;
    @FXML
    private Button btnEditPosts;

    @FXML
    private Button btnMyIdol;

    @FXML
    void pressOnBtnDeleteAccount(ActionEvent event) {
        Account.AllAccount.remove(HelloApplication.loggedInAccount);
        HelloApplication.loggedInAccount=null;
        Stage stage = (Stage) btnFans.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("Register.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 400, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressOnBtnFavoritePsts(ActionEvent event) {

    }

    @FXML
    void pressOnBtnHatedPosts(ActionEvent event) {

    }

    @FXML
    void pressOnBtnLogOut(ActionEvent event) {
        HelloApplication.loggedInAccount = null;
        Stage stage = (Stage) btnLogOut.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        //TODO
        //AnchorPane root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("***.fxml"));
        //Scene scene = new Scene(root, 400, 700);
       // primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressOnBtnMyFans(ActionEvent event) {
        for(Account account :HelloApplication.loggedInAccount.getFollowers()){
            accounts.add(account);
        }
        for(Account a : accounts){
            for(Account b : HelloApplication.loggedInAccount.getFollowings()){
                if(a.getUsername().equals(b.getUsername())){
                    accounts.remove(a);
                }
            }
        }
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("ShowList.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 400, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressOnBtnMyFollowers(ActionEvent event) {
        for(Account account :HelloApplication.loggedInAccount.getFollowers()){
            accounts.add(account);
        }
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("ShowList.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 400, 700);
         primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressOnBtnMyFollowing(ActionEvent event) {
        for(Account account :HelloApplication.loggedInAccount.getFollowings()){
            accounts.add(account);
        }
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("ShowList.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 400, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressOnBtnMyIdol(ActionEvent event) {
        for(Account account :HelloApplication.loggedInAccount.getFollowings()){
            accounts.add(account);
        }
        for(Account a : accounts){
            for(Account b : HelloApplication.loggedInAccount.getFollowers()){
                if(a.getUsername().equals(b.getUsername())){
                    accounts.remove(a);
                }
            }
        }
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("ShowList.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 400, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressonBtnBack(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        TabPane root = null;
        try {
            root = (TabPane) FXMLLoader.load(HelloApplication.class.getResource("MainPage.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 400, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    void pressOnBtnEditPosts(ActionEvent event) {
        Stage stage = (Stage) btnFans.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("ViewPostsForEdit.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 400, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

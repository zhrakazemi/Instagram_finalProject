package com.instagram_finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        //AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("***.fxml"));
        //Scene scene = new Scene(root, 800, 500);
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
        Stage stage = (Stage) btnFans.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(getClass().getResource("ShowList.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressOnBtnMyFollowers(ActionEvent event) {
        for(Account account :HelloApplication.loggedInAccount.getFollowers()){
            accounts.add(account);
        }
        Stage stage = (Stage) btnMyFollowers.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(getClass().getResource("ShowList.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 800, 500);
         primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressOnBtnMyFollowing(ActionEvent event) {
        for(Account account :HelloApplication.loggedInAccount.getFollowings()){
            accounts.add(account);
        }
        Stage stage = (Stage) btnMyFollowing.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(getClass().getResource("ShowList.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 800, 500);
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
        Stage stage = (Stage) btnMyIdol.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(getClass().getResource("ShowList.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressonBtnBack(ActionEvent event) {

    }
    @FXML
    void pressOnBtnEditPosts(ActionEvent event) {

    }

}

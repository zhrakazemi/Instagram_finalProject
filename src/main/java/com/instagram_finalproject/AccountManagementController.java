package com.instagram_finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AccountManagementController {

    @FXML
    private Button btnAddPost;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnChangeInfo;

    @FXML
    private Button btnSetting;

    @FXML
    private Label lblBio;

    @FXML
    private Label lblName;

    @FXML
    private Label lblUserName;

    @FXML
    void pressOnBtnAddPost(ActionEvent event) {
        Stage stage = (Stage) btnAddPost.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(getClass().getResource("AddPost.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressOnBtnBack(ActionEvent event) {

    }

    @FXML
    void pressOnBtnChangeInfo(ActionEvent event) {
        Stage stage = (Stage) btnChangeInfo.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(getClass().getResource("ChangeInfo.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressOnBtnSetting(ActionEvent event) {
        Stage stage = (Stage) btnSetting.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(getClass().getResource("َAccountManagementSetting.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

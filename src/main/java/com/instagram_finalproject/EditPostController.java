package com.instagram_finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class EditPostController {
    static Post post;
    @FXML
    private Button btnBack;

    @FXML
    private Button btnDone;

    @FXML
    private TextField txtNewText;

    @FXML
    void pressOnBtnBack(ActionEvent event) {
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
    void pressOnBtnDone(ActionEvent event) {
        post.setText(txtNewText.getText());
        for (Account a:post.likeAccount)
            a.getNotifications().add(new Notification(post.account.getUsername()+" post has changed",post));
        for (Account a:post.disLikeAccount)
            a.getNotifications().add(new Notification(post.account.getUsername()+" post has changed",post));
        for (Comment a:post.CommentAccount)
            a.getY().getNotifications().add(new Notification(post.account.getUsername()+" post has changed",post));
    }

}

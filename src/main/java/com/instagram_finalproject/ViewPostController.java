package com.instagram_finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class ViewPostController {
    Post post = null;
    int likes = 0;
    int disLikes=0;
    @FXML
    private Button btnComment;

    @FXML
    private Button btnDislike;

    @FXML
    private Button btnLike;

    @FXML
    private Label lblLikes;

    @FXML
    private Label lblPostText;

    @FXML
    private Label lblUserName;

    @FXML
    private Label lblDisLikes;

    public String getLblDisLikes() {
        return ("Dislikes:"+ String.valueOf(disLikes));
    }

    public void setLblDisLikes(Label lblDisLikes) {
        this.lblDisLikes = lblDisLikes;
    }

    @FXML
    private ListView<?> lvComments;

    @FXML
    void pressOnBtnLike(ActionEvent event) {
        post.likeAccount.add(HelloApplication.loggedInAccount);
        likes++;
    }

    @FXML
    void pressOnbtnComment(ActionEvent event) {
        Stage stage = (Stage) btnComment.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("CommentPage.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public String getLblLikes() {
        return ("Likes:"+ String.valueOf(likes));
    }

    public void setLblLikes(Label lblLikes) {
        this.lblLikes = lblLikes;
    }

    public Label getLblPostText() {
        return lblPostText;
    }

    public void setLblPostText(Label lblPostText) {
        this.lblPostText = lblPostText;
    }

    public Label getLblUserName() {
        return lblUserName;
    }

    public void setLblUserName(Label lblUserName) {
        this.lblUserName = lblUserName;
    }

    @FXML
    void pressonbtnDislike(ActionEvent event) {
        disLikes++;
    }

}

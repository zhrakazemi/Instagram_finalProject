package com.instagram_finalproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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


public class ViewPostController {
    static Post post = null;

    public void initialize() {
        lblLikes.setText(String.valueOf(post.getLikeAccount().size()));
        lblDisLikes.setText(String.valueOf(post.getDisLikeAccount().size()));
        lblPostText.setText(post.getText());
        ObservableList<String> observableList = FXCollections.observableArrayList();
        for (Comment a : post.getCommentAccount())
            observableList.add(a.getCom());
        lvComments.setItems(observableList);
    }

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
    private Label lblDisLikes;

    @FXML
    private ListView<String> lvComments;

    @FXML
    void pressOnBtnLike(ActionEvent event) {
        if (post.likeAccount.contains(HelloApplication.loggedInAccount))
            post.likeAccount.remove(HelloApplication.loggedInAccount);
        else {
            post.likeAccount.add(HelloApplication.loggedInAccount);
            post.account.getNotifications().add(new Notification(HelloApplication.loggedInAccount.getUsername() + " liked your post"
                    , post));
        }
        initialize();
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
        Scene scene = new Scene(root, 400, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressonbtnDislike(ActionEvent event) {
        if (post.disLikeAccount.contains(HelloApplication.loggedInAccount))
            post.disLikeAccount.remove(HelloApplication.loggedInAccount);
        else {
            post.disLikeAccount.add(HelloApplication.loggedInAccount);
            post.account.getNotifications().add(new Notification(HelloApplication.loggedInAccount.getUsername() + " disliked your post"
                    , post));
        }
        initialize();
    }

}

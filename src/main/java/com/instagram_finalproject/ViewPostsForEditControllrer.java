package com.instagram_finalproject;

import com.sun.javafx.charts.Legend;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static com.instagram_finalproject.PostListController.posts;

public class ViewPostsForEditControllrer {

    @FXML
    private ListView<?> lvAlPosts;
    public void initialize() {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        int i = 1;
        for (Post a : HelloApplication.loggedInAccount.getPosts())
            observableList.add(i++ + ". " + a.getText());
        observableList.setAll(observableList);
    }

    void onPostsListviewClick(MouseEvent event) {
        Stage stage = (Stage) lvAlPosts.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("EditPost.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 400, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}




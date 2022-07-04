package com.instagram_finalproject;

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
import java.util.ArrayList;

public class PostListController {
    public static ArrayList<Post> posts;

    public void initialize() {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        int i = 1;
        for (Post a : posts)
            observableList.add(i++ + ". " + a.getText());
        postsListview.setItems(observableList);
    }

    @FXML
    private ListView<String> postsListview;

    @FXML
    void onPostsListviewClick(MouseEvent event) {
        ViewPostController.post=posts.get(postsListview.getSelectionModel().getSelectedIndex());
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("ViewPost.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 400, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

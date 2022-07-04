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

import static com.instagram_finalproject.ViewPostController.post;

public class ViewSavedPostController {

    @FXML
    private ListView<String> lvSavedPosts;

    @FXML
    void pressOnSavedPost(MouseEvent event) {
        ViewPostController.post=HelloApplication.loggedInAccount.getPosts().get(lvSavedPosts.getSelectionModel().getSelectedIndex());
        Stage stage = (Stage) lvSavedPosts.getScene().getWindow();
        stage.close();
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
    public void initialize() {

        ObservableList<String> observableList = FXCollections.observableArrayList();
        for (Post a : HelloApplication.loggedInAccount.SavedPosts)
            observableList.add(a.getText());
        lvSavedPosts.setItems(observableList);
    }

}

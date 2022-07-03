package com.instagram_finalproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

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

    }

}

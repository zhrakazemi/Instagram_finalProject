package com.instagram_finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddPostController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDone;

    @FXML
    private TextField txtPostText;

    @FXML
    void pressOnBtnBack(ActionEvent event) {

    }

    @FXML
    void pressOnBtnDone(ActionEvent event) {
        Post post = new Post(txtPostText.getText(), HelloApplication.loggedInAccount);
        HelloApplication.loggedInAccount.getPosts().add(post);
        if (!HelloApplication.loggedInAccount.isPrivateAccount()) {
            HelloApplication.allPosts.add(post);
        }
    }

}

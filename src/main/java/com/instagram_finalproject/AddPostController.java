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
        Post post = new Post(txtPostText.getText());
    @FXML
    void pressOnBtnBack(ActionEvent event) {

    }

    @FXML
    void pressOnBtnDone(ActionEvent event) {
        HelloApplication.loggedInAccount.setPosts(post);
        if(!HelloApplication.loggedInAccount.isPrivateAccount()){
        HelloApplication.allPosts.add(post);}
    }

}

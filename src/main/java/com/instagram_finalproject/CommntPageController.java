package com.instagram_finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CommntPageController {
Post post = null;
    @FXML
    private Button btnDone;

    @FXML
    private TextField txtComment;
        Comment comment = new Comment(txtComment.getText() , null , HelloApplication.loggedInAccount);
    @FXML
    void pressOnBtnDone(ActionEvent event) {
        post.CommentAccount.add(comment);
    }

}

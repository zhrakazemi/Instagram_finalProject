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
    @FXML
    void pressOnBtnDone(ActionEvent event) {
        Comment comment = new Comment(txtComment.getText() , null , HelloApplication.loggedInAccount);
        post.CommentAccount.add(comment);
        post.account.getNotifications().add(new Notification(HelloApplication.loggedInAccount.getUsername() + " write a comment for your post"
                , post));
    }

}

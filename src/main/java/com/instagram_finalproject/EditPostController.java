package com.instagram_finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditPostController {
    static Post post;
    @FXML
    private Button btnBack;

    @FXML
    private Button btnDone;

    @FXML
    private TextField txtNewText;

    @FXML
    void pressOnBtnBack(ActionEvent event) {

    }

    @FXML
    void pressOnBtnDone(ActionEvent event) {
        post.setText(txtNewText.getText());
    }

}

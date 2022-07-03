package com.instagram_finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class SignUp {

    @FXML
    private Button btn_save;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Label lbl4;

    @FXML
    private Label lbl5;

    @FXML
    private Label lbl6;

    @FXML
    private Label lbl7;

    @FXML
    private Label lbl8;

    @FXML
    private Rectangle rec;

    @FXML
    private TextField txt_bio;

    @FXML
    private TextField txt_birthdate;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_lastname;

    @FXML
    private TextField txt_name;

    @FXML
    private PasswordField txt_pass;

    @FXML
    private TextField txt_username;

    @FXML
    void clickSave(MouseEvent event)
    {
        Account acc = new Account(txt_username.getText(),txt_pass.getText(),txt_name.getText(),txt_lastname.getText(),txt_email.getText(),txt_birthdate.getText(),txt_bio.getText()) ;
        Account.AllAccount.add(acc) ;

        // رفتن به صفحه اکانت

    }

}

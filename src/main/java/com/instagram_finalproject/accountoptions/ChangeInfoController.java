package com.instagram_finalproject.accountoptions;

import com.instagram_finalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChangeInfoController {
    public void initialize() {
        nameField.setText(HelloApplication.loggedInAccount.getName());
        lastnameField.setText(HelloApplication.loggedInAccount.getLastName());
        passwordField.setText(HelloApplication.loggedInAccount.getPassword());
        emailField.setText(HelloApplication.loggedInAccount.getEmail());
        bioField.setText(HelloApplication.loggedInAccount.getBio());
        birthDateField.setText(HelloApplication.loggedInAccount.getBirthDate());
    }

    @FXML
    private TextArea bioField;

    @FXML
    private TextField birthDateField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField lastnameField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button submitBtn;

    @FXML
    void onSubmitBtnClick(ActionEvent event) {
        HelloApplication.loggedInAccount.setName(nameField.getText());
        HelloApplication.loggedInAccount.setLastName(lastnameField.getText());
        HelloApplication.loggedInAccount.setBio(bioField.getText());
        HelloApplication.loggedInAccount.setBirthDate(birthDateField.getText());
        HelloApplication.loggedInAccount.setPassword(passwordField.getText());
        HelloApplication.loggedInAccount.setEmail(emailField.getText());
    }

}

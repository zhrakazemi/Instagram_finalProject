package com.instagram_finalproject;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Register {

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_signUp;

    Label lbl3 = new Label("- Which information do you want to change ?");
    @FXML
    private Label lbl1;


    @FXML
    private ImageView picInsta;

    @FXML
    private Rectangle rectangle;

    @FXML
    private TextField txt_AccountName;

    @FXML
    private PasswordField txt_Password;

    @FXML
    void clickLogin(MouseEvent event) throws IOException, SQLException {


        for (int i = 0; i < Account.AllAccount.size(); i++) {
            if ((Account.AllAccount.get(i).getUsername().equals(txt_AccountName.getText())) && (Account.AllAccount.get(i).getPassword().equals(txt_Password.getText()))) {
                HelloApplication.loggedInAccount = Account.AllAccount.get(i);
                Parent parent = FXMLLoader.load(HelloApplication.class.getResource("MainPage.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(parent);
                stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
                stage.setTitle("Instagram");
                stage.setScene(scene);
                stage.show();
            }
        }

        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("IncorrectPass.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Instagram");
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void clickSignUp(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("SignUp.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Instagram");
        stage.setScene(scene);
        stage.show();

    }

}

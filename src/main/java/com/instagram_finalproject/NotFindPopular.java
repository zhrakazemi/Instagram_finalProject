package com.instagram_finalproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class NotFindPopular {

    @FXML
    private Button btn_home;

    @FXML
    private Line l1;

    @FXML
    private Line l2;

    @FXML
    private Label lbl1;

    @FXML
    private Rectangle rec;

    @FXML
    void clickHome(MouseEvent event) throws IOException {
        //بره به صفحه اکانت
        Parent parent = FXMLLoader.load(getClass().getResource("AccountInfoBySearchFollowing.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Instagram");
        stage.setScene(scene);
        stage.show();
    }

}

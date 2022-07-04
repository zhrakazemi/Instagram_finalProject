package com.instagram_finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class NotFind {

    @FXML
    private Button btn_OK;

    @FXML
    private Line l1;

    @FXML
    private Line l2;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Rectangle rec;

    @FXML
    void clickOK(MouseEvent event)
    {
        //برمیگرده به صفحه کاربر
        Stage stage = (Stage) btn_OK.getScene().getWindow();
        stage.close();
    }

}

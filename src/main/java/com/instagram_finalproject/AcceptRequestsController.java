package com.instagram_finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AcceptRequestsController {
    static Notification notification;
    @FXML
    private Button acceptBtn;

    @FXML
    private Button rejectBtn;

    @FXML
    void onAcceptBtnClick(ActionEvent event) {
        HelloApplication.loggedInAccount.getFollowers().add(notification.getAccount());
        notification.getAccount().getFollowings().add(HelloApplication.loggedInAccount);
        HelloApplication.loggedInAccount.getNotifications().remove(notification);
        Stage stage = (Stage) acceptBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onRejectBtnClick(ActionEvent event) {
        HelloApplication.loggedInAccount.getNotifications().remove(notification);
        Stage stage = (Stage) rejectBtn.getScene().getWindow();
        stage.close();
    }

}

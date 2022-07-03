package com.instagram_finalproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class NotificationPanelController {
    public void initialize() {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        int i = 1;
        for (Notification a : HelloApplication.loggedInAccount.getNotifications())
            observableList.add(i++ + ". " + a.getText());
        notificationListView.setItems(observableList);
    }

    @FXML
    private ListView<String> notificationListView;

    @FXML
    void onNotificationListViewClick(MouseEvent event) {
        if (HelloApplication.loggedInAccount.getNotifications().get(notificationListView.getSelectionModel().getSelectedIndex()).getAccount() != null) {
            AcceptRequestsController.notification = HelloApplication.loggedInAccount.getNotifications().get(notificationListView.getSelectionModel().getSelectedIndex());
            Stage stage = (Stage) notificationListView.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            AnchorPane root = null;
            try {
                root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("AcceptRequests.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Scene scene = new Scene(root, 400, 700);
            primaryStage.setScene(scene);
            primaryStage.show();
        } else if (HelloApplication.loggedInAccount.getNotifications().get(notificationListView.getSelectionModel().getSelectedIndex()).getPost() != null) {
            ViewPostController.post = HelloApplication.loggedInAccount.getNotifications().get(notificationListView.getSelectionModel().getSelectedIndex()).getPost();
            Stage stage = (Stage) notificationListView.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            AnchorPane root = null;
            try {
                root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("ViewPost.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Scene scene = new Scene(root, 400, 700);
            primaryStage.setScene(scene);
            primaryStage.show();
        } else {
            ChatPanelController.message = HelloApplication.loggedInAccount.getNotifications().get(notificationListView.getSelectionModel().getSelectedIndex()).getMessage();
            Stage stage = (Stage) notificationListView.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            AnchorPane root = null;
            try {
                root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("ChatPanel.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Scene scene = new Scene(root, 400, 700);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }

}

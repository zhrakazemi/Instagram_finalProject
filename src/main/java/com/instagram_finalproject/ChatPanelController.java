package com.instagram_finalproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatPanelController {
    ObservableList<String> observableList = FXCollections.observableArrayList();
    public static Message message;

    public void initialize() {
        observableList.addAll(message.getText());
        massagesListview.setItems(observableList);
    }

    @FXML
    private Button backBtn;

    @FXML
    private ListView<String> massagesListview;

    @FXML
    private TextField messageTxt;

    @FXML
    private Button sendBtn;

    @FXML
    void onBackBtnClick(ActionEvent event) {
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("MessagePanel.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 400, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void onSendBtnClick(ActionEvent event) {
        if (message.getText().size() == 10)
            message.getText().remove(0);
        message.getText().add(HelloApplication.loggedInAccount.getName() + " : " + messageTxt.getText());
        if (message.getPerson1().getUsername().equals(HelloApplication.loggedInAccount.getUsername()))
            message.getPerson2().getNotifications().add(new Notification("You have a new message from " +
                    HelloApplication.loggedInAccount.getUsername(), message));
        else
            message.getPerson1().getNotifications().add(new Notification("You have a new message from " +
                    HelloApplication.loggedInAccount.getUsername(), message));
        observableList.add(HelloApplication.loggedInAccount.getName() + " : " + messageTxt.getText());
        massagesListview.setItems(observableList);
    }

}

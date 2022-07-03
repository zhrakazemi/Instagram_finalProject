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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MessagePanelController {
    public void initialize() {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        for (Message a : HelloApplication.loggedInAccount.getMessages()) {
            if (a.getPerson1() == HelloApplication.loggedInAccount)
                observableList.add(a.getPerson2().getUsername());
            else
                observableList.add(a.getPerson1().getUsername());
        }
        usersListView.setItems(observableList);
    }

    @FXML
    private Button addBtn;

    @FXML
    private TextField addNewUserTxt;

    @FXML
    private ListView<String> usersListView;

    @FXML
    void onAddBtnClick(ActionEvent event) {
        for (Account a : Account.getAllAccount())
            if (a.getUsername().equals(addNewUserTxt.getText())) {
                Message temp = new Message(HelloApplication.loggedInAccount, a);
                HelloApplication.loggedInAccount.getMessages().add(temp);
                a.getMessages().add(temp);
                ChatPanelController.message = temp;
                Stage stage = (Stage) addBtn.getScene().getWindow();
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
                break;
            }
    }

    @FXML
    void onUserListViewClick(MouseEvent event) {
        ChatPanelController.message = HelloApplication.loggedInAccount.getMessages().get(usersListView.getSelectionModel().getSelectedIndex());
        Stage stage = (Stage) addBtn.getScene().getWindow();
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

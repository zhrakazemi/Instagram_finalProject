package com.instagram_finalproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;

import static com.instagram_finalproject.AccountManagementSettingController.accounts;

public class ShowListController {

    @FXML
    private Label lblListTitel;

    @FXML
    private ListView<String> lvList;

    public void initialize() {

        ObservableList<String> observableList = FXCollections.observableArrayList();
        for(Account account : accounts){
            observableList.add(account.getUsername());
            lvList.setItems(observableList);
        }

    }
}

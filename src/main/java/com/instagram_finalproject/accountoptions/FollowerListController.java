package com.instagram_finalproject.accountoptions;

import com.instagram_finalproject.Account;
import com.instagram_finalproject.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class FollowerListController {
    public void initialize() {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        int i = 1;
        for (Account a : HelloApplication.loggedInAccount.getFollowers())
            observableList.add(i++ + ". " + a.getUsername());
        followersListView.setItems(observableList);
    }

    @FXML
    private ListView<String> followersListView;

    @FXML
    void onFollowersListViewClick(MouseEvent event) {
        HelloApplication.loggedInAccount.getFollowers().remove(followersListView.getSelectionModel().getSelectedIndex());
        initialize();
    }

}

package com.instagram_finalproject.accountoptions;

import com.instagram_finalproject.Account;
import com.instagram_finalproject.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class FollowingListController {
    public void initialize() {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        int i = 1;
        for (Account a : HelloApplication.loggedInAccount.getFollowings())
            observableList.add(i++ + ". " + a.getUsername());
        followingListView.setItems(observableList);
    }

    @FXML
    private ListView<String> followingListView;

    @FXML
    void onFollowingListViewClick(MouseEvent event) {
        HelloApplication.loggedInAccount.getFollowings().remove(followingListView.getSelectionModel().getSelectedIndex());
        initialize();
    }

}

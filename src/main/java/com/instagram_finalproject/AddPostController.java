package com.instagram_finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AddPostController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDone;

    @FXML
    private TextField txtPostText;

    @FXML
    void pressOnBtnBack(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        TabPane root = null;
        try {
            root = (TabPane) FXMLLoader.load(HelloApplication.class.getResource("MainPage.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 400, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressOnBtnDone(ActionEvent event) {

        Post post = new Post(txtPostText.getText(), HelloApplication.loggedInAccount);
        HelloApplication.loggedInAccount.getPosts().add(post);
        if (!HelloApplication.loggedInAccount.isPrivateAccount()) {
            HelloApplication.allPosts.add(post);

            String SQLCom = String.format("INSERT  INTO allposts (username, private, text, like, dislike) values ('%s', %s, '%s',%s, %s)",HelloApplication.loggedInAccount.getUsername(),0,txtPostText.getText(),0,0);
            MySQLConnection sql = new MySQLConnection() ;
            Boolean res  =  sql.ExecuteSQL(SQLCom) ;
        }
    }

}

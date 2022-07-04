package com.instagram_finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddPostController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDone;

    @FXML
    private TextField txtPostText;

    @FXML
    void pressOnBtnBack(ActionEvent event) {

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

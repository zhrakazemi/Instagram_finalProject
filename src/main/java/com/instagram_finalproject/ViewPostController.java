package com.instagram_finalproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ViewPostController {
    static Post post = null;

    public void initialize() {
        lblLikes.setText(String.valueOf(post.getLikeAccount().size()));
        lblDisLikes.setText(String.valueOf(post.getDisLikeAccount().size()));
        lblPostText.setText(post.getText());
        ObservableList<String> observableList = FXCollections.observableArrayList();
        for (Comment a : post.getCommentAccount())
            observableList.add(a.getCom());
        lvComments.setItems(observableList);
    }

    @FXML
    private Button btnComment;

    @FXML
    private Button btnDislike;

    @FXML
    private Button btnLike;

    @FXML
    private Label lblLikes;

    @FXML
    private Label lblPostText;

    @FXML
    private Label lblDisLikes;

    @FXML
    private ListView<String> lvComments;
    @FXML
    private Button btnSave;

    @FXML
    void pressOnBtnLike(ActionEvent event) throws SQLException {

        //تعداد لایک این پست
        int l = GetMaxLike(post.getText(),HelloApplication.loggedInAccount.getUsername()) ;

        if (post.likeAccount.contains(HelloApplication.loggedInAccount)) {

            post.likeAccount.remove(HelloApplication.loggedInAccount);
            String s = String.format("UPDATE `allposts` SET `like`=%s WHERE `username`='%s' and `text`='%s'",l-1,HelloApplication.loggedInAccount.getUsername(),post.getText()) ;
            MySQLConnection sql = new MySQLConnection();
            Boolean res = sql.ExecuteSQL(s);

        }

        else {
            post.likeAccount.add(HelloApplication.loggedInAccount);
            post.account.getNotifications().add(new Notification(HelloApplication.loggedInAccount.getUsername() + " liked your post"
                    , post));

            String s = String.format("UPDATE `allposts` SET `like`=%s WHERE `username`='%s' and `text`='%s'",l+1,HelloApplication.loggedInAccount.getUsername(),post.getText()) ;
            MySQLConnection sql = new MySQLConnection();
            Boolean res = sql.ExecuteSQL(s);

        }
        initialize();
    }

    @FXML
    void pressOnbtnComment(ActionEvent event) {
        Stage stage = (Stage) btnComment.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("CommentPage.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 400, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    void pressOnBtnSave(ActionEvent event) {
        HelloApplication.loggedInAccount.SavedPosts.add(post);
    }

    @FXML
    void pressonbtnDislike(ActionEvent event) throws SQLException {

        //تعداد  دیس لایک این پست
        int dl = GetMaxDisLike(post.getText(),HelloApplication.loggedInAccount.getUsername()) ;


        if (post.disLikeAccount.contains(HelloApplication.loggedInAccount)) {
            post.disLikeAccount.remove(HelloApplication.loggedInAccount);

            String s = String.format("UPDATE `allposts` SET `dislike`=%s WHERE `username`='%s' and `text`='%s'",dl-1,HelloApplication.loggedInAccount.getUsername(),post.getText()) ;
            MySQLConnection sql = new MySQLConnection();
            Boolean res = sql.ExecuteSQL(s);
        }
        else {
            post.disLikeAccount.add(HelloApplication.loggedInAccount);
            post.account.getNotifications().add(new Notification(HelloApplication.loggedInAccount.getUsername() + " disliked your post"
                    , post));

            String s = String.format("UPDATE `allposts` SET `dislike`=%s WHERE `username`='%s' and `text`='%s'",dl+1,HelloApplication.loggedInAccount.getUsername(),post.getText()) ;
            MySQLConnection sql = new MySQLConnection();
            Boolean res = sql.ExecuteSQL(s);
        }
        initialize();
    }

    int GetMaxLike (String text,String accName) throws SQLException {
        String SQLCom = String.format("Select `like` FROM `allposts` WHERE `username`='%s' and `text`='%s'",accName,text);
        MySQLConnection sql = new MySQLConnection() ;
        ResultSet res =  sql.ExecuteQuery(SQLCom) ;
        if (res.next())
        {
            return res.getInt(1);
        }
        else
            return 0;

    }

    int GetMaxDisLike (String text,String accName) throws SQLException {
        String SQLCom = String.format("Select `dislike` FROM `allposts` WHERE `username`='%s' and `text`='%s'",accName,text);
        MySQLConnection sql = new MySQLConnection() ;
        ResultSet res =  sql.ExecuteQuery(SQLCom) ;
        if (res.next())
        {
            return res.getInt(1);
        }
        else
            return 0;

    }


}

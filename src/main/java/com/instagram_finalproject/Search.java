package com.instagram_finalproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Search {

    @FXML
    private Button btn_celeb;

    @FXML
    private Button btn_search;

    @FXML
    private Label lblAcc;

    @FXML
    private Label lbl_search;

    @FXML
    private Line line1;

    @FXML
    private Line line2;

    @FXML
    private Rectangle rec;

    @FXML
    private TextField txt_accountname;

    @FXML
    void clickSearch(MouseEvent event) throws IOException {

        for (int i=0 ; i<Account.AllAccount.size() ; i++){

            if (Account.AllAccount.get(i).getUsername().equals(txt_accountname.getText())){
                //این اکانت جزو فالویینگ هاش هست یا نه
                //پس فرقی نداره پرایوت بودن یا نبودن
                for (int j =0 ; j<HelloApplication.loggedInAccount.getFollowings().size() ; j++) {
                    if (HelloApplication.loggedInAccount.getFollowings().get(i).equals(Account.AllAccount.get(i))){
                        AccountInfoPrivate acc = new AccountInfoPrivate(Account.AllAccount.get(i)) ;
                        Parent parent = FXMLLoader.load(getClass().getResource("AccountInfoBySearchFollowing.fxml"));
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
                        Scene scene = new Scene(parent);
                        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
                        stage.setTitle("Instagram");
                        stage.setScene(scene);
                        stage.show();
                    }

                }

                //جز فالویینگا نبود
                //چک کردن پرایوت هست یا نه

                if (Account.AllAccount.get(i).isPrivateAccount()) {

                    // صفحه پابلیک هست و جز فالویینگ های اکانت نیست
                    AccountInfoPrivate acc = new AccountInfoPrivate(Account.AllAccount.get(i)) ;
                    Parent parent = FXMLLoader.load(getClass().getResource("AccountInformationBySearch.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
                    Scene scene = new Scene(parent);
                    stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
                    stage.setTitle("Instagram");
                    stage.setScene(scene);
                    stage.show();

                }
                else {
                    // صفحه پرایوت هست و جز فالویینگ های اکانت نیست
                    AccountInfoPrivate acc = new AccountInfoPrivate(Account.AllAccount.get(i)) ;
                    Parent parent = FXMLLoader.load(getClass().getResource("AccountInfoPrivate.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
                    Scene scene = new Scene(parent);
                    stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
                    stage.setTitle("Instagram");
                    stage.setScene(scene);
                    stage.show();
                }

            }

        }

        //وقتی اکانت پیدا نشد
        Parent parent = FXMLLoader.load(getClass().getResource("NotFind.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Instagram");
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void clickceleb(MouseEvent event) throws IOException {
        //boolean foundCeleb = false ;
        for (int i=0 ; i<Account.AllAccount.size() ; i++)
        {
             if (Account.AllAccount.get(i).isPrivateAccount()){

                 for (int j=0 ; j<Account.AllAccount.get(i).getPosts().size() ; j++){

                     if (Account.AllAccount.get(i).getPosts().get(j).getLike()>2){
                         Post.getPopularPost().add(Account.AllAccount.get(i).getPosts().get(j));

                     }
                 }
             }
        }

        if (Post.getPopularPost().size()!=0){
            // بره که پست های آدم معروفا نشونش بده
            // Post.getPopularPost()
        }
        else {
            Parent parent = FXMLLoader.load(getClass().getResource("NotFindPopular.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Instagram");
            stage.setScene(scene);
            stage.show();
        }

    }

}
//

package com.instagram_finalproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {
    public void initialize() {
        lblBio.setText(HelloApplication.loggedInAccount.getBio());
        lblName.setText(HelloApplication.loggedInAccount.getName());
        lblUserName.setText(HelloApplication.loggedInAccount.getUsername());
        ObservableList<String> observableList = FXCollections.observableArrayList();
        int i = 1;
        for (Notification a : HelloApplication.loggedInAccount.getNotifications())
            observableList.add(i++ + ". " + a.getText());
        notificationListView.setItems(observableList);
    }

    @FXML
    private Button btnAddPost;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnChangeInfo;

    @FXML
    private Button btnSetting;

    @FXML
    private Label lblBio;

    @FXML
    private Label lblName;

    @FXML
    private Label lblUserName;

    @FXML
    void pressOnBtnAddPost(ActionEvent event) {
        Stage stage = (Stage) btnAddPost.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("AddPost.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 400, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressOnBtnBack(ActionEvent event) {
        HelloApplication.loggedInAccount = null;
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("Register.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 400, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressOnBtnChangeInfo(ActionEvent event) {
        Stage primaryStage = new Stage();
        VBox root = null;
        try {
            root = (VBox) FXMLLoader.load(HelloApplication.class.getResource("ChangeInfo.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 400, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressOnBtnSetting(ActionEvent event) {
        Stage stage = (Stage) btnSetting.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("AccountManagementSetting.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 400, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


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

        for (int i = 0; i < Account.AllAccount.size(); i++) {

            if (Account.AllAccount.get(i).getUsername().equals(txt_accountname.getText())) {
                //این اکانت جزو فالویینگ هاش هست یا نه
                //پس فرقی نداره پرایوت بودن یا نبودن
                for (int j = 0; j < HelloApplication.loggedInAccount.getFollowings().size(); j++) {
                    if (HelloApplication.loggedInAccount.getFollowings().get(i).equals(Account.AllAccount.get(i))) {
                        AccountInfoBySearchFollowing.acc = Account.AllAccount.get(i);
                        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("AccountInfoBySearchFollowing.fxml"));
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
                    AccountInformationBySearch.acc = Account.AllAccount.get(i);
                    Parent parent = FXMLLoader.load(HelloApplication.class.getResource("AccountInformationBySearch.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(parent);
                    stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
                    stage.setTitle("Instagram");
                    stage.setScene(scene);
                    stage.show();

                } else {
                    // صفحه پرایوت هست و جز فالویینگ های اکانت نیست
                    AccountInfoPrivate.acc = Account.AllAccount.get(i);
                    Parent parent = FXMLLoader.load(HelloApplication.class.getResource("AccountInfoPrivate.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(parent);
                    stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
                    stage.setTitle("Instagram");
                    stage.setScene(scene);
                    stage.show();
                }

            }

        }

        //وقتی اکانت پیدا نشد
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("NotFind.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        primaryStage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        primaryStage.setTitle("Instagram");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    @FXML
    void clickceleb(MouseEvent event) throws IOException {
        //boolean foundCeleb = false ;
        Post.getPopularPost().removeAll(Post.getPopularPost());
        for (int i = 0; i < Account.AllAccount.size(); i++) {
            if (Account.AllAccount.get(i).isPrivateAccount()) {

                for (int j = 0; j < Account.AllAccount.get(i).getPosts().size(); j++) {

                    if (Account.AllAccount.get(i).getPosts().get(j).likeAccount.size() >= 2) {
                        Post.getPopularPost().add(Account.AllAccount.get(i).getPosts().get(j));
                    }
                }
            }
        }

        if (Post.getPopularPost().size() != 0) {
            PostListController.posts = Post.getPopularPost();
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("PostList.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Instagram");
            stage.setScene(scene);
            stage.show();
        } else {
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("NotFindPopular.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Instagram");
            stage.setScene(scene);
            stage.show();
        }

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

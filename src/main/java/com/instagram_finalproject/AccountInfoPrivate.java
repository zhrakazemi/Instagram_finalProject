 /*
public class AccountInfoPrivate {



    @FXML private TableView <Account> tableView ;
    @FXML private TableColumn<Account,int> posts ;
    @FXML private TableColumn<Account,int> followers ;
    @FXML private TableColumn<Account,int> following ;
    @FXML private TableColumn<Account,String> bio ;

    @FXML private TextField postsText ;
    @FXML private TextField followersText ;
    @FXML private TextField followingText ;
    @FXML private TextField bioText ;


    @FXML
    private Button btn_Home;

    @FXML
    private Label lbl1;

    @FXML
    void clickHome(MouseEvent event) {

    }

} */

package com.instagram_finalproject;

        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.*;
        import javafx.scene.input.MouseEvent;
        import javafx.stage.Stage;

        import java.io.IOException;

//پیج پرایوت هست و جز فالویینگا نیست
 public class AccountInfoPrivate {

    static Account acc ;

    @FXML
    private TableColumn<?, ?> bio;

    @FXML
    private Button btn_Follow;

    @FXML
    private Button btn_Home;

    @FXML
    private TableColumn<?, ?> followers;

    @FXML
    private TableColumn<?, ?> following;

    @FXML
    private Label lbl1;

    @FXML
    private TableColumn<?, ?> posts;

    @FXML
    private TableView<?> tableView;

    @FXML
    void clickHome(MouseEvent event) throws IOException {
        //بره به صفحه اصلی اون اکانت
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("MainPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Instagram");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void clickFollow(MouseEvent event) throws IOException {
        acc.getNotifications().add(new Notification(HelloApplication.loggedInAccount.getUsername()+" wants to follow you",HelloApplication.loggedInAccount));
        Alert alert6 = new Alert(Alert.AlertType.INFORMATION);
        alert6.setTitle("Instagram");
        alert6.setContentText("request submitted wait for answer");
        alert6.showAndWait();

    }

    public void initialize()
    {
        lbl1.setText(acc.getUsername());
        following.setText(String.valueOf(acc.getFollowings().size()));
        followers.setText(String.valueOf(acc.getFollowers().size()));
        bio.setText(acc.getBio());
        posts.setText(String.valueOf(acc.getPosts().size()));

    }

}

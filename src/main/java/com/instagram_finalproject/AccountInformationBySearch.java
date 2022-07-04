package com.instagram_finalproject;

        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.*;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.AnchorPane;
        import javafx.scene.shape.Line;
        import javafx.scene.shape.Rectangle;
        import javafx.stage.Stage;

        import java.io.IOException;

//موقع سرچ ، وقتی اون پیج جز فالویینگای اکانت نیست و پیجش پابلیکه

public class AccountInformationBySearch {

    static Account acc ;

    @FXML
    private TableColumn<?, ?> Bio;

    @FXML
    private TableColumn<?, ?> Followers;

    @FXML
    private TableColumn<?, ?> Following;

    @FXML
    private TableColumn<?, ?> Posts;

    @FXML
    private Button btn_Follow;

    @FXML
    private Button btn_Posts;

    @FXML
    private Button btn_home;

    @FXML
    private Line l1;

    @FXML
    private Line l2;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Rectangle rec;

    @FXML
    private TableView<?> tableshow;

    @FXML
    void clickFollow(MouseEvent event) throws IOException
    {
        // درخواست فالو

         //
        acc.getFollowers().add(HelloApplication.loggedInAccount);
        HelloApplication.loggedInAccount.getFollowings().add(acc);
        Alert alert6 = new Alert(Alert.AlertType.INFORMATION);
        alert6.setTitle("Instagram");
        alert6.setContentText("submitted");
        alert6.showAndWait();

    }

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
    void clickPosts(MouseEvent event) throws IOException {
        PostListController.posts = acc.getPosts();
        Stage primaryStage = new Stage();
        AnchorPane root = null;
        try {
            root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("PostList.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root, 400, 700);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void initialize()
    {
        lbl1.setText(acc.getUsername());
        Following.setText(String.valueOf(acc.getFollowings().size()));
        Followers.setText(String.valueOf(acc.getFollowers().size()));
        Bio.setText(acc.getBio());
        Posts.setText(String.valueOf(acc.getPosts().size()));

    }

}

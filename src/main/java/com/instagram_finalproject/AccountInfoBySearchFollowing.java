package com.instagram_finalproject;

        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.TableColumn;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.shape.Line;
        import javafx.scene.shape.Rectangle;
        import javafx.stage.Stage;

        import java.io.IOException;


//موقع سرچ ، جز فالویینگای اکانت هست

public class AccountInfoBySearchFollowing {

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
    private Button btn_Home;

    @FXML
    private Button btn_Posts;

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
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("PostList.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Instagram");
        stage.setScene(scene);
        stage.show();
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

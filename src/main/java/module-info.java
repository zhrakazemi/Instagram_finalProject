module com.instagram_finalproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.instagram_finalproject to javafx.fxml;
    exports com.instagram_finalproject;
}
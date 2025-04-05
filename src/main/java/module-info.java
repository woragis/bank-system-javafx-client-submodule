module com.woragis {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens com.woragis to javafx.fxml;
    exports com.woragis;
}
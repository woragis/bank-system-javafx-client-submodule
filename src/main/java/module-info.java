module com.woragis {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.woragis to javafx.fxml;

    exports com.woragis;

    opens com.woragis.gui to javafx.fxml;

    exports com.woragis.gui;

    opens com.woragis.models to javafx.base; // optional if using ObservableLists etc.
}

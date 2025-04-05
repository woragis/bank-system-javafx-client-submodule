package com.woragis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    private static Stage stage;

    @Override
    public void start(@SuppressWarnings("exports") Stage s) throws IOException {
        // stage=s;
        // setRoot("primary","");
        Stage stage = new Stage();

        Text bankTitle = new Text("Woragis Bank");
        bankTitle.setX(80);
        bankTitle.setY(80);
        bankTitle.setFont(Font.font("Verdana", 50));
        bankTitle.setFill(Color.WHITE);

        Group root = new Group();
        root.getChildren().add(bankTitle);
        Scene scene = new Scene(root, Color.BLACK);

        stage.setTitle("Woragis Bank");
        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(800);
        stage.setResizable(false);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("Press this Q");
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        setRoot(fxml, stage.getTitle());
    }

    static void setRoot(String fxml, String title) throws IOException {
        Scene scene = new Scene(loadFXML(fxml));
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

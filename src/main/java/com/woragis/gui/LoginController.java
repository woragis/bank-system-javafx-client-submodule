package com.woragis.gui;

import com.woragis.models.User;
import com.woragis.repositories.UserRepository;
import com.woragis.services.AuthService;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorLabel;

    private final UserRepository userRepository = new UserRepository();
    private final AuthService authService = new AuthService(userRepository);

    @FXML
    private void onLogin() {
        String name = "Jezreel";
        String email = emailField.getText();
        String password = passwordField.getText();

        boolean logged = authService.login(email, password);
        if (logged) {
            loadDashboard(new User(name, email, password));
        } else {
            errorLabel.setText("Invalid login.");
        }
    }

    private void loadDashboard(User user) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Scene scene = new Scene(loader.load());
            DashboardController controller = loader.getController();
            controller.setUser(user);

            Stage stage = (Stage) emailField.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            errorLabel.setText("Failed to load dashboard.");
            e.printStackTrace();
        }
    }

    @FXML
    private void onRegister() {
        // TODO: load Register.fxml and open register scene
    }
}

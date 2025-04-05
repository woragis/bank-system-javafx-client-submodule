package com.woragis.gui;

import com.woragis.models.User;
import com.woragis.repositories.AccountRepository;
import com.woragis.services.AccountService;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    private Label welcomeLabel;
    @FXML
    private Label balanceLabel;

    private final AccountRepository accountRepository = new AccountRepository();
    private final AccountService accountService = new AccountService(accountRepository);
    private User currentUser;

    public void setUser(User user) {
        this.currentUser = user;
        welcomeLabel.setText("Hello, " + user.getName());
        double balance = accountService.viewBalance(user.getId());
        balanceLabel.setText("Balance: $" + balance);
    }

    @FXML
    private void onDeposit() {
        // Open deposit window or dialog
    }

    @FXML
    private void onWithdraw() {
        // Open withdraw dialog
    }

    @FXML
    private void onTransfer() {
        // Open transfer dialog
    }

    @FXML
    private void onViewHistory() {
        // Open history view
    }
}

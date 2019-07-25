package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;

public class Controller {
    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtEmail;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnShowData;

    @FXML
    private void initialize() {
        btnSave.setOnAction(e -> {
            onBtnSaveClicked();
        });

        btnClear.setOnAction(e -> {
            onBtnClearClicked();
        });

        btnShowData.setOnAction(e -> {
            onBtnShowDataClicked();
        });
    }

    private void onBtnSaveClicked() {
        JOptionPane.showMessageDialog(null, "Save Button Clicked", "Working", JOptionPane.WARNING_MESSAGE);
    }

    private void onBtnClearClicked() {
        txtFirstName.setText("");
        txtLastName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        JOptionPane.showMessageDialog(null, "Clear Button Clicked", "Working", JOptionPane.WARNING_MESSAGE);
    }

    private void onBtnShowDataClicked() {
        JOptionPane.showMessageDialog(null, "Show Data Button Clicked", "Working", JOptionPane.WARNING_MESSAGE);
    }

}

/*
 * Yurtoğlu, N. (2018). Http://www.historystudies.net/dergi//birinci-dunya-savasinda-bir-asayis-sorunu-sebinkarahisar-ermeni-isyani20181092a4a8f.pdf. History Studies International Journal of History, 10(7), 241-264. doi:10.9737/hist.2018.658
 * */
package mainWindow;

import fileOperation.FileInputOutput;
import fileOperation.Utils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;

public class MainController {
    private FileInputOutput fileIO = new FileInputOutput();

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
        String fName = txtFirstName.getText();
        String lName = txtLastName.getText();
        String phone = txtPhone.getText();
        String email = txtEmail.getText();
        if (fName.isEmpty()) {
            showErrorMessage("Empty First Name");
            return;
        } else if (lName.isEmpty()) {
            showErrorMessage("Empty Last Name");
            return;
        } else if (phone.length() != 10) {
            showErrorMessage("Phone number must be size of 10 digit");
            return;
        } else if (!phone.matches("[0-9]*")) {
            showErrorMessage("Your phone number is Invalid");
            return;
        } else if (!email.matches("[^@]+@[^.]+\\..+") || email.isEmpty()) {
            showErrorMessage("Your e-mail address is invalid");
            return;
        }
        String data = Utils.formatData(fName, lName, phone, email);
        try {
            fileIO.saveData(data);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Fail to save data on file, please try again.", "Fail I/O", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "Your data is successfully saved", "Data Saved", JOptionPane.INFORMATION_MESSAGE);
        onBtnClearClicked();
    }

    private void onBtnClearClicked() {
        txtFirstName.setText("");
        txtLastName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
    }

    private void onBtnShowDataClicked() {
        try {
            GridPane root = FXMLLoader.load(getClass().getResource("../secondaryWindow/showData.fxml"));
            Scene scene = new Scene(root, 640, 365);
            scene.getStylesheets().add(getClass().getResource("../secondaryWindow/showData.css").toExternalForm());
            Stage secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.setTitle("PhoneBook Data");
            secondStage.initModality(Modality.APPLICATION_MODAL);  // Use this to make the 2nd window modal (must close 2nd window to return to main window)
            secondStage.show();
            Utils.closeCurrentStage(btnShowData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Invalid Data", JOptionPane.ERROR_MESSAGE);
    }

}

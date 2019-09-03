package secondaryWindow;

import fileOperation.FileInputOutput;
import fileOperation.Utils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;

public class ShowDataController {
    FileInputOutput fileIO = new FileInputOutput();

    @FXML
    private ListView<String> listPhonebook;

    @FXML
    private Button btnBackToForm;

    @FXML
    private Button btnRefresh;

    @FXML
    private void initialize() {
        btnBackToForm.setOnAction(e -> {
            onBtnBackToFormClicked();
        });

        btnRefresh.setOnAction(e -> {
            showPhoneBookList();
        });

        showPhoneBookList();
    }

    private void showPhoneBookList() {
        try {
            listPhonebook.getItems().clear();
            ArrayList<String> data = fileIO.getData();
            for (String dataItem : data) {
                listPhonebook.getItems().add(dataItem);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "I/O Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onBtnBackToFormClicked() {
        try {
            GridPane root = FXMLLoader.load(getClass().getResource("../mainWindow/main.fxml"));
            Scene scene = new Scene(root, 640, 365);
            scene.getStylesheets().add(getClass().getResource("../mainWindow/main.css").toExternalForm());
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.setTitle("PhoneBook");
            primaryStage.initModality(Modality.APPLICATION_MODAL);  // Use this to make the 2nd window modal (must close 2nd window to return to main window)
            primaryStage.show();
            Utils.closeCurrentStage(btnBackToForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

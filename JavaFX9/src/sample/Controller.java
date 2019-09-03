package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller {

    // GUI controls
    @FXML
    private Button btnParse;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnNext;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtNumField;

    private Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid input number..."); // Msg to display

    // This method is automatically called when the window opens, after the FXML file has been loaded.
    // You can put startup and initialization code here.
    @FXML
    private void initialize() {

        // Attach event handler(s)
        btnParse.setOnAction(e -> {
            onBtnParseClicked();   // Call a method in the outer class
        });

        // Attach event handler(s)
        btnClear.setOnAction(e -> {
            onCancelClicked();   // Call a method in the outer class
        });

        // Attach event handler(s)
        btnNext.setOnAction(e -> {
            onOpenSesameClicked();   // Call a method in the outer class
        });
    }

    private void onBtnParseClicked() {
        try {
            txtArea.setText(String.valueOf(Double.parseDouble(txtNumField.getText()) + 1));
        } catch (Exception ex) {
            txtArea.setText("Invalid input number");
            alert.show();
        }
        System.out.println("PARSE button was clicked");
    }

    private void onCancelClicked() {
        txtArea.clear();
        System.out.println("CLEAR button was clicked");
    }

    // Click handler for Open Sesame button
    private void onOpenSesameClicked() {
        // Open the second window (stage)
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("../secondWindow/secondWindow.fxml"));
            Scene scene = new Scene(root, 400, 400);
            Stage secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.initModality(Modality.APPLICATION_MODAL);  // Use this to make the 2nd window modal (must close 2nd window to return to main window)
            secondStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

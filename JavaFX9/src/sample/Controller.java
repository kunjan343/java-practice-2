package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    // GUI controls
    @FXML
    private Button btnParse;

    @FXML
    private Button btnClear;

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

}

package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {

    // GUI controls
    @FXML
    private Button btnOk;
    @FXML
    private Button btnCancel;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;

    // This method is automatically called when the window opens, after the FXML file has been loaded.
    // You can put startup and initialization code here.
    @FXML
    private void initialize() {

        // Attach event handler(s)
        btnOk.setOnAction(new OkHandler());
        btnCancel.setOnAction(new CancelHandler());
    }

    private void onOkClicked() {
        System.out.println(txtFirstName.getText() + " " + txtLastName.getText() + " .. Saved");
    }

    // Inner class
    private class OkHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent e) {
            onOkClicked();   // Call a method in the outer class
        }
    }

    private void onCancelClicked() {
        txtFirstName.clear();
        txtLastName.clear();
        System.out.println("You lose your identity! :(");
    }

    // Inner class
    private class CancelHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent e) {
            onCancelClicked();   // Call a method in the outer class
        }
    }

}

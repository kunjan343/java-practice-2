package secondWindow;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SecondWindowController {

    // GUI controls
    @FXML
    private Button btnOpenMainWindow;

    @FXML
    private void initialize() {

        // Attach event handler(s)
        btnOpenMainWindow.setOnAction(e -> {
            onbtnOpenMainWindowClicked();   // Call a method in the outer class
        });
    }

    private void onbtnOpenMainWindowClicked() {

    }
}

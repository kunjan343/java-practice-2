package fileOperation;

import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Utils {
    public static String formatData(String fName, String lName, String phone, String email) {
        return String.format(fName + "," + lName + "," + phone + "," + email);
    }

    public static void closeCurrentStage(Button button) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }
}

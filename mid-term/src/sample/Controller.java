package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private TextField txtFat;
    @FXML
    private TextField txtCarb;
    @FXML
    private TextField txtProt;
    @FXML
    public Button cmdCalc;
    @FXML
    public Button cmdReset;
    @FXML
    public Text lblCalories;

    @FXML
    private void initialize() {

        // Attach event handler(s)
        cmdCalc.setOnAction(e -> oncmdCalcClicked());
        cmdReset.setOnAction(e -> oncmdResetClicked());
    }

    private void oncmdCalcClicked() {
        double fat = Double.parseDouble(txtFat.getText());
        double carbs = Double.parseDouble(txtCarb.getText());
        double protein = Double.parseDouble(txtProt.getText());
        double calories = fat * 9 + carbs * 4 + protein * 4;
        lblCalories.setText(String.valueOf(calories));
    }

    private void oncmdResetClicked() {
        lblCalories.setText("0.0");
        txtFat.setText(null);
        txtCarb.setText(null);
        txtProt.setText(null);
    }
}

package countryDetail;

import fileOperation.FileInputOutput;
import fileOperation.Utils;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CountryDetailController {
    private FileInputOutput fileIO = new FileInputOutput();

    @FXML
    private Button btnBackToCountriesList;

    @FXML
    private Text txtCountryName;

    @FXML
    private Text txtCapital;

    @FXML
    private Text txtLanguage;

    @FXML
    private Text txtArea;

    @FXML
    private Text txtPopulation;

    @FXML
    private Text txtCurrency;

    @FXML
    private Text txtCallingCode;

    @FXML
    private Text txtDomain;

    @FXML
    private Text txtMotto;

    @FXML
    private Text txtDescription;

    @FXML
    private ListView<String> txtComments;

    @FXML
    private TextField txtNewComment;

    @FXML
    private Button btnSend;

    @FXML
    private void initialize() {
        String country = Utils.getInstance().getSelectedCountry();
        txtCountryName.setText(country);

        btnBackToCountriesList.setOnAction(e -> {
            onBtnBackToCountriesListClicked();
        });

        btnSend.setOnAction(e -> {
            onBtnSendClicked();
        });

        try {
            HashMap<String, String> countryRecord = fileIO.getCountryRecord();
            txtCountryName.setText(countryRecord.get("name"));
            txtCapital.setText(countryRecord.get("capital"));
            txtLanguage.setText(countryRecord.get("language"));
            txtArea.setText(countryRecord.get("area") + " sq.km");
            txtPopulation.setText(countryRecord.get("population"));
            txtCurrency.setText(countryRecord.get("currency"));
            txtCallingCode.setText("+" + countryRecord.get("callingCode"));
            txtDomain.setText("." + countryRecord.get("domain"));
            txtMotto.setText(countryRecord.get("motto"));
            txtDescription.setText(countryRecord.get("description"));
            txtDescription.setWrappingWidth(535);
            displayComments();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void onBtnBackToCountriesListClicked() {
        try {
            String fxml = "../countriesList/countriesList.fxml";
            String styles = "../countriesList/countriesList.css";
            Utils.navigatePage(fxml, styles, btnBackToCountriesList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void displayComments() {
        try {
            txtComments.getItems().clear();
            ArrayList<String> comments = fileIO.getComments();
            for (String comment : comments) {
                txtComments.getItems().add("By Anonymous : " + comment);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void onBtnSendClicked() {
        String comment = txtNewComment.getText();
        if (comment.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please write comment first", "Invalid Data", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            fileIO.addComment(comment);
            txtNewComment.setText("");
            displayComments();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

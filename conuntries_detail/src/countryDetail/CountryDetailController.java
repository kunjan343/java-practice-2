/**
 * CountryDetailController.java
 *
 * Controller assign to display country detail.
 * It display list of comments send by users for selected country.
 * It allow user to add new comment for country.
 *
 * @author Kunjan Patel
 * @version 1.0
 */
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
    /**
     * Create object of file operation class to perform input/output operations
     */
    private FileInputOutput fileIO = new FileInputOutput();

    /**
     * Go back to country list button reference
     */
    @FXML
    private Button btnBackToCountriesList;

    /**
     * Country name text reference
     */
    @FXML
    private Text txtCountryName;

    /**
     * Country capital text reference
     */
    @FXML
    private Text txtCapital;

    /**
     * Country language text reference
     */
    @FXML
    private Text txtLanguage;

    /**
     * Country geographical area text reference
     */
    @FXML
    private Text txtArea;

    /**
     * Country total population text reference
     */
    @FXML
    private Text txtPopulation;

    /**
     * Country currency text reference
     */
    @FXML
    private Text txtCurrency;

    /**
     * Country calling code text reference
     */
    @FXML
    private Text txtCallingCode;

    /**
     * Country internet domain text reference
     */
    @FXML
    private Text txtDomain;

    /**
     * Country motto text reference
     */
    @FXML
    private Text txtMotto;

    /**
     * Country description text reference
     */
    @FXML
    private Text txtDescription;

    /**
     * Country comments list view reference
     */
    @FXML
    private ListView<String> txtComments;

    /**
     * Add new comment text field reference
     */
    @FXML
    private TextField txtNewComment;

    /**
     * Send comment button reference
     */
    @FXML
    private Button btnSend;

    /**
     * Initialize method for javafx controls
     */
    @FXML
    private void initialize() {
        /** Get selected country from service */
        String country = Utils.getInstance().getSelectedCountry();
        /** Set current country name in title bar */
        txtCountryName.setText(country);

        /** Set click action on go back to countries list page button */
        btnBackToCountriesList.setOnAction(e -> {
            onBtnBackToCountriesListClicked();
        });

        /** Set click action on send comment button */
        btnSend.setOnAction(e -> {
            onBtnSendClicked();
        });

        try {
            /** Read list of comments of current selected country from database */
            HashMap<String, String> countryRecord = fileIO.getCountryRecord();
            /** Set country name on page */
            txtCountryName.setText(countryRecord.get("name"));
            /** Set country capital on page */
            txtCapital.setText(countryRecord.get("capital"));
            /** Set country language on page */
            txtLanguage.setText(countryRecord.get("language"));
            /** Set country geographical area on page */
            txtArea.setText(countryRecord.get("area") + " sq.km");
            /** Set country population count on page */
            txtPopulation.setText(countryRecord.get("population"));
            /** Set country currency on page */
            txtCurrency.setText(countryRecord.get("currency"));
            /** Set country calling code on page */
            txtCallingCode.setText("+" + countryRecord.get("callingCode"));
            /** Set country internet domain on page */
            txtDomain.setText("." + countryRecord.get("domain"));
            /** Set country motto on page */
            txtMotto.setText(countryRecord.get("motto"));
            /** Set country description on page */
            txtDescription.setText(countryRecord.get("description"));
            /** Set description wrapping text width to parent window */
            txtDescription.setWrappingWidth(535);
            /** Call display comments function */
            displayComments();
        } catch (Exception ex) {
            ex.printStackTrace();
            showErrorDialog(ex.getMessage());
        }
    }

    /**
     * Redirect user back to countries list page
     */
    private void onBtnBackToCountriesListClicked() {
        try {
            /** Location of countries list fxml file */
            String fxml = "../countriesList/countriesList.fxml";
            /** Location of countries list styles */
            String styles = "../countriesList/countriesList.css";
            /** Calling navigation function with page reference */
            Utils.navigatePage(fxml, styles, btnBackToCountriesList);
        } catch (Exception ex) {
            ex.printStackTrace();
            showErrorDialog(ex.getMessage());
        }
    }

    /**
     * Display list of comments for current selected country
     */
    private void displayComments() {
        try {
            /** Clear all the records from list */
            txtComments.getItems().clear();
            /** Get list of comments for selected country */
            ArrayList<String> comments = fileIO.getComments();
            /** Display all comments in comment box */
            for (String comment : comments) {
                txtComments.getItems().add("By Anonymous : " + comment);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            showErrorDialog(ex.getMessage());
        }
    }

    /**
     * Save new comment into database when send button clicked
     */
    private void onBtnSendClicked() {
        /** Get new comment from text field */
        String comment = txtNewComment.getText();
        /** Check if comment is empty and display appropriate message */
        if (comment.isEmpty()) {
            showErrorDialog("Please write comment first");
            return;
        }
        try {
            /** Call file operation function to add new comment */
            fileIO.addComment(comment);
            /** Clear comment box for new comment */
            txtNewComment.setText("");
            /** Refresh comments list on view */
            displayComments();
        } catch (Exception ex) {
            ex.printStackTrace();
            showErrorDialog(ex.getMessage());
        }
    }

    /**
     * Display error message in error dialog box
     *
     * @param message Error message passed from caller
     */
    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}

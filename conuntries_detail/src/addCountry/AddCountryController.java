/**
 * AddCountryController.java
 *
 * This controller handles all operation associated with adding new country.
 * You can access respective page from country list page in app.
 *
 * @author Kunjan Patel
 * @version 1.0
 */
package addCountry;

import fileOperation.FileInputOutput;
import fileOperation.Utils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.NumberStringConverter;

import javax.swing.*;

public class AddCountryController {
    /**
     * Create object of file operation class to perform input/output operations
     */
    private FileInputOutput fileIO = new FileInputOutput();

    /**
     * Country name text field reference
     */
    @FXML
    private TextField txtName;

    /**
     * Country capital text field reference
     */
    @FXML
    private TextField txtCapital;

    /**
     * Country language text field reference
     */
    @FXML
    private TextField txtLanguage;

    /**
     * Country geographical area text field reference
     */
    @FXML
    private TextField txtArea;

    /**
     * Country total population text field reference
     */
    @FXML
    private TextField txtPopulation;

    /**
     * Country currency text field reference
     */
    @FXML
    private TextField txtCurrency;

    /**
     * Country calling code text field reference
     */
    @FXML
    private TextField txtCallingCode;

    /**
     * Country domain text field reference
     */
    @FXML
    private TextField txtDomain;

    /**
     * Country motto text field reference
     */
    @FXML
    private TextField txtMotto;

    /**
     * Country description text field reference
     */
    @FXML
    private TextArea txtDescription;

    /**
     * Add country form button reference
     */
    @FXML
    private Button btnAdd;

    /**
     * Clear country form button reference
     */
    @FXML
    private Button btnClear;

    /**
     * Country name text field object
     */
    @FXML
    private Button btnBackToCountries;

    /**
     * Initialize method for javafx controls
     */
    @FXML
    private void initialize() {
        /** Set geographical area value to thousands format in form */
        txtArea.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        /** Set calling code value to thousands format in form */
        txtCallingCode.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        /** Set country population value to thousands format in form */
        txtPopulation.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));

        /** Set click action on add country button to submit form data */
        btnAdd.setOnAction(e -> {
            onBtnAddClicked();
        });

        /** Set click action on clear form data button to reset add country form */
        btnClear.setOnAction(e -> {
            onBtnClearClicked();
        });

        /** Set click action on back button to go back to list country page */
        btnBackToCountries.setOnAction(e -> {
            openCountriesListStage();
        });

    }

    /**
     * This function validate add country form record and call add country function in file operation class
     * It displays appropriate error message of form data is invalid of any error occur
     */
    private void onBtnAddClicked() {
        /* Get name of country */
        String name = txtName.getText();
        /** Check if country name is empty and display error if necessary */
        if (name.isEmpty()) {
            showErrorDialog("Please enter country name");
            return;
        }
        /** Check that name should only contain alphabetic  */
        else if (!name.matches("[a-zA-Z ]*")) {
            showErrorDialog("Country name must be alphabetic");
            return;
        }

        /** Get capital of country */
        String capital = txtCapital.getText();
        /** Check if country capital is empty and display error if necessary */
        if (capital.isEmpty()) {
            showErrorDialog("Please enter capital city name");
            return;
        }
        /** Check that capital should only contain alphabetic  */
        else if (!capital.matches("[a-zA-Z ]*")) {
            showErrorDialog("Capital city name must be alphabetic");
            return;
        }
        /** Get first language of country */
        String language = txtLanguage.getText();
        /** Check if country language is empty and display error if necessary */
        if (language.isEmpty()) {
            showErrorDialog("Please enter first language");
            return;
        }
        /** Check that language should only contain alphabetic  */
        else if (!language.matches("[a-zA-Z ]*")) {
            showErrorDialog("Language must be alphabetic");
            return;
        }
        /** Get geographical area of country */
        String geoArea = txtArea.getText();
        /** Check if country geographical area value is empty and display error if necessary */
        if (geoArea.isEmpty()) {
            showErrorDialog("You must enter geographical area");
            return;
        }
        /** Parse geographical area string value to number */
        int area = Integer.parseInt(geoArea.replaceAll(",", ""));
        /** Get population of country */
        String numPopulation = txtPopulation.getText();
        /** Check if country population value is empty and display error if necessary */
        if (numPopulation.isEmpty()) {
            showErrorDialog("You must enter number of population in country");
            return;
        }
        /** Parse population string value to number */
        int population = Integer.parseInt(numPopulation.replaceAll(",", ""));
        /** Get currency of country */
        String currency = txtCurrency.getText();
        /** Check if country currency value is empty and display error if necessary */
        if (currency.isEmpty()) {
            showErrorDialog("Please enter currency name");
            return;
        }
        /** Get calling code of country */
        String callCode = txtCallingCode.getText();
        /** Check if country calling code is empty and display error if necessary */
        if (callCode.isEmpty()) {
            showErrorDialog("Please enter international calling code");
            return;
        }
        /** parse country calling code to number */
        int callingCode = Integer.parseInt(callCode.replaceAll(",", ""));
        /** Get internet domain code of country */
        String domain = txtDomain.getText();
        /** Check if country domain is empty and display error if necessary */
        if (domain.isEmpty()) {
            showErrorDialog("You must enter country domain code");
            return;
        }
        /** Check that country domain should only contain alphabetic  */
        else if (!domain.matches("[a-zA-Z]*")) {
            showErrorDialog("Domain code must be alphabetic");
        }
        /** Get country motto */
        String motto = txtMotto.getText().isEmpty() ? null : txtMotto.getText();
        /** Get country description */
        String description = txtDescription.getText();
        description = description.isEmpty() ? null : description.replaceAll("\n", " ");

        try {
            /** Format string record into file storage format */
            String countryRecord = name + "::" + capital + "::" + language + "::"
                    + area + "::" + population + "::" + currency + "::"
                    + callingCode + "::" + domain + "::" + motto + "::" + description;
            /** Call file operation function to save new country record in database*/
            fileIO.addCountryRecord(name, countryRecord);
            /** Display success message on saving of country record in database */
            JOptionPane.showMessageDialog(null, "Country saved in database", "Success", JOptionPane.INFORMATION_MESSAGE);
            /** Redirect user back to country list page */
            openCountriesListStage();
        } catch (Exception ex) {
            /** Display error message dialog if something goes wrong */
            showErrorDialog(ex.getMessage());
        }
    }

    /**
     * Clear all form record and set back to default state
     */
    private void onBtnClearClicked() {
        /** Clear country name */
        txtName.setText("");
        /** Clear country capital name */
        txtCapital.setText("");
        /** Clear country language */
        txtLanguage.setText("");
        /** Clear country geographical area value */
        txtArea.setText("");
        /** Clear country population number */
        txtPopulation.setText("");
        /** Clear country currency value */
        txtCurrency.setText("");
        /** Clear country calling code */
        txtCallingCode.setText("");
        /** Clear country domain code */
        txtDomain.setText("");
        /** Clear country motto text */
        txtMotto.setText("");
        /** Clear country description */
        txtDescription.setText("");
    }

    /**
     * Display error message in error dialog box
     *
     * @param message Error message passed from caller
     */
    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Invalid Data", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Open list of countries window after selecting continent from page
     */
    private void openCountriesListStage() {
        try {
            /** Location of country list fxml file */
            String fxml = "../countriesList/countriesList.fxml";
            /** Location of country list styles */
            String styles = "../countriesList/countriesList.css";
            /** Calling navigation function with page reference */
            Utils.navigatePage(fxml, styles, btnBackToCountries);
        } catch (Exception ex) {
            /** Display error message if something went wrong*/
            ex.printStackTrace();
            showErrorDialog(ex.getMessage());
        }
    }
}

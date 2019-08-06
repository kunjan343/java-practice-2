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
    private FileInputOutput fileIO = new FileInputOutput();

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtCapital;

    @FXML
    private TextField txtLanguage;

    @FXML
    private TextField txtArea;

    @FXML
    private TextField txtPopulation;

    @FXML
    private TextField txtCurrency;

    @FXML
    private TextField txtCallingCode;

    @FXML
    private TextField txtDomain;

    @FXML
    private TextField txtMotto;

    @FXML
    private TextArea txtDescription;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnBackToCountries;

    @FXML
    private void initialize() {
        txtArea.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        txtCallingCode.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        txtPopulation.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));

        btnAdd.setOnAction(e -> {
            onBtnAddClicked();
        });

        btnClear.setOnAction(e -> {
            onBtnClearClicked();
        });

        btnBackToCountries.setOnAction(e -> {
            openCountriesListStage();
        });

    }

    private void onBtnAddClicked() {
        // Country name
        String name = txtName.getText();
        if (name.isEmpty()) {
            showErrorDialog("Please enter country name");
            return;
        } else if (!name.matches("[a-zA-Z]*")) {
            showErrorDialog("Country name must be alphabetic");
            return;
        }
        // Country capital
        String capital = txtCapital.getText();
        if (capital.isEmpty()) {
            showErrorDialog("Please enter capital city name");
            return;
        } else if (!capital.matches("[a-zA-Z]*")) {
            showErrorDialog("Capital city name must be alphabetic");
            return;
        }
        // Country language
        String language = txtLanguage.getText();
        if (language.isEmpty()) {
            showErrorDialog("Please enter first language");
            return;
        } else if (!language.matches("[a-zA-Z]*")) {
            showErrorDialog("Language must be alphabetic");
            return;
        }
        // Country geographical area
        String geoArea = txtArea.getText();
        if (geoArea.isEmpty()) {
            showErrorDialog("You must enter geographical area");
            return;
        }
        double area = Integer.parseInt(geoArea.replaceAll(",", ""));
        // Country population
        String numPopulation = txtPopulation.getText();
        if (numPopulation.isEmpty()) {
            showErrorDialog("You must enter number of population in country");
            return;
        }
        double population = Integer.parseInt(numPopulation.replaceAll(",", ""));
        // Country currency
        String currency = txtCurrency.getText();
        if (currency.isEmpty()) {
            showErrorDialog("Please enter currency name");
            return;
        }
        // Country calling code
        String callCode = txtCallingCode.getText();
        if (callCode.isEmpty()) {
            showErrorDialog("Please enter international calling code");
            return;
        }
        int callingCode = Integer.parseInt(callCode.replaceAll(",", ""));
        // Country internet domain
        String domain = txtDomain.getText();
        if (domain.isEmpty()) {
            showErrorDialog("You must enter country domain code");
            return;
        } else if (!domain.matches("[a-zA-Z]*")) {
            showErrorDialog("Domain code must be alphabetic");
        }
        // Country motto
        String motto = txtMotto.getText();
        // Country short description
        String description = txtDescription.getText().replaceAll("\n", " ");

        try {
            // Format string record into file storage format
            String countryRecord = name + "::" + capital + "::" + language + "::"
                    + area + "::" + population + "::" + currency + "::"
                    + callingCode + "::" + domain + "::" + motto + "::" + description;
            // System.out.println(countryRecord);
            // Utils.getInstance().setSelectedContinent("Asia");
            JOptionPane.showMessageDialog(null, "Country saved in database", "Success", JOptionPane.INFORMATION_MESSAGE);
            fileIO.addCountryRecord(name, countryRecord);
            openCountriesListStage();
        } catch (Exception ex) {
            showErrorDialog(ex.getMessage());
        }
    }

    private void onBtnClearClicked() {
        txtName.setText("");
        txtCapital.setText("");
        txtLanguage.setText("");
        txtArea.setText("");
        txtPopulation.setText("");
        txtCurrency.setText("");
        txtCallingCode.setText("");
        txtDomain.setText("");
        txtMotto.setText("");
        txtDescription.setText("");
    }

    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Invalid Data", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Open list of countries window after selecting continent from page
     */
    private void openCountriesListStage() {
        try {
            String fxml = "../countriesList/countriesList.fxml";
            String styles = "../countriesList/countriesList.css";
            Utils.navigatePage(fxml, styles, btnBackToCountries);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

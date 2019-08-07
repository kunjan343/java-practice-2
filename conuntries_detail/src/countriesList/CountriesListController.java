/**
 * CountriesListController.java
 *
 * Controller assign to display list of countries for selected continent.
 * It redirect user to country detail page when user select country from list.
 * It redirect user to add country page when user click to add button.
 * It loads JavaFX project settings and call start method in order to initialize app.
 *
 * @author Alexander Pinto
 * @version 1.0
 */
package countriesList;

import fileOperation.FileInputOutput;
import fileOperation.Utils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import javax.swing.*;
import java.util.ArrayList;

public class CountriesListController {
    /**
     * Create object of file operation class to perform input/output operations
     */
    private FileInputOutput fileIO = new FileInputOutput();

    /**
     * Continent name text reference
     */
    @FXML
    private Text txtContinentName;

    /**
     * GO to add country button reference
     */
    @FXML
    private Button btnAddCountry;

    /**
     * Go back to continents list page button reference
     */
    @FXML
    private Button btnBackToContinents;

    /**
     * Countries list view reference
     */
    @FXML
    private ListView<String> countryList;

    /**
     * Initialize method for javafx controls
     */
    @FXML
    private void initialize() {
        /** Get selected country from service */
        String continent = Utils.getInstance().getSelectedContinent();
        /** Set continent name as title in toolbar */
        txtContinentName.setText(continent);

        /** Set click action on go to add new country page button */
        btnAddCountry.setOnAction(e -> {
            openAddCountryStage();
        });

        /** Set click action on go back to continents page button */
        btnBackToContinents.setOnAction(e -> {
            openContinentsStage();
        });

        try {
            /** Clear items from list view */
            countryList.getItems().clear();
            /** Fetch list of countries of selected continent from database */
            ArrayList<String> countriesList = fileIO.getCountriesFromList(continent);
            /** Add and display list of countries on list view */
            for (String country : countriesList) {
                countryList.getItems().add(country);
            }
        } catch (Exception ex) {
            /** Display error message of something went wrong */
            ex.printStackTrace();
            showErrorDialog(ex.getMessage());
        }

        /** Set mouse click on list view to get selected country from list  */
        countryList.setOnMouseClicked(e -> {
            onCountryListClicked();
        });

    }

    /**
     * Open list of countries window after selecting continent from page
     */
    private void openContinentsStage() {
        try {
            /** Location of continents fxml file */
            final String fxml = "../continents/continents.fxml";
            /** Passing null reference to avoid error */
            final String styles = "";
            /** Calling navigation function with page reference */
            Utils.navigatePage(fxml, styles, btnBackToContinents);
        } catch (Exception ex) {
            ex.printStackTrace();
            showErrorDialog(Utils.DEFAULT_ERROR);
        }
    }

    /**
     * Open list of countries window after selecting continent from page
     */
    private void openAddCountryStage() {
        try {
            /** Location of add country fxml file */
            final String fxml = "../addCountry/addCountry.fxml";
            /** Location of add country styles */
            final String styles = "../addCountry/addCountry.css";
            /** Calling navigation function with page reference */
            Utils.navigatePage(fxml, styles, btnBackToContinents);
        } catch (Exception ex) {
            ex.printStackTrace();
            showErrorDialog(Utils.DEFAULT_ERROR);
        }
    }

    /**
     * Get selected country from list and redirect user to country detail page
     */
    private void onCountryListClicked() {
        try {
            /** Get selected country from list */
            String country = countryList.getSelectionModel().getSelectedItem();
            /** If entry is empty then do nothing */
            if (country.isEmpty()) {
                return;
            }
            /** Set selected country in service */
            Utils.getInstance().setSelectedCountry(country);
            /** Location of country detail fxml file */
            final String fxml = "../countryDetail/countryDetail.fxml";
            /** Location of country detail styles */
            final String styles = "../countryDetail/countryDetail.css";
            /** Calling navigation function with page reference */
            Utils.navigatePage(fxml, styles, btnBackToContinents);
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
        JOptionPane.showMessageDialog(null, message, "Internal error", JOptionPane.ERROR_MESSAGE);
    }
}

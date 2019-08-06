package countriesList;

import fileOperation.FileInputOutput;
import fileOperation.Utils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class CountriesListController {
    private FileInputOutput fileIO = new FileInputOutput();

    @FXML
    private Text txtContinentName;

    @FXML
    private Button btnAddCountry;

    @FXML
    private Button btnBackToContinents;

    @FXML
    private ListView<String> countryList;

    @FXML
    private void initialize() {
        String continent = Utils.getInstance().getSelectedContinent();
        txtContinentName.setText(continent);

        btnAddCountry.setOnAction(e -> {
            openAddCountryStage();
        });

        btnBackToContinents.setOnAction(e -> {
            openContinentsStage();
        });

        try {
            countryList.getItems().clear();
            ArrayList<String> countriesList = fileIO.getCountriesFromList(continent);
            for (String country : countriesList) {
                countryList.getItems().add(country);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        countryList.setOnMouseClicked(e -> {
            onCountryListClicked();
        });

    }

    /**
     * Open list of countries window after selecting continent from page
     */
    private void openContinentsStage() {
        try {
            final String fxml = "../continents/continents.fxml";
            final String styles = "";
            Utils.navigatePage(fxml, styles, btnBackToContinents);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Open list of countries window after selecting continent from page
     */
    private void openAddCountryStage() {
        try {
            final String fxml = "../addCountry/addCountry.fxml";
            final String styles = "../addCountry/addCountry.css";
            Utils.navigatePage(fxml, styles, btnBackToContinents);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onCountryListClicked() {
        try {
            String country = countryList.getSelectionModel().getSelectedItem();
            if (country.isEmpty()) {
                return;
            }
            Utils.getInstance().setSelectedCountry(country);
            final String fxml = "../countryDetail/countryDetail.fxml";
            final String styles = "../countryDetail/countryDetail.css";
            Utils.navigatePage(fxml, styles, btnBackToContinents);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

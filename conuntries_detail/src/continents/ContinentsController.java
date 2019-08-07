/**
 * ContinentsController.java
 *
 * This controller is assigned to continents page to handle event operation.
 * It reads selected continent and store it in Utils variable
 * Redirects to list of country page for selected continent
 *
 * @author Alexander Pinto
 * @version 1.0
 */
package continents;

import fileOperation.Utils;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import javax.swing.*;

public class ContinentsController {

    /**
     * Asia imageView reference
     */
    @FXML
    private ImageView imgAsia;

    /**
     * Africa imageView reference
     */
    @FXML
    private ImageView imgAfrica;

    /**
     * Antarctica imageView reference
     */
    @FXML
    private ImageView imgAntarctica;

    /**
     * Australia imageView reference
     */
    @FXML
    private ImageView imgAustralia;

    /**
     * Europe imageView reference
     */
    @FXML
    private ImageView imgEurope;

    /**
     * North America imageView reference
     */
    @FXML
    private ImageView imgNorthAmerica;

    /**
     * South America imageView reference
     */
    @FXML
    private ImageView imgSouthAmerica;

    /**
     * Initialize method for javafx controls
     */
    @FXML
    private void initialize() {
        /** Set mouse click on image to open asian countries list */
        imgAsia.setOnMouseClicked(e -> {
            openCountriesListStage("Asia");
        });

        /** Set mouse click on image to open african countries list */
        imgAfrica.setOnMouseClicked(e -> {
            openCountriesListStage("Africa");
        });

        /** Set mouse click on image to open antarctica countries list */
        imgAntarctica.setOnMouseClicked(e -> {
            openCountriesListStage("Antarctica");
        });

        /** Set mouse click on image to open australian countries list */
        imgAustralia.setOnMouseClicked(e -> {
            openCountriesListStage("Australia");
        });

        /** Set mouse click on image to open european countries list */
        imgEurope.setOnMouseClicked(e -> {
            openCountriesListStage("Europe");
        });

        /** Set mouse click on image to open north american countries list */
        imgNorthAmerica.setOnMouseClicked(e -> {
            openCountriesListStage("North America");
        });

        /** Set mouse click on image to open south american countries list */
        imgSouthAmerica.setOnMouseClicked(e -> {
            openCountriesListStage("South America");
        });
    }

    /**
     * Set current selected continent and redirect to countries page
     *
     * @param continent Name of continent
     */
    private void openCountriesListStage(String continent) {
        try {
            /** Set new country into service */
            Utils.getInstance().setSelectedContinent(continent);
            /** Location of country list fxml file */
            String fxml = "../countriesList/countriesList.fxml";
            /** Location of country list styles */
            String styles = "../countriesList/countriesList.css";
            /** Calling navigation function with page reference */
            Utils.navigatePage(fxml, styles, imgAsia);
        } catch (Exception e) {
            /** Display error message if something went wrong*/
            JOptionPane.showMessageDialog(null, Utils.DEFAULT_ERROR, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}

/**
 * ContinentsController.java
 * This controller is assigned to continents page to handle event operation.
 * It reads selected continent and store it in Utils variable
 * Redirects to list of country page for selected continent
 *
 * @author kunjan patel
 * @version 1.0
 */
package continents;

import fileOperation.Utils;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class ContinentsController {

    /**
     * Asia imageView object access
     */
    @FXML
    private ImageView imgAsia;

    /**
     * Africa imageView object access
     */
    @FXML
    private ImageView imgAfrica;

    /**
     * Antarctica imageView object access
     */
    @FXML
    private ImageView imgAntarctica;

    /**
     * Australia imageView object access
     */
    @FXML
    private ImageView imgAustralia;

    /**
     * Europe imageView object access
     */
    @FXML
    private ImageView imgEurope;

    /**
     * North America imageView object access
     */
    @FXML
    private ImageView imgNorthAmerica;

    /**
     * South America imageView object access
     */
    @FXML
    private ImageView imgSouthAmerica;

    /**
     * initialize method for javafx controls
     */
    @FXML
    private void initialize() {
        // Set mouse click on image to open asian countries list
        imgAsia.setOnMouseClicked(e -> {
            openCountriesListStage("Asia");
        });

        // Set mouse click on image to open african countries list
        imgAfrica.setOnMouseClicked(e -> {
            openCountriesListStage("Africa");
        });

        // Set mouse click on image to open antarctica countries list
        imgAntarctica.setOnMouseClicked(e -> {
            openCountriesListStage("Antarctica");
        });

        // Set mouse click on image to open australian countries list
        imgAustralia.setOnMouseClicked(e -> {
            openCountriesListStage("Australia");
        });

        // Set mouse click on image to open european countries list
        imgEurope.setOnMouseClicked(e -> {
            openCountriesListStage("Europe");
        });

        // Set mouse click on image to open north american countries list
        imgNorthAmerica.setOnMouseClicked(e -> {
            openCountriesListStage("North America");
        });

        // Set mouse click on image to open south american countries list
        imgSouthAmerica.setOnMouseClicked(e -> {
            openCountriesListStage("South America");
        });
    }

    /**
     * Set current selected continent and redirect to countries page
     *
     * @param continent String name of continent
     */
    private void openCountriesListStage(String continent) {
        try {
            Utils.getInstance().setSelectedContinent(continent);
            String fxml = "../countriesList/countriesList.fxml";
            String styles = "../countriesList/countriesList.css";
            Utils.navigatePage(fxml, styles, imgAsia);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

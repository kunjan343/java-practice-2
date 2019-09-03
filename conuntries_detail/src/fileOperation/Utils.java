/**
 * Utils.java
 *
 * This class design as service to provide supported content and constant values.
 * It holds temporary values on time of app execution.
 * It handles redirection of pages on call.
 *
 * @author Alexander Pinto
 * @version 1.0
 */
package fileOperation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Utils {
    /**
     * App title constant
     */
    public static final String APP_TITLE = "Countries Detail App";
    /**
     * App default error message constant
     */
    public static final String DEFAULT_ERROR = "Something went wrong, please try again";
    /**
     * App window width constant
     */
    public static final int WINDOW_WIDTH = 600;
    /**
     * App window height constant
     */
    public static final int WINDOW_HEIGHT = 768;

    /**
     * Object reference for singleton
     */
    private static Utils onlyObject = null;

    /**
     * Local selected continent service variable
     */
    private String selectedContinent = null;
    /**
     * Local selected country service variable
     */
    private String selectedCountry = null;

    /**
     * Get path of countries record database location
     *
     * @param continent Name of selected continent
     * @return file associated with continent
     */
    static String getContinent(String continent) {
        String COUNTRIES_PATH = "src/resources/database/countries/";
        return COUNTRIES_PATH + continent + ".txt";
    }

    /**
     * Get path of country record database location
     *
     * @param continent Name of continent
     * @return file associated with country detail
     */
    static String getCountryRecords(String continent) {
        String COUNTRY_DETAIL_PATH = "src/resources/database/records/";
        return COUNTRY_DETAIL_PATH + continent + ".txt";
    }

    /**
     * Get path of comments record database location
     *
     * @param country Name of selected country
     * @return file associated with comments of country record
     */
    static String getComments(String country) {
        String COMMENTS_PATH = "src/resources/database/comments/";
        return COMMENTS_PATH + country + ".txt";
    }

    /**
     * Convert string into capitalise format
     *
     * @param data Any name
     * @return Formatted string
     */
    public static String capitalise(String data) {
        return Character.toUpperCase(data.charAt(0)) + data.substring(1);
    }

    /**
     * Open new stage and close current window
     *
     * @param fxml   Path of new page view
     * @param styles Path of new page styles
     * @param button Button reference from current window
     * @throws Exception Return error if something goes wrong
     */
    public static void navigatePage(String fxml, String styles, Button button) throws Exception {
        getInstance().openNewStage(fxml, styles);
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    /**
     * Open new stage and close current window
     *
     * @param fxml      Path of new page view
     * @param styles    Path of new page styles
     * @param imageView Image reference from current window
     * @throws Exception Return error if something goes wrong
     */
    public static void navigatePage(String fxml, String styles, ImageView imageView) throws Exception {
        getInstance().openNewStage(fxml, styles);
        Stage stage = (Stage) imageView.getScene().getWindow();
        stage.close();
    }

    /**
     * Set selected continent
     *
     * @param continent Name of selected continent
     */
    public void setSelectedContinent(String continent) {
        this.selectedContinent = continent;
    }

    /**
     * Get name of continent from service
     *
     * @return Name of continent
     */
    public String getSelectedContinent() {
        return this.selectedContinent;
    }

    /**
     * Set selected country
     *
     * @param country Name of selected country
     */
    public void setSelectedCountry(String country) {
        this.selectedCountry = country;
    }

    /**
     * Return name of country from service
     *
     * @return Name of country
     */
    public String getSelectedCountry() {
        return this.selectedCountry;
    }

    /**
     * Return singleton instance of class to share values between multiple controllers
     *
     * @return Instance of utils classs
     */
    public static Utils getInstance() {
        if (onlyObject == null) {
            onlyObject = new Utils();
        }
        return onlyObject;
    }


    /**
     * Open new stage and close current window
     *
     * @param fxml   Path of new page view
     * @param styles Path of new page styles
     * @throws Exception Return error if something goes wrong
     */
    private void openNewStage(String fxml, String styles) throws Exception {
        /** Create new scene */
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource(fxml)), Utils.WINDOW_WIDTH, Utils.WINDOW_HEIGHT);
        /** Read style file and attach to fxml page */
        if (!styles.isEmpty()) {
            scene.getStylesheets().add(getClass().getResource(styles).toExternalForm());
        }
        /** Create new stage */
        Stage stage = new Stage();
        /** Set scene inside stage */
        stage.setScene(scene);
        /** Set title of window */
        stage.setTitle(Utils.APP_TITLE);
        /** Use this to make the 2nd window modal (must close 2nd window to return to another window) */
        stage.initModality(Modality.APPLICATION_MODAL);
        /** Display new stage */
        stage.show();
    }
}

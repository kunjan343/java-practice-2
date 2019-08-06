package fileOperation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Utils {
    public static final String APP_TITLE = "Countries Detail App";
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 768;

    private static Utils onlyObject = null;

    private String selectedContinent = null;
    private String selectedCountry = null;

    static String getContinent(String continent) {
        String COUNTRIES_PATH = "src/resources/database/countries/";
        return COUNTRIES_PATH + continent + ".txt";
    }

    static String getCountryRecords(String continent) {
        String COUNTRY_DETAIL_PATH = "src/resources/database/records/";
        return COUNTRY_DETAIL_PATH + continent + ".txt";
    }

    static String getComments(String country) {
        String COMMENTS_PATH = "src/resources/database/comments/";
        return COMMENTS_PATH + country + ".txt";
    }

    public static String capitalise(String data) {
        return Character.toUpperCase(data.charAt(0)) + data.substring(1);
    }

    public static void navigatePage(String fxml, String styles, Button button) throws Exception {
        getInstance().openNewStage(fxml, styles);
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    public static void navigatePage(String fxml, String styles, ImageView imageView) throws Exception {
        getInstance().openNewStage(fxml, styles);
        Stage stage = (Stage) imageView.getScene().getWindow();
        stage.close();
    }

    public void setSelectedContinent(String continent) {
        this.selectedContinent = continent;
    }

    public String getSelectedContinent() {
        return this.selectedContinent;
    }

    public void setSelectedCountry(String country) {
        this.selectedCountry = country;
    }

    public String getSelectedCountry() {
        return this.selectedCountry;
    }

    public static Utils getInstance() {
        if (onlyObject == null) {
            onlyObject = new Utils();
        }
        return onlyObject;
    }


    private void openNewStage(String fxml, String styles) throws Exception {
        // Create new scene
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource(fxml)), Utils.WINDOW_WIDTH, Utils.WINDOW_HEIGHT);
        // Read style file and attach to fxml page
        if (!styles.isEmpty()) {
            scene.getStylesheets().add(getClass().getResource(styles).toExternalForm());
        }
        // Create new stage
        Stage stage = new Stage();
        // Set scene inside stage
        stage.setScene(scene);
        // Set title of window
        stage.setTitle(Utils.APP_TITLE);
        // Use this to make the 2nd window modal (must close 2nd window to return to another window)
        stage.initModality(Modality.APPLICATION_MODAL);
        // Display new stage
        stage.show();
    }
}

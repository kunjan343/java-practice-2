package patkunja;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Assign2Main extends Application {

    /**
     * @param primaryStage set new stage window for application window
     * @throws Exception return any exception occur in application launch
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // get fxml file for main window
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        // Set title for window
        primaryStage.setTitle("Inventory Tracker");
        // set window size and stage scene
        primaryStage.setScene(new Scene(root, 360, 600));
        // display application window
        primaryStage.show();
    }


    /**
     * @param args application input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

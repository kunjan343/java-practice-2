/**
 * Main.java
 *
 * Project main java class where it starts project.
 * It loads JavaFX project settings and call start method in order to initialize app.
 *
 * @author Alexander Pinto
 * @version 1.0
 */
package continents;

import fileOperation.Utils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * JavaFX start method implementation which implicitly called when app starts
     *
     * @param primaryStage New stage set to display window
     *
     * @throws Exception Throw exception if error occur while application launch
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        /** Get main fxml file with root reference */
        Parent root = FXMLLoader.load(getClass().getResource("continents.fxml"));
        /** Set title of application*/
        primaryStage.setTitle(Utils.APP_TITLE);
        /** Create new JavaFX scene inside current window */
        Scene scene = new Scene(root, Utils.WINDOW_WIDTH, Utils.WINDOW_HEIGHT);
        /** Set current scene inside stage to display on GUI */
        primaryStage.setScene(scene);
        /** Display current stage */
        primaryStage.show();
    }

    /**
     * Class main method execute when app starts
     *
     * @param args Argument passed in console/app launch code
     */
    public static void main(String[] args) {
        /** Call application launch function inside JavaFX code */
        launch(args);
    }
}

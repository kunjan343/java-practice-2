package continents;

import fileOperation.Utils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("continents.fxml"));
        primaryStage.setTitle(Utils.APP_TITLE);
        Scene scene = new Scene(root, Utils.WINDOW_WIDTH, Utils.WINDOW_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

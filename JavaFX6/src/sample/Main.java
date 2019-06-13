package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a scene and place a button in the scene
        FlowPane flowpane = new FlowPane();
        flowpane.setVgap(5);
        flowpane.setHgap(85);

        // Form buttons
        Button btnOK = new Button("OK");
        Button btnCancel = new Button("CANCEL");

        // first name with label
        Label firstNameLabel = new Label("First Name: ");
        TextField firstNameTF = new TextField();
        firstNameTF.setText("KUNJAN");

        // Last name with label
        Label lastNameLabel = new Label("Last Name: ");
        TextField lastNameTF = new TextField();
        lastNameTF.setText("PATEL");

        FlowPane.setMargin(btnOK, new Insets(10, 10, 10, 10));
        FlowPane.setMargin(btnCancel, new Insets(10, 10, 10, 10));

        flowpane.getChildren().add(firstNameLabel);
        flowpane.getChildren().add(firstNameTF);
        flowpane.getChildren().add(lastNameLabel);
        flowpane.getChildren().add(lastNameTF);
        flowpane.getChildren().add(btnOK);
        flowpane.getChildren().add(btnCancel);

        // Numbers are width & height (pixels)
        Scene scene = new Scene(flowpane, 360, 240);

        // Set the window title
        primaryStage.setTitle("User Form");
        // Place the scene in the stage
        primaryStage.setScene(scene);
        // Display scene on window
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

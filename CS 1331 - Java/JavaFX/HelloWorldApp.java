package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HelloWorldApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World JavaFX App");

        // Create a button
        Button helloButton = new Button("Hello World");

        // Set an action for the button
        helloButton.setOnAction(e -> {
            // Print "Hello World" to the console when the button is clicked
            System.out.println("Hello World");
        });

        // Create a layout and add the button to it
        javafx.scene.layout.StackPane root = new javafx.scene.layout.StackPane();
        root.getChildren().add(helloButton);

        // Create the scene and set it on the stage
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }
}

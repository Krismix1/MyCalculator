package Application;

import GUI.GUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by Chris on 10-Feb-17.
 */
public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Calculator");

        BorderPane layout = new BorderPane();
        FlowPane test = new FlowPane(5, 5);
        layout.setCenter(test);
        // Find a better layout,one that divides the scene into smaller ones, think it's called GridPane
        // Add all other operations such as power, sqrt, log etc.
        GUI gui = new GUI();
        layout.setTop(gui.createTopPart());
        gui.createOperations(test);
        gui.createDigits(test);

        Scene mainScene = new Scene(layout, 300, 250);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

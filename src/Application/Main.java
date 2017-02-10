package Application;

import GUI.GUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Chris on 10-Feb-17.
 */
public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Calculator");

        Pane test = new VBox();
        // Find a better layout,one that divides the scene into smaller ones, think it's called GridPane
        // Add all other operations such as power, sqrt, log etc.
        GUI gui = new GUI();
        gui.createOperations(test);
        gui.createDigits(test);

        Scene mainScene = new Scene(test, 300, 250);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }


}

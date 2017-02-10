package GUI;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * Created by Chris on 10-Feb-17.
 */
public class GUI
{
    public void createDigits(Pane root)
    {
        for (int i = 0; i <= 9; i++)
        {
            Button button = new Button();
            button.setText(i + "");
            root.getChildren().add(button);
        }
    }

    public void createOperations(Pane root)
    {
        Button plus = new Button("+");
        Button minus = new Button("-");
        Button multiplication = new Button("*");
        Button division = new Button("/");

        root.getChildren().addAll(plus, minus, multiplication, division);
    }
}

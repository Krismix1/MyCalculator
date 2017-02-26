package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * Created by Chris on 10-Feb-17.
 */
public class GUI
{
    private Text expression;

    public void createDigits(Pane root)
    {
        for (int i = 0; i <= 9; i++)
        {
            Button button = new Button();
            button.setText(i + "");
            root.getChildren().add(button);
            button.setOnAction(e -> expression.setText(expression.getText() + button.getText()));
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

    public Scene createScene()
    {
        return null;
    }

    public Pane createTopPart()
    {
        HBox topLayout = new HBox();
        if(expression == null)
        {
            expression = new Text();
        }
        expression.setText("");
        topLayout.getChildren().addAll(expression);
        return topLayout;
    }
}

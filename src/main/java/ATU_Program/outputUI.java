package ATU_Program;

/**
 * The scenery created model which is used to construct the GUI
 * and set the actions of the button.
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * The class to construct the GUI.
 * @author Huang Baixiang
 * @version 1.0.0
 */
public class outputUI {

    @FXML
    private Button button1;

    @FXML
    private Label inputbox;

    @FXML
    private TextField textbox;
    

    @FXML
    private TextField textbox2;
    
    /**
     * The method to handle the event when clicking the button
     * @param event to sense the action
     */
    @FXML
    void pressButton(ActionEvent event) {
    	String input = textbox.getText();
    	String input_id = textbox2.getText();
    	// Output.chart();
    	Output.table(input,input_id);
    }
}

package atu.output;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class outputUI {

    @FXML
    private Button button1;

    @FXML
    private Label inputbox;

    @FXML
    private TextField textbox;

    @FXML
    void pressButton(ActionEvent event) {
    	String input = textbox.getText();
    	// Output.chart();
    	Output.table(input);
    }
}

package jasleen.javaApp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class controller implements Initializable {
@FXML
public Label label;
@FXML
public ChoiceBox<String> Box;
@FXML
public TextField tField;
@FXML
public Button convertButton;

private static final String C_TO_F_TEXT = " Celsius to Farenheit";
	private static final String F_TO_C_TEXT = " Farenheit to Celsius";
private Boolean isC_TO_F=true;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Box.getItems().add(C_TO_F_TEXT);
		Box.getItems().add(F_TO_C_TEXT);
		Box.setValue(C_TO_F_TEXT);

		Box.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
				{	if(newValue.equals(C_TO_F_TEXT))
		{
			isC_TO_F=true;
		}
		else
		{
			isC_TO_F=false;
			
		}
	}
		);

		convertButton.setOnAction(event -> convert());

	}

	private void convert() {
		String input= tField.getText();

		float enteredTemperature=0.0f;
		try{
		enteredTemperature=Float.parseFloat(input);}
		catch(Exception e){
			warnuser();
			return;
		}


		float newTemperature;
		if(isC_TO_F)
		{
			newTemperature=(enteredTemperature*9/5)+32;

		}
		else
		{
			newTemperature=(enteredTemperature-32)*5/9;
		}

		display(newTemperature);
	}

	private void warnuser() {
		Alert alertdialog=new Alert(Alert.AlertType.ERROR);
		alertdialog.setTitle("Error occured");
		alertdialog.setContentText("Enter some valid temperature");
		alertdialog.show();

	}

	private void display(float newTemperature) {
		String unit= isC_TO_F?"F":"C";
		Alert alertdialog=new Alert(Alert.AlertType.INFORMATION);
		alertdialog.setTitle("Result");
		alertdialog.setContentText("The new temperature is:"+newTemperature+" "+unit);
		alertdialog.show();
	}
}

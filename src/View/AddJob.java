package View;

import java.time.LocalDate;
import java.util.Calendar;

import Model.Job;
import Model.Model;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddJob extends JobMenu
{
	
	public AddJob(Model model)
	{
		super(model);
	}
	
	public void display()
	{	
		super.display();
		dueDatePicker.setValue(LocalDate.now());
		date = LocalDate.now();
		stringDate= date.toString();
		
		
		confirm.setText("Add");
		confirm.setOnAction(e -> {

			//In case radio button doesnt change
			if(radioString == null)
			{
				radioString = "Low";
			}
			
			_job = _model.backup.add(jobName.getText(),descriptionInfo.getText(),radioString,stringDate);
			_model.add(jobName.getText(),descriptionInfo.getText(),radioString,stringDate);
			System.out.println("Total is " + _model.backup.getList().size());
			//_model.add(_job);
			super.jobAction();
			windowClosed = true;
			_addJobStage.close();
			});
		
		jobWindow.setText("Add");
		
		
		_addJobStage = new Stage();

		Scene scene = new Scene(jobWindow);
		_addJobStage.setScene(scene);
		_addJobStage.showAndWait();
	}
	
	
	public void setJob(int index)
	{
		_job = _model.backup.getList().get(index);
	}
	
	public JobPane getJobPane()
	{
		return _anchorPane;
	}
	
	public boolean getWindowClosed()
	{
		return windowClosed;
	}
	
	public Job getJob()
	{
		return _job;
	}
}

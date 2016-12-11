package View;

import java.time.LocalDate;
import java.time.Year;
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

public class ChangeJob extends JobMenu
{
	
	public ChangeJob(Model model,Job job)
	{
		super(model);
		_job = job;
	}
	public void display()
	{
		super.display();
		String oldJobDate = String.valueOf(_job.getDate().get(Calendar.YEAR));
		oldJobDate += "-" + String.valueOf(_job.getDate().get(Calendar.MONTH)+1);
		if(_job.getDate().get(Calendar.DAY_OF_MONTH)<10)
		{
			oldJobDate += "-0" + String.valueOf(_job.getDate().get(Calendar.DAY_OF_MONTH));
		}
		LocalDate jobDate= LocalDate.of(_job.getDate().get(Calendar.YEAR),_job.getDate().get(Calendar.MONTH)+1,_job.getDate().get(Calendar.DAY_OF_MONTH));
		dueDatePicker.setValue(jobDate);
		
		jobName.setText(_job.getName());
		descriptionInfo.setText(_job.getDescription());
		
		if(_job.getPriority() == 1)
		{
			radioButtonGroup.getToggles().get(0).setSelected(true);
		}
		else if (_job.getPriority() == 2)
		{
			radioButtonGroup.getToggles().get(0).setSelected(true);
		}
		else
		{
			radioButtonGroup.getToggles().get(0).setSelected(true);
		}
		
		
		confirm.setText("Change");
		confirm.setOnAction(e -> {
			//In case radio button doesnt change
			if(radioString == null)
			{
				int priority =_job.getPriority();
		        radioString = "Low";
		        
				if(priority == 3)
					radioString = "High";
				if(priority == 2)
					radioString = "Medium";
			}
			if(date == null)
			{
				date = jobDate;
				stringDate = date.toString();
			}
			_model.backup.change(_job.getID(),jobName.getText(),descriptionInfo.getText(),radioString, stringDate);
			super.jobAction();
			windowClosed = true;
			_addJobStage.close();
			});
		
		
		
		
		jobWindow.setText("Modify");
		
		_addJobStage = new Stage();

		Scene scene = new Scene(jobWindow);
		_addJobStage.setScene(scene);
		_addJobStage.showAndWait();
	}
	
	
	public boolean getWindowClosed()
	{
		return windowClosed;
	}
	
	public JobPane getAnchorPane()
	{
		return _anchorPane;
	}
}

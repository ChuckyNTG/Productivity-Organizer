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
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ChangeJob
{
	Model _model;
	JobPane anchorPane;
	Stage addJobStage;
	RadioButton chk;
	String stringDate;
	LocalDate date;
	Job _job;
	boolean windowClosed;
	
	public ChangeJob(Model model,Job job)
	{
		_model = model;
		_job = job;
		windowClosed = false;
	}
	public void display()
	{
		Label name = new Label ("Name: ");
		name.setLayoutX(80);
		name.setLayoutY(50);
		Label priority = new Label("Priority: ");
		priority.setLayoutX(80);
		priority.setLayoutY(87);
		Label dueDate = new Label("Due Date: ");
		dueDate.setLayoutX(80);
		dueDate.setLayoutY(124);
		
		Label description = new Label("Description: ");
		description.setLayoutX(80);
		description.setLayoutY(161);
		
		TextField jobName = new TextField();
		jobName.setText(_job.getName());
		jobName.setLayoutX(170);
		jobName.setLayoutY(45);
		jobName.setPrefSize(233, 31);
		
		TextField descriptionInfo = new TextField();
		descriptionInfo.setText(_job.getDescription());
		descriptionInfo.setPrefSize(219, 69);
		descriptionInfo.setLayoutX(170);
		descriptionInfo.setLayoutY(158);
		
		DatePicker dueDatePicker = new DatePicker();
		dueDatePicker.setPrefSize(233, 31);
		dueDatePicker.setLayoutX(170);
		dueDatePicker.setLayoutY(117);
		String oldJobDate = String.valueOf(_job.getDate().get(Calendar.YEAR));
		oldJobDate += "-" + String.valueOf(_job.getDate().get(Calendar.MONTH)+1);
		if(_job.getDate().get(Calendar.DAY_OF_MONTH)<10)
		{
			oldJobDate += "-0" + String.valueOf(_job.getDate().get(Calendar.DAY_OF_MONTH));
		}
	    LocalDate jobDate = LocalDate.parse(oldJobDate);
		dueDatePicker.setValue(jobDate);
		dueDatePicker.setOnAction(event->{
			date = dueDatePicker.getValue();
			stringDate= date.toString();
			System.out.println(stringDate);
		});
		
		ToggleGroup group = new ToggleGroup();
		
		RadioButton low = new RadioButton("Low");
		low.setToggleGroup(group);
		low.setLayoutX(170);
		low.setLayoutY(87);
		RadioButton medium = new RadioButton("Medium");
		medium.setToggleGroup(group);
		medium.setLayoutX(240);
		medium.setLayoutY(87);
		RadioButton high = new RadioButton("High");
		high.setToggleGroup(group);
		high.setLayoutX(334);
		high.setLayoutY(87);
		
		if(_job.getPriority() == 1)
		{
			low.setSelected(true);
		}
		else if (_job.getPriority() == 2)
		{
			medium.setSelected(true);
		}
		else
		{
			high.setSelected(true);
		}
		
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
				{

					@Override
					public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2)
					{
						chk = (RadioButton)arg2.getToggleGroup().getSelectedToggle();
						
					}
			
				});
		
		Button addTask = new Button("Change");
		addTask.setLayoutX(8);
		addTask.setLayoutY(250);
		addTask.setOnAction(e -> {
			String jobNameText = jobName.getText();
			String jobDescriptionText = descriptionInfo.getText();
			//In case radio button doesnt change
			if(chk == null)
			{
				if(_job.getPriority() == 1)
				{
					chk = low;
				}
				else if (_job.getPriority() == 2)
				{
					chk = medium;
				}
				else
				{
					chk = high;
				}
			}
			if(date == null)
			{
				date = jobDate;
				stringDate = date.toString();
			}
			_model.change(_job.getID(),jobNameText,jobDescriptionText, chk.getText(), stringDate);
			this.changeJob();
			windowClosed = true;
			addJobStage.close();
			});
		
		Button cancel = new Button("Cancel");
		cancel.setLayoutX(392);
		cancel.setLayoutY(250);
		
		
		AnchorPane jobContents = new AnchorPane();
		jobContents.setPrefSize(400, 200);
		jobContents.getChildren().addAll(name,priority,dueDate,description,dueDatePicker,
											low,medium,high,jobName,descriptionInfo,addTask,cancel);
		TitledPane addJob = new TitledPane();
		addJob.setText("Modify");
		addJob.setContent(jobContents);
		addJob.setCollapsible(false);
		addJob.setAnimated(false);
		
		addJobStage = new Stage();

		Scene scene = new Scene(addJob);
		addJobStage.setScene(scene);
		addJobStage.showAndWait();
	}
	
	public void changeJob()
	{
		anchorPane = new JobPane();
		anchorPane.setName(_job.getName());  
        anchorPane.setDescription(_job.getDescription());
        anchorPane.setPriority(String.valueOf(_job.getPriority()));
      //theres probably a better way todo this but I was tired
        int year = _job.getDate().get(Calendar.YEAR);
        int month = _job.getDate().get(Calendar.MONTH);
        int dayOfMonth = _job.getDate().get(Calendar.DAY_OF_MONTH);
        String date = String.valueOf(month+1);
        date += "/" + String.valueOf(dayOfMonth);
        date += "/" + String.valueOf(year);
        anchorPane.setDate(date);
	}
	
	public boolean getWindowClosed()
	{
		return windowClosed;
	}
	
	public JobPane getAnchorPane()
	{
		return anchorPane;
	}
}

package View;

import java.time.LocalDate;
import java.util.Calendar;

import Model.Job;
import Model.Model;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

public class JobMenu
{
	//Model, current job, and anchorpane to create
	Model _model;
	Job _job;
	JobPane _anchorPane;
	
	//Components on screen
	String radioString;
	String stringDate;
	LocalDate date;
	TextField jobName;
	TextArea descriptionInfo;
	DatePicker dueDatePicker;
	ToggleGroup radioButtonGroup;
	Stage _addJobStage;
	TitledPane jobWindow;
	Button confirm;
	//Whether the window was closed 
	boolean windowClosed;
	
	public JobMenu(Model model)
	{
		_model = model;
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
		
		jobName = new TextField();
		jobName.setLayoutX(170);
		jobName.setLayoutY(45);
		jobName.setPrefSize(233, 31);
		
		descriptionInfo = new TextArea();
		
		descriptionInfo.setPrefSize(219, 69);
		descriptionInfo.setLayoutX(170);
		descriptionInfo.setLayoutY(158);
		
		dueDatePicker = new DatePicker();
		dueDatePicker.setPrefSize(233, 31);
		dueDatePicker.setLayoutX(170);
		dueDatePicker.setLayoutY(117);
		
		dueDatePicker.setOnAction(event->{
			date = dueDatePicker.getValue();
			stringDate= date.toString();
			System.out.println(stringDate);
		});
		
		radioButtonGroup = new ToggleGroup();
		
		RadioButton low = new RadioButton("Low");
		low.setToggleGroup(radioButtonGroup);
		low.setSelected(true);
		low.setLayoutX(170);
		low.setLayoutY(87);
		RadioButton medium = new RadioButton("Medium");
		medium.setToggleGroup(radioButtonGroup);
		medium.setLayoutX(240);
		medium.setLayoutY(87);
		RadioButton high = new RadioButton("High");
		high.setToggleGroup(radioButtonGroup);
		high.setLayoutX(334);
		high.setLayoutY(87);
		
		radioButtonGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
		{

			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2)
			{
				RadioButton chk = (RadioButton)arg2.getToggleGroup().getSelectedToggle();
				radioString = chk.getText();
				
			}
	
		});
		
		confirm = new Button();
		confirm.setLayoutX(392);
		confirm.setLayoutY(250);
		
		AnchorPane jobContents = new AnchorPane();
		jobContents.setPrefSize(400, 200);
		jobContents.getChildren().addAll(name,priority,dueDate,description,dueDatePicker,
											low,medium,high,jobName,descriptionInfo,confirm);
		
		jobContents.setStyle("-fx-background-color: #1d1d1d");
		String css = this.getClass().getResource("cssstyling.css").toExternalForm();
		
		jobWindow = new TitledPane();
		jobWindow.getStylesheets().add(css);
		jobWindow.setContent(jobContents);
		jobWindow.setCollapsible(false);
		jobWindow.setAnimated(false);
	}
	
	public void jobAction()
	{
		_anchorPane = new JobPane();
		_anchorPane.setName(_job.getName());  
        _anchorPane.setDescription(_job.getDescription());
        int priority =_job.getPriority();
        String priorityString = "Low";
        
		if(priority == 3)
			priorityString = "High";
		if(priority == 2)
			priorityString = "Medium" ;
        _anchorPane.setPriority(priorityString);
      //theres probably a better way todo this but I was tired
        int year = _job.getDate().get(Calendar.YEAR);
        int month = _job.getDate().get(Calendar.MONTH);
        int dayOfMonth = _job.getDate().get(Calendar.DAY_OF_MONTH);
        String date = String.valueOf(month+1);
        date += "/" + String.valueOf(dayOfMonth);
        date += "/" + String.valueOf(year);
        _anchorPane.setDate(date);
	}

}

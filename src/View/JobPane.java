package View;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
public class JobPane
{
	
	AnchorPane anchorPane;
	Label nameText;
	Label desText;
	Label dateText;
	AnchorPane _priority;
	
	public JobPane()
	{
		anchorPane = new AnchorPane();
		anchorPane.setPrefWidth(430.0);
		anchorPane.setPrefHeight(40);
		
		_priority = new AnchorPane();
		_priority.setPrefHeight(anchorPane.getPrefHeight());
		_priority.setPrefWidth(10);
		_priority.setLayoutX(400);
		_priority.setLayoutY(2.0);
		
		
		
		nameText = new Label("NameHere");
		desText = new Label("DescriptionHere");
		dateText = new Label("Due Date: ");
		
		nameText.setLayoutX(5.0);
		nameText.setLayoutY(0);
		desText.setLayoutX(5.0);
		desText.setLayoutY(15.0);
		dateText.setLayoutX(50);
		dateText.setLayoutY(0);
		anchorPane.getChildren().addAll(_priority,nameText,desText,dateText);
		anchorPane.setStyle("-fx-border-color: #e2e2e2");
	}
	
	public AnchorPane getAnchorPane()
	{
		return anchorPane;
	}
	
	public void setName(String name)
	{
		nameText.setText(name);
	}
	
	public void setDescription(String description)
	{
		desText.setText(description);
		
	}
	
	public void setPriority(String priority)
	{
		_priority.setStyle("-fx-background-color: GREEN");
		if(priority.equals("High"))
			_priority.setStyle("-fx-background-color: RED");
		if(priority.equals("Medium"))
			_priority.setStyle("-fx-background-color: ORANGE");;
	}
	
	
	public void setDate(String date)
	{
		dateText.setText(date);
	}
	
	public void setAnchorPane(AnchorPane pane)
	{
		anchorPane = pane;
	}
	
}

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
	RadioButton _priority;
	
	public JobPane()
	{
		anchorPane = new AnchorPane();
		anchorPane.setPrefWidth(400.0);
		anchorPane.setPrefHeight(75.0);
		_priority = new RadioButton("");
		_priority.setSelected(true);
		_priority.setDisable(true);
		_priority.setContentDisplay(ContentDisplay.LEFT);
		Label _name = new Label("Name: ");
		Label _description = new Label("Description: ");
		Label _date = new Label("Due: ");
		
		nameText = new Label("NameHere");
		desText = new Label("DescriptionHere");
		dateText = new Label("Due Date: ");
		
		_name.setLayoutX(5.0);
		_name.setLayoutY(0);
		_description.setLayoutY(30.0);
		_description.setLayoutX(5.0);
		_date.setLayoutY(45.0);
		_date.setLayoutX(5.0);
		
		
		_priority.setLayoutX(280);
		_priority.setLayoutY(10);
		
		nameText.setLayoutX(_name.getLayoutX()+48.0);
		nameText.setLayoutY(_name.getLayoutY());
		desText.setLayoutX(_description.getLayoutX()+83.0);
		desText.setLayoutY(_description.getLayoutY());
		dateText.setLayoutX(_date.getLayoutX() + 45);
		dateText.setLayoutY(_date.getLayoutY());
		anchorPane.getChildren().addAll(_name,_description,_priority, _date,nameText,desText,dateText);
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
		_priority.setText(priority);
		if(priority.equals("Low"))
		{
			_priority.getStyleClass().add("red-radio-button");
		}
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

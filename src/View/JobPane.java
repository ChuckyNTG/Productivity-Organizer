package View;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
public class JobPane
{
	
	AnchorPane anchorPane;
	Label nameText;
	Label desText;
	Label prioText;
	Label dateText;
	
	public JobPane()
	{
		anchorPane = new AnchorPane();
		anchorPane.setPrefWidth(400.0);
		anchorPane.setPrefHeight(50.0);
		Label _name = new Label("Name:");
		Label _description = new Label("Description:");
		Label _priority = new Label("Priority:");
		Label _date = new Label("Due:");
		
		nameText = new Label("NameHere");
		desText = new Label("DescriptionHere");
		prioText = new Label("PriorityHere");
		dateText = new Label("Due Date: ");
		
		_name.setLayoutX(5.0);
		_name.setLayoutY(0);
		_description.setLayoutY(20.0);
		_description.setLayoutX(5.0);
		_date.setLayoutY(35.0);
		_date.setLayoutX(5.0);
		
		
		_priority.setLayoutX(300);
		_priority.setLayoutY(0);
		
		nameText.setLayoutX(_name.getLayoutX()+45.0);
		nameText.setLayoutY(_name.getLayoutY());
		desText.setLayoutX(_description.getLayoutX()+80.0);
		desText.setLayoutY(_description.getLayoutY());
		prioText.setLayoutX(_priority.getLayoutX()+50.0);
		prioText.setLayoutY(_priority.getLayoutY());
		dateText.setLayoutX(_date.getLayoutX() + 45);
		dateText.setLayoutY(_date.getLayoutY());
		anchorPane.getChildren().addAll(_name,_description,_priority, _date,nameText,desText,prioText,dateText);
		
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
		prioText.setText(priority);
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

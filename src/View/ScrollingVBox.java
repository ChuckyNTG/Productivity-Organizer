package View;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ScrollingVBox 
{
	VBox content;
	ScrollPane scroller;
	
	
	public ScrollingVBox()
	{
		content = new VBox(5);
		scroller = new ScrollPane(content);
		scroller.setFitToWidth(true);
	}
	
	//get the scrollingPane
	public ScrollPane getScroller()
	{
		return scroller;
	}
	
	//Get vertical box
	public VBox getContent()
	{
		return content;
	}
}

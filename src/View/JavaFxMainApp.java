package View;

import Model.Model;
import Model.Job;
import com.sun.org.apache.xpath.internal.operations.Mod;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;


public class JavaFxMainApp extends Application
{
	Model _model = new Model();
	ScrollingVBox sVBox = new ScrollingVBox();
	SplitMenuButton menuButton;
	ObservableMap<JobPane,Job> anchors;
	static File toLoad = null;

	
	@Override
	public void start(Stage primaryStage) 
	{
		Model.backup = new Model(_model);
		//Title setup and menu item setup
		if(toLoad != null) {
			Model.backup.loadFile(toLoad);
		}
		_model = new Model(Model.backup);
		Label title = new Label("Productivity Organizer");
		title.setLayoutX(100.0);
		Button addButton = new Button("Add");
		Button searchButton = new Button("Search");
        searchButton.setLayoutY(25);
		MenuItem priority = new MenuItem("Priority");
		priority.setOnAction(e-> {
			menuButton.setText("Priority");
			if(!isEmpty())
			{
				_model.sort("priority");
				this.removeAndReAdd();
			}
				System.out.println("Sort by priority");
		});
		MenuItem dueDate = new MenuItem("Due Date");
		dueDate.setOnAction(e-> {
			menuButton.setText("Due Date");
			if(!isEmpty())
			{
				_model.sort("date");
				this.removeAndReAdd();
			}
			System.out.println("Sort by Due Date");
		});
		MenuItem name = new MenuItem("Name(Alphabetical)");
		name.setOnAction(e-> {
			menuButton.setText("Name(Alphabetical)");
			if(!isEmpty())
			{
				_model.sort("name");
				this.removeAndReAdd();
			}
			System.out.println("Sort by Name(Alphabetical)");
		});
		
		
		
		//Adding menu buttons
		menuButton = new SplitMenuButton(priority,dueDate,name);
		menuButton.setText("None");
		menuButton.setLayoutX(62);
		menuButton.setLayoutY(74);
		//keep track of jobs
		anchors = FXCollections.observableHashMap();
		
		//Clear all button
		Button clearAll = new Button("Clear");
		clearAll.setLayoutX(300);
		clearAll.setLayoutY(50);
		clearAll.setOnAction(e->
		{
			sVBox.getContent().getChildren().clear();
			sVBox.getContent().getChildren();
			_model.clear();
		});
		
		//Create control panel for the top
		AnchorPane head = new AnchorPane();
		head.setPrefHeight(50.0);
		head.getChildren().addAll(title,addButton,searchButton,menuButton,clearAll);
		
		//Create control for adding a job
		addButton.setOnAction(e-> {
			//Get a new add job panel
			AddJob addJob = new AddJob(_model);

			//Display the panel
			addJob.display();
			//if the window was closed by adding the job
			if(addJob.getWindowClosed())
			{
				//Get the job pane
				JobPane jobPane = addJob.getJobPane();
				
				//Create some items to put on it
				MenuItem edit = new MenuItem("Edit");
				MenuItem remove = new MenuItem("Remove");
				
				//What happens when the remove button it pressed
				remove.setOnAction(evt -> {
					//Remove the association between the job and job pane
					anchors.remove(jobPane);
					//Remove the job from the model
					_model.remove(addJob.getJob());
					//Do not display it
					sVBox.getContent().getChildren().remove(jobPane.getAnchorPane());
				});
				
				//Create a split menu
				SplitMenuButton splitMenu = new SplitMenuButton(edit,remove);
				splitMenu.setText("Options");
				splitMenu.setLayoutX(300);
				splitMenu.setLayoutY(20);
				
				//What happens when you click edit (change it)
				edit.setOnAction(evnt->{
					//open the change job pane
					ChangeJob changeJob = new ChangeJob(_model,anchors.get(jobPane));
					changeJob.display();
					
					if(changeJob.getWindowClosed())
					{
						//Get the index of the job pane to change
						int index = sVBox.getContent().getChildren().indexOf((jobPane.getAnchorPane()));
						sVBox.getContent().getChildren().remove(jobPane.getAnchorPane());
						//Remove it
						anchors.remove(jobPane);
						//Set the anchor pane of the new job pane
						jobPane.setAnchorPane(changeJob.getAnchorPane().getAnchorPane());
						jobPane.getAnchorPane().getChildren().add(splitMenu);
						anchors.put(jobPane, addJob.getJob());
						//display it where the old one was
						sVBox.getContent().getChildren().add(index,jobPane.getAnchorPane());
					}
				});
				jobPane.getAnchorPane().getChildren().add(splitMenu);
				anchors.put(jobPane,addJob.getJob());
				sVBox.getContent().getChildren().add(jobPane.getAnchorPane());
			}
		});
		//Click on add
		//Open the add job window
		//Store the information in the add job window
		//Return here
		//Access the information
		//Display the information


        searchButton.setOnAction(e ->{
            Search sort = new Search(Model.backup, this);
            sort.display();
        });
		
		
		BorderPane root = new BorderPane(sVBox.getScroller(),head,null,null,null);
		
		Scene scene = new Scene(root,400,400);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	    removeAndReAdd();
	}
	
	
	public boolean isEmpty()
	{
		return _model.getList().isEmpty();
	}
	
	public void changeJob()
	{
		
		
	}
	
	public void removeAndReAdd()
	{
		//Create new add job
		
		//Clear all content
		sVBox.getContent().getChildren().clear();
		//clear the saves
		anchors.clear();
		
		for(int i=0;i<_model.getList().size();i++)
		{
			AddJob addJob = new AddJob(_model);
			addJob.setJob(i);
			addJob.addJob();
			JobPane anchorPane = addJob.getJobPane();

			MenuItem edit = new MenuItem("Edit");
			MenuItem remove = new MenuItem("Remove");
			remove.setOnAction(evt -> {
				anchors.remove(anchorPane);
				_model.remove(addJob.getJob());
				sVBox.getContent().getChildren().remove(anchorPane.getAnchorPane());
			});
			SplitMenuButton splitMenu = new SplitMenuButton(edit,remove);
			splitMenu.setText("Options");
			splitMenu.setLayoutX(300);
			splitMenu.setLayoutY(20);
			edit.setOnAction(evnt->{
				ChangeJob changeJob = new ChangeJob(_model,anchors.get(anchorPane));
				changeJob.display();
				if(changeJob.getWindowClosed())
				{
					int index = sVBox.getContent().getChildren().indexOf((anchorPane.getAnchorPane()));
					sVBox.getContent().getChildren().remove(anchorPane.getAnchorPane());
					anchors.remove(anchorPane);
					anchorPane.setAnchorPane(changeJob.getAnchorPane().getAnchorPane());
					anchorPane.getAnchorPane().getChildren().add(splitMenu);
					anchors.put(anchorPane, addJob.getJob());
					sVBox.getContent().getChildren().add(index, anchorPane.getAnchorPane());
				}
			});
			anchorPane.getAnchorPane().getChildren().add(splitMenu);
			anchors.put(anchorPane,addJob.getJob());
			sVBox.getContent().getChildren().add(anchorPane.getAnchorPane());
		}
	}
	
	
	
	 public static void main(String[] args) {
		 if (args.length > 0 && args[0].length() > 0) {
			 String fileLocation = args[0];
			 File file = new File(fileLocation);
			 if (file.exists())
				 toLoad = file;
			 else {
				 System.out.println("File not found: " + fileLocation);
			 }
		 }
		launch(args);


	 }
	

}

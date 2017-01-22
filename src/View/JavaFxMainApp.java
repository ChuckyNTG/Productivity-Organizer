package View;

import Model.Model;
import Model.Job;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;


public class JavaFxMainApp extends Application
{
	private Stage primaryStage;
	private BorderPane mainScreen;

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Productivity Organizer");
		
		initRootLayout();
		
		showTasks();
	}
	
	private void initRootLayout()
	{
		try
		{
			//Load the fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(JavaFxMainApp.class.getResource("MainScreenBP.fxml"));
			mainScreen = (BorderPane) loader.load();
			
			//Show the scene containing the root layout
			Scene scene = new Scene(mainScreen);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void showTasks()
	{
		try
		{
			//Load the fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(JavaFxMainApp.class.getResource("TaskList_BP.fxml"));
			AnchorPane taskList = (AnchorPane) loader.load();
			
			//set the task list
			mainScreen.setCenter(taskList);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	private void addTask()
	{
		try
		{
			//Load the fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(JavaFxMainApp.class.getResource("Task_AP.fxml"));
			AnchorPane taskList = (AnchorPane) loader.load();
			
			//set the task list
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public Stage getPrimaryStage()
	{
		return primaryStage;
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
}
	

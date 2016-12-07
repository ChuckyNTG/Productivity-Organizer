package View;

import Model.Model;
import Model.Filter;
import Model.Job;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;


/**
 * Created by anthony on 12/6/16.
 */
public class Search {
    JavaFxMainApp mainApp = null;
    Model backup;

    public Search(Model backup, JavaFxMainApp mainApp){
        this.mainApp = mainApp;
        this.backup = backup;
    }

    public void display(){
        Label test = new Label("test");
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefWidth(400.0);
        anchorPane.setPrefHeight(50.0);


        TitledPane priorityPane = new TitledPane();
        priorityPane.setExpanded(true);
        priorityPane.setCollapsible(false);
        priorityPane.setText("Minimum Priority");
        anchorPane.getChildren().add(priorityPane);
        priorityPane.setPrefWidth(400.0);
        priorityPane.setPrefHeight(50);
        ToggleGroup group = new ToggleGroup();
        RadioButton low = new RadioButton("Low");
        low.setToggleGroup(group);
        low.setLayoutX(0);
        low.setLayoutY(0);
        RadioButton medium = new RadioButton("Medium");
        medium.setToggleGroup(group);
        medium.setLayoutX(70);
        medium.setLayoutY(0);
        RadioButton high = new RadioButton("High");
        high.setToggleGroup(group);
        high.setLayoutX(164);
        high.setLayoutY(0);
        final String[] priority = {"Low"};

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {

            @Override
            public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2)
            {
                RadioButton selected = (RadioButton)arg2.getToggleGroup().getSelectedToggle();
                priority[0] = (selected == null) ? "Low" : selected.getText();
                System.out.println(priority[0]);
            }

        });
        AnchorPane priorities = new AnchorPane();
        priorities.getChildren().add(low);
        priorities.getChildren().add(medium);
        priorities.getChildren().add(high);
        String css = this.getClass().getResource("cssstyling.css").toExternalForm();
		priorities.getStylesheets().add(css);
        priorities.setStyle("-fx-background-color: #1d1d1d");
        priorityPane.setContent(priorities);
       

        TitledPane keywordFrame = new TitledPane();
        keywordFrame.setExpanded(true);
        keywordFrame.setCollapsible(false);
        keywordFrame.setText("Keyword");
        keywordFrame.setLayoutY(50);
        TextField keyWordField = new TextField();
        keyWordField.setPrefWidth(400);
        keywordFrame.setPrefHeight(50);
        keywordFrame.setContent(keyWordField);


        System.out.println(priorityPane.getBoundsInLocal().getHeight());
        anchorPane.getChildren().add(keywordFrame);
        String css1 = this.getClass().getResource("cssstyling.css").toExternalForm();
		anchorPane.getStylesheets().add(css1);
		anchorPane.setStyle("-fx-background-color: #1d1d1d");

        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        Button searchButton = new Button();
        searchButton.setLayoutY(115);
        searchButton.setLayoutX(165);
        searchButton.setText("Search");
        searchButton.setOnAction(e ->{
            int priorityNumber = 1;
            if(priority[0].equalsIgnoreCase("Medium"))
                priorityNumber = 2;
            if(priority[0].equalsIgnoreCase("High"))
                priorityNumber = 3;
            Filter priorityFilter = new Filter.RangeFilter("priority", priorityNumber, 3 );

            Filter keyWordFilter = new Filter.KeywordFilter(null, keyWordField.getText());
            System.out.println(keyWordField.getText());

            Filter[] filters = {keyWordFilter, priorityFilter};

            ArrayList<Job> results = backup.sort(null, filters);
            System.out.println(results.size() + " results");
            for(Job j : results)
                System.out.println(j);
            mainApp._model = new Model(results);
            mainApp.removeAndReAdd();
            stage.close();
        });


        anchorPane.getChildren().add(searchButton);
        stage.show();


    }
}

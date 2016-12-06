package View;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * Created by anthony on 12/6/16.
 */
public class Search {
    public void display(){
        Label test = new Label("test");
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefWidth(400.0);
        anchorPane.setPrefHeight(50.0);
        anchorPane.getChildren().add(test);
        TitledPane titlePane = new TitledPane();
        titlePane.setText("Search");
        titlePane.setContent(anchorPane);
        

        Scene scene = new Scene(titlePane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}

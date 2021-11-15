/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jordan Snoap
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

/*
PSEUDOCODE GENERAL IDEA: This is the class that is called to load the app up properly.
It allows for displaying of the initial screen after launching the app.
 */
public class HelloApplication extends Application {

    // Method is used to load up the proper .fxml screen to display initially
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TaskListScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setTitle("Todo List Application");
        stage.setScene(scene);
        stage.show();
    }

    // Method launches the application
    public static void main(String[] args) {
        // Creates example load file in correct directory
        File file = new File("src/main/java/ucf/assignments/listContent.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        launch();
    }
}
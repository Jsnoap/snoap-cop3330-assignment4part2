/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jordan Snoap
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/*
PSUEDOCODE GENERAL IDEA: The main functionality of the "HelpScreenController" Class is to allow the proper
functioning of the button to return back to the to do list screen. It also provides helpful information
to the user about how to operate the application.
 */
public class HelpScreenController {
    // These are the variables/attributes that make up this Class and will be referred to in the implementation of the code later
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    public Label welcomeText;
    @FXML
    public Button returnButton;

    // Occurs on click of "Return to To Do List" button
    public void continueToTaskListScreen(ActionEvent actionEvent) throws IOException {
        /*
        This is prompted when the "Return to To Do List" button is clicked, so it should progress the user to the
        to do list screen
         */
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TaskListScreen.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

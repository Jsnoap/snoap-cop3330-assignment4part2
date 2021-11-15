/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jordan Snoap
 */

package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;


/*
PSEUDOCODE GENERAL IDEA: The "Task" class gives the project a place to refer to, to create task messages for displaying.
The main components of the class are getters and setters that give the task its date, description, and completion checkBox.
This class will work with the "TaskListController" to give functionality to the "TaskListScreen"
 */
public class Task {

    // These are the variables/attributes that make up this Class and will be referred to in the implementation of the code
    private SimpleStringProperty description;
    private SimpleStringProperty date;
    private CheckBox completion;

    // Constructor for the Class
    public Task(String description, String date, String completion) {
        this.description = new SimpleStringProperty(description);
        this.date = new SimpleStringProperty(date);
        this.completion = new CheckBox(completion);
    }

    // ***The following functions are simply getters and setters for the attributes***
    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description = new SimpleStringProperty(description);
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date = new SimpleStringProperty(date);
    }

    public CheckBox getCompletion() {
        return completion;
    }

    public void setCompletion(CheckBox completion) {
        this.completion = completion;
    }
}

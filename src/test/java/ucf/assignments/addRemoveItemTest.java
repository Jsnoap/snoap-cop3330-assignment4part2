/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jordan Snoap
 */

package ucf.assignments;

import static org.junit.jupiter.api.Assertions.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

// This test case tests behaviors of adding and removing from the to do list!
public class addRemoveItemTest {

    @Test
    public void addingTask() {
        /*
        This test case will test the ability of the App to add a task to the TableView.
        This will be done by passing in the parameters to make a task such as the description and due date
        and then comparing the task created in a String form using the processing functions.
         */
        assertEquals("Finish Project 2021-11-15",TaskListController.checkValuesAdded("Finish Project","2021-11-15"));
    }
    @Test
    public void removingTask() {
        /*
        This test case will test the ability of the App to remove a task from the TableView.
        This case creates an ObservableList and then sends it to the removedTask method which
        is used in the program to determine if values have been properly removed.
        Will return true if empty
         */
        ObservableList<Task> example = FXCollections.observableArrayList();
        assertTrue(TaskListController.removedTask(example));
    }

}

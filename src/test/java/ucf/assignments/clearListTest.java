/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jordan Snoap
 */

package ucf.assignments;

import static org.junit.jupiter.api.Assertions.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

// This test case tests the ability of the app to remove all entries from the table
public class clearListTest {

    @Test
    public void clearList()
    {
        /*
        This test case will test the ability of the App to remove all tasks from the TableView.
        This case creates an ObservableList and then sends it to the checkIfEmpty method which
        is used in the program to determine if ALL values have been properly removed.
        Will return true if empty.
         */
        ObservableList<Task> example = FXCollections.observableArrayList();
        assertTrue(TaskListController.checkIfEmpty(example));
    }
}

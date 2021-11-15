/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jordan Snoap
 */

package ucf.assignments;

import static org.junit.jupiter.api.Assertions.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

// This test case tests behaviors of loading and saving to do lists from the app!
public class saveLoadSingleListTest {
    @Test
    public void saveSingleList() throws IOException {
        /*
        This test case should test the ability of the app to save all tasks of a given list.
        This is done by creating a temp file and passing it to a function to check the ability
        of the app to save. If the file exists, this test passes.
         */

        File savedFile = File.createTempFile("myTempFile", ".txt");

        assertTrue(TaskListController.checkSave(savedFile));

    }
    @Test
    public void loadSingleList() {
        /*
        This test case tests the ability of app to load a previous list that was saved.
        This will be done by creating an ObservableList and passing it to the load function.
        It will return true if values have been loaded into the list
         */
        ObservableList<Task> example = FXCollections.observableArrayList();
        assertTrue(TaskListController.checkProperLoad(example));
    }
}

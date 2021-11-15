/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jordan Snoap
 */

package ucf.assignments;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// This test case tests behaviors of editing the description and the date of a task!
public class editDescriptionDueDateTest {

    @Test
    public void editDesc() {
        /*
        This test case tests the ability of the App to edit the description of a task.
        This is done by using the simulateEditDesc method which shows how the editing of a description works in the App.
        An old value will be adjusted to a new value and compared to a String of what that new value should be.
         */
        assertEquals("Finish Homework", TaskListController.simulateEditDesc("Finish Homeworm","Finish Homework"));
    }

    @Test
    public void editDate() {
        /*
        This test case tests the ability of the App to edit the date of a task.
        This is done by using the simulateEditDate method which shows how the editing of a date works in the App.
        An old value will be adjusted to a new value and compared to a String of what that new value should be.
         */
        assertEquals("2021-11-15", TaskListController.simulateEditDate("2020-12-16","2021-11-15"));
    }
}

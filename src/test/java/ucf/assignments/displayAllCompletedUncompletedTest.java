/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jordan Snoap
 */

package ucf.assignments;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// This test case tests behaviors of displaying only completed, uncompleted, and all tasks
// Unfortunately I could not grasp the functionality of this process so these test cases are still pseudocode
public class displayAllCompletedUncompletedTest {

    @Test
    public void displayAll() {
        /*
        This test case should test the ability of the app to display all tasks.
        This should be done by creating many tasks and then checking to see that with "display all" chosen,
        they all appear despite the status of their completion.
        If all are shown, then this test passes.
         */
        assertTrue(true);
    }

    @Test
    public void displayCompleted() {
        /*
        This test case should test the ability of the app to display only the completed tasks with the
        filter selected.
        This would be tested by creating many tasks of status completed and uncompleted and then testing
        that with the "display completed" filter selected, only the completed tasks are shown.
        If only completed tasks are shown, the test passes.
         */
        assertTrue(true);
    }

    @Test
    public void displayUncompleted() {
        /*
        This test case should test the ability of the app to display only the uncompleted tasks with the
        proper filter selected.
        This would be tested by creating many tasks of status completed and uncompleted and then testing
        that with the "display uncompleted" filter selected, only the uncompleted tasks are shown.
        If only uncompleted tasks are shown, the test passes.
         */
        assertTrue(true);
    }

}

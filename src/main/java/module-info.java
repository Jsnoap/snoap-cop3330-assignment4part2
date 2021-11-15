/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jordan Snoap
 */

// This java package is needed for the functionality of the project
// requires the needed .fxml modules and allows the code to function properly with javafx.
module ucf.assignments {
    requires javafx.controls;
    requires javafx.fxml;


    opens ucf.assignments to javafx.fxml;
    exports ucf.assignments;
}
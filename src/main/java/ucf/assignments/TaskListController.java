/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jordan Snoap
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

/*
PSEUDOCODE GENERAL IDEA: The "TaskListController" Class links with the "TaskListScreen" .fxml file and allows
for all of the functionality associated with creating an individual "To do" list.
This includes methods to save a list, load a list, add a task (description + date),
edit a task (description + date), remove a list, mark a task as completed/uncompleted, filter tasks with status
of completed/uncompleted, and go to the "HelpScreen"
This will implement the "Task" class to aid in accomplishing these functions
 */
public class TaskListController implements Initializable {

    // These are the variables/attributes that make up this Class and will be referred to in the implementation of the code later
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    public Button help;
    @FXML
    public Label welcomeText;
    @FXML
    public TableView<Task> taskTable;
    @FXML
    public TableColumn<Task,String> descriptionColumn;
    @FXML
    public TableColumn<Task,String> dateColumn;
    @FXML
    public TableColumn<Task,String> completionColumn;
    @FXML
    public Button clearTasks;
    @FXML
    public Button addButton;
    @FXML
    public DatePicker datePicker;
    @FXML
    public TextField taskText;
    @FXML
    public Pane goBack;
    @FXML
    public MenuItem saveIndividualList;
    @FXML
    public MenuItem loadIndividualList;
    @FXML
    public Button removeTask;
    @FXML
    public MenuItem allTasksShown;
    @FXML
    public MenuItem completedTasksShown;
    @FXML
    public MenuItem uncompletedTasksShown;

    // Similar to ArrayList but allows for more functionality in this case to track changes to the task
    public ObservableList<Task> list = FXCollections.observableArrayList();

    // FileChooser will be used to implement save and load functionalities for all items of an individual list
    public FileChooser fileChooser = new FileChooser();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // These statements set up the columns for the TableView
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
        completionColumn.setCellValueFactory(new PropertyValueFactory<>("Completion"));

        taskTable.setItems(list);

        taskTable.setEditable(true);
        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dateColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        // Path to load/save files (example load file "listContent.txt")
        fileChooser.setInitialDirectory(new File("src/main/java/ucf/assignments"));
    }

    public void helpScreenButtonClicked(ActionEvent actionEvent) throws IOException {
        /*
        This method is linked with the "Help" button on the "TaskListScreen" and it will let the
        user return to the "HelpScreen" when they desire.
         */
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HelpScreen.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public boolean saveButtonClicked(ActionEvent actionEvent) {
        /*
        This function is called when the "Save" button is clicked from the menu bar of the app.
        It should prompt the opening of the Save dialogue and allow the user to save their lists.
        It will save the file and return true if completed successfully.
        This save button will save the list that is currently displayed on the "TaskListScreen"
         */

        fileChooser.setTitle("Save Dialog");
        fileChooser.setInitialFileName("savingFile");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file","*.txt"));

        // This code opens the save dialogue and allows user to name it
        File file = fileChooser.showSaveDialog(new Stage());
        checkSave(file);
        fileChooser.setInitialDirectory(file.getParentFile());

        ObservableList<Task> list = taskTable.getItems();

        return true;
    }

    // This method is used to test if a file has been created with the save file method
    public static boolean checkSave(File fileSave){
        return fileSave.exists();
    }

    public boolean loadButtonClicked(ActionEvent actionEvent) throws FileNotFoundException {
        /*
        This function is called when the "Load" button is clicked from the menu bar of the app.
        It should prompt the opening of the Load dialogue and allow the user to load their past lists.
        It will load the file and return true if completed successfully.
        This load button will load a singular list and its tasks that was previously displayed and saved.
         */

        fileChooser.setTitle("Load Dialog");
        // This line of code opens the load dialogue
        File file = fileChooser.showOpenDialog(new Stage());

        // Loads saved data into the TableView when file is selected
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();

                String[] splitByComma = line.split(",");

                Task task = new Task(splitByComma[0],splitByComma[1],splitByComma[2]);
                taskTable.getItems().add(task);
            }
        }
        ObservableList<Task> list = taskTable.getItems();
        checkProperLoad(list);

        return true;
    }

    // Checks if any loaded items have been added to the ObservableList/TableView after load function
    public static boolean checkProperLoad(ObservableList<Task> check)
    {
        return check.size() == 0;
    }


    public void addTaskButtonClicked(ActionEvent actionEvent) {
         /*
        This function will use the "Task" class and add the date and description to the ObservableList
        to show on the screen. When the user clicks the "Add Task" button after entering in what they desire,
        this method will be triggered to show what they set.
        It will return a String of the task message that it output to the screen.
         */

        String date = String.valueOf(datePicker.getValue());
        String taskDesc = taskText.getText();
        Task task = new Task(taskDesc,date,"");
        checkValuesAdded(taskDesc,date);

        // Gets the user added items and adds them to the TableView
        taskTable.getItems().add(task);
    }

    // Method does the processing work for creating a task to add to the list
    public static String checkValuesAdded(String description, String dueDate){

        return description + " " + dueDate;
    }

    public boolean removeTaskButtonClicked(ActionEvent actionEvent) {
        /*
        This method will be linked with the red text "Remove Task" button on the "TaskListScreen".
        It will also use the "Task" class and will be able to delete a past entry including its
        description and date that was set.
        It should return true if the previous entry that was attempting to be deleted is no longer shown.
         */
        ObservableList<Task> allTasks,removeSingleTask;

        allTasks = taskTable.getItems();
        removeSingleTask = taskTable.getSelectionModel().getSelectedItems();
        removeSingleTask.forEach(allTasks::remove);
        // used for testing
        removedTask(removeSingleTask);

        return true;
    }

    // Checks if ObservableList is empty to know if values have been removed
    public static boolean removedTask(ObservableList<Task> removed)
    {
        return removed.size() == 0;
    }


    // This method removes all of the rows from the TableView when the "Clear Tasks" button is pressed.
    public void clearTasksButtonClicked(ActionEvent actionEvent) {
        taskTable.getItems().clear();

        // Pass over to function to check if TableView is empty
        ObservableList<Task> testCheck = taskTable.getItems();
        checkIfEmpty(testCheck);
    }

    // method returns true if the TableView has truly been cleared
    public static boolean checkIfEmpty(ObservableList<Task> tester)
    {
        return tester.size() == 0;
    }

    // Allows the task description to be editable in the table
    public void editTaskDescription(TableColumn.CellEditEvent<Task, String> taskStringCellEditEvent) {
        // Get index of changed value
        Task task = taskTable.getSelectionModel().getSelectedItem();
        simulateEditDesc(taskStringCellEditEvent.getOldValue(),taskStringCellEditEvent.getNewValue());
        task.setDescription(taskStringCellEditEvent.getNewValue());
    }

    // This method is used for testing and shows how the app processes changing descriptions
    public static String simulateEditDesc(String oldValue, String newValue) {
        oldValue = newValue;

        return oldValue;
    }

    // Allows the task date to be editable in the table
    public void editDate(TableColumn.CellEditEvent<Task, String> taskLocalDateCellEditEvent) {
        Task task = taskTable.getSelectionModel().getSelectedItem();
        simulateEditDesc(taskLocalDateCellEditEvent.getOldValue(),taskLocalDateCellEditEvent.getNewValue());
        task.setDate(taskLocalDateCellEditEvent.getNewValue());
    }

    // This method is used for testing and shows how the app processes changing dates
    public static String simulateEditDate(String oldValue, String newValue) {
        oldValue = newValue;

        return oldValue;
    }


    public int allTasksDisplayedChosen(ActionEvent actionEvent) {
        /*
        This task will be linked with the Split Menu Button in the "TaskListScreen".
        It will be used to display all tasks in the list when the all option is selected.
        It should be compatible with the "Mark/Unmark Complete" button to know what to show.
        It will return an int of the amount of lists that fall in this category.
         */
        return 1;
    }

    public int completedTasksDisplayedChosen(ActionEvent actionEvent) {
        /*
        This task will be linked with the Split Menu Button in the "TaskListScreen".
        It will be used to display all completed tasks in the list when the completed option is selected.
        It should be compatible with the "Mark/Unmark Complete" button to know what to show.
        It will return an int of the amount of lists that fall in this category.
        This int value plus the value from the uncompleted tasks option should sum to the all tasks option int
        value.
         */
        return 1;
    }

    public int uncompletedTasksDisplayedChosen(ActionEvent actionEvent) {
        /*
        This task will be linked with the Split Menu Button in the "TaskListScreen".
        It will be used to display all uncompleted tasks in the list when the uncompleted option is selected.
        It should be compatible with the "Mark/Unmark Complete" button to know what to show.
        It will return an int of the amount of lists that fall in this category.
        This int value plus the value from the completed tasks option should sum to the all tasks option int
        value.
         */
        return 1;
    }
}
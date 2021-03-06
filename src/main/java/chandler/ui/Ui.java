package chandler.ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import chandler.ChandlerException;
import chandler.TaskList;
import chandler.task.Task;

/**
 *  The Ui class encapsulates methods to handle text displays to the CLI.
 */
public class Ui {
    private static final String PADDING = "  ";

    /**
     * Returns the chatbot's greeting message when a user starts the chatbot.
     */
    public String returnGreeting() {
        return "Hello! I'm Chandler, here to help you keep track of measly tasks"
                + " in your mundane human life. How may I help you today?";
    }

    /**
     * Returns an error message in a string when a user inputs a command that has not been programmed.
     *
     * @return String containing error message of invalid command.
     */
    public String invalidCmdError() {
        return "Sorry human, I have not been trained to process that command.";
    }

    /**
     * Returns an error message in a string when the saved data file is unable to be read.
     *
     * @return String containing error message of reading from saved data file.
     */
    public String corruptFileDataError() {
        return "Saved data file corrupted";
    }

    /**
     * Returns an error message in a string when the saved data file is unable to be written to.
     *
     * @return String containing error message of writing to saved data file.
     */
    public String saveDataError() {
        return "Failed to save data.";
    }

    /**
     * Returns an error message in a string when a user inputs the list command with the wrong format.
     *
     * @return String containing error message of invalid list command.
     */
    public String listCmdError() {
        return "Sorry human, I do not understand your command."
                + " To view your list, enter 'list' with no additional descriptions.";
    }

    /**
     * Returns an error message in a string when a user inputs the done command with too many parameters.
     *
     * @return String containing error message of invalid done command.
     */
    public String doneCmdTooManyArgsError() {
        return "Sorry human, please enter only one task for me to mark as complete."
                + "I am unable to process more than one task at one time.";
    }

    /**
     * Returns an error message in a string when a user inputs the done command with no parameters.
     *
     * @return String containing error message of invalid done command.
     */
    public String doneCmdNoArgsError() {
        return "Sorry human, please enter a task number.";
    }

    /**
     * Returns an error message in a string when a user inputs the done command with the wrong parameter.
     *
     * @return String containing error message of invalid done command.
     */
    public String doneCmdInvalidArgsError() {
        return "Sorry human, please enter the number of the task you want me to"
                + " mark as complete.";
    }

    /**
     * Returns an error message in a string when a user inputs the event command with the wrong format.
     *
     * @return String containing error message of invalid event command.
     */
    public String eventFormatError() {
        return "Invalid format. Please enter as such:"
                + "\n"
                + "event EVENT_NAME /at yyyy-MM-dd HHmm";
    }

    /**
     * Returns an error message in a string when a user inputs the todo command with the wrong format.
     *
     * @return String containing error message of invalid todo command.
     */
    public String todoFormatError() {
        return "Sorry human, please enter a name for this task.";
    }

    /**
     * Returns an error message in a string when a user inputs the deadline command with the wrong format.
     *
     * @return String containing error message of invalid deadline command.
     */
    public String deadlineFormatError() {
        return "Invalid format. Please enter as such:"
                + "\n"
                + "deadline TASK_NAME /by yyyy-MM-dd HHmm";
    }

    /**
     * Returns an error message in a string when a user inputs the wrong date format.
     *
     * @return String containing error message of invalid date input.
     */
    public String dateFormatError() {
        return "Invalid date format. Please enter as such:"
                + "\n"
                + "yyyy-MM-dd HHmm (e.g. 2019-10-15 1800)";
    }

    /**
     * Returns an error message in a string when a user inputs the delete command with too many parameters.
     *
     * @return String containing error message of invalid delete command.
     */
    public String deleteCmdTooManyArgsError() {
        return "Sorry human, please enter only one task for me to delete."
                + "\n"
                + "I am unable to process more than one task at one time.";
    }

    /**
     * Returns an error message in a string when a user inputs the delete command with no parameters.
     *
     * @return String containing error message of invalid delete command.
     */
    public String deleteCmdNoArgsError() {
        return "Sorry human, please enter a task number to delete.";
    }

    /**
     * Returns an error message in a string when a user inputs the delete command with invalid parameters.
     *
     * @return String containing error message of invalid delete command.
     */
    public String deleteCmdInvalidArgsError() {
        return "Sorry human, please enter the number of the task you want me to delete.";
    }

    /**
     * Returns an error message in a string when a user inputs the find command with no parameters.
     *
     * @return String containing error message of invalid find command.
     */
    public String findNoArgsError() {
        return "Sorry human, please enter a task number to find.";
    }

    /**
     * Returns an error message in a string when a user inputs a command with a task number that does not exist.
     *
     * @return String containing error message of invalid task number.
     */
    public String taskDoesNotExistError() {
        return "Sorry human, no such task seems to exist.";
    }

    /**
     * Returns error message from ChandlerException.
     *
     * @param e ChandlerException.
     */
    public String returnChandlerExceptionMsg(ChandlerException e) {
        return e.toString();
    }

    /**
     * Returns deleted task message.
     *
     * @param task Task that has just been deleted.
     * @param taskList List of all tasks.
     */
    public String returnDeletedMsg(Task task, TaskList taskList) {
        return "Task has been deleted." + "\n"
                + "Just like you will be deleted someday too." + "\n"
                + PADDING + task + "\n"
                + "Now you have " + taskList.getSize()
                + (taskList.getSize() == 1 ? " task " : " tasks ") + "in your list." + "\n";
    }

    /**
     * Returns completed task message.
     *
     * @param task Task that has just been marked as done.
     */
    public String returnDoneMsg(Task task) {
        return "Well done human on completing " + task.getTaskName() + "!" + "\n"
                + "I have marked it as done." + "\n"
                + PADDING + task + "\n";
    }

    /**
     * Returns all tasks.
     *
     * @param taskList List of all tasks.
     */
    public String returnList(TaskList taskList) {
        StringBuilder toReturn = new StringBuilder("Here are the tasks in your list:" + "\n");
        for (int i = 1; i <= taskList.getSize(); i++) {
            toReturn.append(i).append(". ").append(taskList.getIndex(i - 1)).append("\n");
        }
        return toReturn.toString();
    }

    /**
     * Returns added task to list message.
     *
     * @param task Task that has just been added to list.
     * @param taskList List of all tasks.
     */
    public String returnAddToListMsg(Task task, TaskList taskList) {
        return "Got it: I've added this task:" + "\n"
                + PADDING + task + "\n"
                + "Now you have " + taskList.getSize()
                + (taskList.getSize() == 1 ? " task " : " tasks ") + "in your list." + "\n";
    }

    /**
     * Returns the stats message.
     *
     * @param numTotalTasks The total number of tasks.
     * @param numDoneTasks The total number of done tasks.
     * @param numDoneTasksWithinWeek The total number of tasks that were completed within the past week.
     * @param numUpcomingTasksWithinWeek The total number of tasks to be completed in the next week.
     * @return
     */
    public String returnStatsMessage(int numTotalTasks, int numDoneTasks,
                                     int numDoneTasksWithinWeek, int numUpcomingTasksWithinWeek) {
        return "Here are your stats:" + "\n"
                + PADDING + "Total Tasks: " + numTotalTasks + "\n"
                + PADDING + "Total Done Tasks: " + numDoneTasks + "\n"
                + PADDING + "Done Within This Week: " + numDoneTasksWithinWeek + "\n"
                + PADDING + "Upcoming Next Week: " + numUpcomingTasksWithinWeek + "\n" + "\n"
                + "Last Updated: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd yyyy hh.mm a"));
    }

    /**
     * Returns an error message in a string when a user inputs the stats command with the wrong format.
     *
     * @return String containing error message of invalid stats command.
     */
    public String statsCmdError() {
        return "Sorry human, I do not understand your command."
                + " To view your statistics, enter 'stats' with no additional descriptions.";
    }

    /**
     * Returns goodbye message.
     */
    public String returnBye() {
        return "Bye! Hope you complete your tasks!";
    }
}

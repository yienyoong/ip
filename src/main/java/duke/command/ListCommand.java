package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * The ListCommand class encapsulates information and methods about a ListCommand.
 */
public class ListCommand implements Command {
    private String fullCmd;
    private String[] fullCmdStrArray;
    private Ui ui;

    /**
     * Create and initialize a List Command.
     *
     * @param fullCmd The full user input in String form.
     * @param ui The ui object responsible for displaying list messages to the CLI.
     */
    public ListCommand(String fullCmd, Ui ui) {
        this.fullCmd = fullCmd;
        this.fullCmdStrArray = fullCmd.split(" ");;
        this.ui = ui;
    }

    /**
     *  Processes the list command by displaying the user's list of tasks on the CLI.
     *
     * @param storage The storage object that writes data to the saved data file of tasks.
     * @param taskList The list of tasks.
     * @throws DukeException if the format of the List command is invalid.
     */
    @Override
    public void run(Storage storage, TaskList taskList) throws DukeException {
        if (fullCmdStrArray.length > 1) { // handle commands such as "list abc", "list 1 2 3"
            throw new DukeException(ui.listCmdError());
        }
        ui.printList(taskList);
    }
}
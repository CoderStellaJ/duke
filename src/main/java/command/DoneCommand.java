package command;

import exception.DukeException;
import storage.Storage;
import tasks.Task;
import tasks.TaskList;
import ui.Ui;

public class DoneCommand extends Command {
    private int number;

    public DoneCommand(int number) {
        this.number = number;
    }

    public boolean isExit() {
        return false;
    }

    /**
     * Execute done command.
     *
     * @param taskList The list of tasks maintained in duke.Duke
     * @param ui       Ui module
     * @param storage  in charge of loading and saving the tasks
     * @throws DukeException when the task doesn't exist
     */
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        StringBuilder sb = new StringBuilder("Nice! I've marked this task as done:");
        if (number > taskList.getSize()) {
            throw new DukeException("It's an invalid task");
        }
        Task doneTask = taskList.markDone(number);
        sb.append("\n" + doneTask);
        ui.print(sb.toString());
    }
}

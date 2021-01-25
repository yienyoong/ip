package duke;

import duke.task.DeadlineTask;
import duke.task.EventTask;
import duke.task.TodoTask;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TasklistTest {
    @Test
    public void addTasks_Tasks_success() {
        TaskList tl = new TaskList();
        tl.add(new TodoTask("a"));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        LocalDateTime ldt = LocalDateTime.parse("2020-01-01 1800", dtf);
        DeadlineTask dlTask = new DeadlineTask("test tasklist deadline", ldt);
        EventTask evTask = new EventTask("test tasklist event", ldt);
        tl.add(dlTask);
        tl.add(evTask);
        assertEquals(3, tl.getSize());
    }

    @Test
    public void deleteTasks_TaskListWithTasks_success() {
        TaskList tl = new TaskList();
        tl.add(new TodoTask("a"));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        LocalDateTime ldt = LocalDateTime.parse("2020-01-01 1800", dtf);
        DeadlineTask dlTask = new DeadlineTask("test tasklist deadline", ldt);
        EventTask evTask = new EventTask("test tasklist event", ldt);
        tl.add(dlTask);
        tl.add(evTask);
        tl.removeIndex(0);
        assertEquals(2, tl.getSize());
    }
}

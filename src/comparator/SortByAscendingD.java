package comparator;

import task.Task;

import java.util.Comparator;

public class SortByAscendingD implements Comparator<Task> {
    @Override
    public int compare(Task task, Task t1) {
        return Integer.compare(task.getD(), t1.getD());
    }
}

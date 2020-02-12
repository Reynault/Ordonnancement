package comparator;

import task.Task;

import java.util.Comparator;

/**
 * a comparator for tasks of a problem
 */
public class ComparatorForTasks {
    public static final Comparator<Task> sortByRatioDescending = new SortByRatioDescending();
    public static final Comparator<Task> sortByAscendingD = new SortByAscendingD();
}

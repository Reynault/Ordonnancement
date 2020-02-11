package exercice1.comparator;

import exercice1.problem.Task;

import java.util.Comparator;

/**
 * a comparator for tasks of a problem
 */
public class ComparatorForTasks {
    public static final Comparator<Task> sortByRatioDescending = new SortByRatioDescending();
}

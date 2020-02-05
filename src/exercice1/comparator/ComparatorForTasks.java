package exercice1.comparator;

import exercice1.Task;

import java.util.Comparator;

public class ComparatorForTasks {
    public static final Comparator<Task> sortByRatioDescending = new SortByRatioDescending();
}

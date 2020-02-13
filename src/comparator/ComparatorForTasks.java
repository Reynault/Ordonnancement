package comparator;

import task.Task;

import java.util.Comparator;

/**
 * Fabrique de comparateurs utilisés pour comparer des tâches entres-elles
 */
public class ComparatorForTasks {
    // trier dans l'ordre décroissant du ratio: d/w
    public static final Comparator<Task> sortByRatioDescending = new SortByRatioDescending();
    // trier dans l'ordre croissant des dates de fin
    public static final Comparator<Task> sortByAscendingD = new SortByAscendingD();
}

package comparator;

import task.Task;

import java.util.Comparator;

/**
 * Comparateur pour trier dans l'ordre décroissant du ratio: d/w
 */
public class SortByRatioDescending implements Comparator<Task> {
    @Override
    public int compare(Task task, Task t1) {
        return Double.compare(t1.getRatio(), task.getRatio());
    }
}

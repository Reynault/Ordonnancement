package exercice1.problem;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * a problem is a set of tasks to schedule
 */
public class Problem {

    private List<Task> tasks; // set of tasks
    private double cmax;      // the ending date of the project (which is simply the sum of P)

    /**
     * a problem needs:
     * @param tasks a set of tasks
     */
    public Problem(List<Task> tasks) {
        this.tasks = tasks;
        computeCmax();  // cmax is computed when creation
    }

    /**
     * method that compute the sum of weight tardiness
     * using a specific order given by a comparator.
     * @param comparator used to sort tasks
     * @return tardiness
     */
    public double getTardiness(Comparator comparator) {
        // Sorting with given comparator
        Collections.sort(tasks, comparator);
        return getTardiness();
    }

    public double getTardiness() {
        int c = 0;
        int tardiness = 0;
        // Computing tardiness
        for (Task task : tasks) {
            c += task.getP();
            if (c > task.getD()) {
                tardiness += task.getW() * (c - task.getD());
            }
        }

        return tardiness;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "tasks=" + tasks +
                '}';
    }

    public double getCmax() {
        return cmax;
    }

    private void computeCmax() {
        cmax = 0;
        for (Task t : tasks) {
            cmax += t.getP();
        }
    }
}

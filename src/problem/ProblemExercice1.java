package problem;

import machine.Machine;
import task.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * a problem is a set of tasks to schedule
 */
public class ProblemExercice1 implements Problem{

    private List<Task> tasks; // set of tasks
    private double cmax;      // the ending date of the project (which is simply the sum of P)
    private Machine machine;  // the machine that will give the solution

    /**
     * a problem needs:
     * @param tasks a set of tasks
     */
    public ProblemExercice1(List<Task> tasks) {
        this.tasks = tasks;
        this.machine = new Machine(1);
        computeCmax();  // cmax is computed when creation
    }

    public double getThingToMinimize(Comparator comparator) {
        // Sorting with given comparator
        Collections.sort(tasks, comparator);
        return getThingToMinimize();
    }

    public double getThingToMinimize() {
        return computeThingToMinimize(tasks);
    }
    /**
     * method that compute the sum of weight tardiness
     * using the machine order
     *
     * @return tardiness
     */
    public double getSolution() {
        return computeThingToMinimize(machine.getTasks());
    }

    /**
     * method that compute the sum of weight tardiness.
     * @param tasks given to compute
     * @return tardiness
     */
    public double computeThingToMinimize(List<Task> tasks){
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

    @Override
    public List<Machine> getMachines() {
        ArrayList<Machine> machines = new ArrayList<>();
        machines.add(machine);
        return machines;
    }

    @Override
    public void setMachines(List<Machine> machines) {
        this.machine = machines.get(0);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.machine.setTasks(tasks);
    }


    @Override
    public String toString() {
        return "ProblemExercice1{" +
                "tasks=" + tasks +
                '}';
    }

    public double getSumOfP() {
        return cmax;
    }

    private void computeCmax() {
        cmax = 0;
        for (Task t : tasks) {
            cmax += t.getP();
        }
    }
}

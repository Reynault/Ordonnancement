package problem;

import machine.Machine;
import task.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProblemExercice2 implements Problem {

    private List<Task> tasks;       // set of tasks
    private List<Machine> machines; // set of machines

    public ProblemExercice2(List<Task> tasks) {
        this.machines = new ArrayList<>();
        this.machines.add(new Machine(1));
        this.machines.add(new Machine(2));
        this.tasks = tasks;
    }

    @Override
    public double getThingToMinimize(Comparator comparator) {
        Collections.sort(tasks, comparator);
        return getThingToMinimize();
    }

    /**
     * Compute the maximum tardiness of a task from the set of tasks
     *
     * @return the maximum tardiness
     */
    @Override
    public double getThingToMinimize() {
        return computeThingToMinimize(tasks);
    }

    @Override
    public double computeThingToMinimize(List<Task> tasks) {
        int max = Integer.MIN_VALUE;
        int c = 0;
        for (Task t : tasks) {
            c += t.getP();
            if (t.getD() < c && max < (c - t.getD())) {
                max = c - t.getD();
            }
        }
        return max;
    }

    @Override
    public double getSolution() {
        double currentValue, max = Integer.MIN_VALUE;
        for (Machine m : machines) {
            currentValue = computeThingToMinimize(m.getTasks());
            max = (max < currentValue) ? currentValue : max;
        }
        return max;
    }

    @Override
    public List<Machine> getMachines() {
        return machines;
    }

    @Override
    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }


    @Override
    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public double getSumOfP() {
        double sum = 0;
        for (Task t : tasks) {
            sum += t.getP();
        }
        return sum;
    }
}

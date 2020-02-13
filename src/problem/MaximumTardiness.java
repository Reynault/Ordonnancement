package problem;

import machine.Machine;
import task.Task;

import java.util.List;

/**
 * Représentation du problème de minimisation
 * du plus grand retard.
 */
public class MaximumTardiness extends Problem {

    public MaximumTardiness(List<Task> tasks, int nbMachines) {
        super(tasks, nbMachines);
    }

    public double computeThingToMinimize(List<Machine> machines) {
        double value;
        double max = Integer.MIN_VALUE;
        for(Machine m :machines){
            value = m.getMaxTardiness();
            if(value > max) max = value;
        }
        return (max == Integer.MIN_VALUE) ? 0 : max;
    }
}

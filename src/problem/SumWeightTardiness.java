package problem;

import machine.Machine;
import task.Task;

import java.util.List;

/**
 * Représentation du problème de minimisation
 * de la somme pondérée des retards
 */
public class SumWeightTardiness extends Problem {

    public SumWeightTardiness(List<Task> tasks, int nbMachines) {
        super(tasks, nbMachines);
    }

    @Override
    public double computeThingToMinimize(List<Machine> machines) {
        double value = 0;
        for (Machine m: machines){
            value += m.getSumTardiness();
        }
        return value;
    }
}

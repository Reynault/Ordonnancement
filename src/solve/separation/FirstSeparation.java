package solve.separation;

import machine.Machine;
import task.Task;

import java.util.List;

/**
 * Separation qui ajoute la tâche à la première machine
 */
public class FirstSeparation extends Separation {
    @Override
    public List<Machine> separate(Task task, List<Machine> machines) {
        List<Machine> res = getNewCopy(machines);

        if (machines.size() >= 1) {
            res.get(0).addTask(task);
        }
        return res;
    }
}

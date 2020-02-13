package solve.separation;

import machine.Machine;
import task.Task;

import java.util.List;

/**
 * Separation qui ajoute la tâche à la deuxième machine
 */
public class SecondSeparation extends Separation {
    @Override
    public List<Machine> separate(Task task, List<Machine> machines) {
        List<Machine> res = getNewCopy(machines);

        if (machines.size() >= 2) {
            res.get(1).addTask(task);
        }
        return res;
    }
}

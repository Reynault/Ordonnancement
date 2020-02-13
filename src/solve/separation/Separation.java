package solve.separation;

import machine.Machine;
import task.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Un objet qui permet de lancer le processus de séparation
 */
public abstract class Separation {
    /**
     * Place une tâche dans une des machines selon l'algorithme de séparation
     * @param task la tâche à placer
     * @param machines la liste des machines
     * @return la liste des machines avec la tâche placée
     */
    public abstract List<Machine> separate(Task task, List<Machine> machines);

    List<Machine> getNewCopy(List<Machine> machines){
        List<Machine> res = new ArrayList<>();
        for(Machine m : machines){
            Machine newMachine = new Machine(m.getId());
            newMachine.setTasks(new ArrayList<>(m.getTasks()));
            res.add(newMachine);
        }
        return res;
    }
}

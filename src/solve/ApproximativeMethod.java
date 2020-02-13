package solve;

import comparator.ComparatorForTasks;
import machine.Machine;
import problem.Problem;
import solve.node.Node;
import task.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Utilisation de la méthode approximative trouvée dans la première question de l'exercice n°2
 */
public class ApproximativeMethod extends Solver {

    public ApproximativeMethod(Problem problem) {
        super(problem);
    }

    /**
     * Méthode de résolution
     * @return le problème avec la solution dans les machines. (liste des tâches dans le bon order)
     */
    @Override
    public Problem solve() {
        double endTimeM1, endTimeM2;
        List<Task> tasks = problem.getTasks();
        List<Machine> machines = problem.getMachines();

        if (machines != null && machines.size() >= 2) {
            Machine une = machines.get(0);
            Machine deux = machines.get(1);
            // on commence par trier les tâches dans l'ordre croissant de la date de fin
            Collections.sort(tasks, ComparatorForTasks.sortByAscendingD);
            // on parcours ensuite toutes les tâches pour les assigner
            for (Task t : tasks) {
                endTimeM1 = une.getEndTime();
                endTimeM2 = deux.getEndTime();
                // on place en alternance les tâches
                if ((t.getP() + endTimeM1 < endTimeM2) || (endTimeM1 < endTimeM2) || (endTimeM1 == endTimeM2)) {
                    une.addTask(t);
                } else {
                    deux.addTask(t);
                }
            }

            problem.setMachines(machines);
        }
        return problem;
    }

    //@Override
    public Node getInferiorBoundary(Node node) {
        return node;
    }
}

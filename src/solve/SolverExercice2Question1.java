package solve;

import comparator.ComparatorForTasks;
import machine.Machine;
import problem.Problem;
import task.Task;

import java.util.Collections;
import java.util.List;

public class SolverExercice2Question1 implements Solver {
    @Override
    public Problem solve(Problem problem) {
        double endTimeM1, endTimeM2;
        List<Task> tasks = problem.getTasks();
        List<Machine> machines = problem.getMachines();

        if (machines != null && machines.size() >= 2) {
            Machine une = machines.get(0);
            Machine deux = machines.get(1);

            Collections.sort(tasks, ComparatorForTasks.sortByAscendingD);

            for (Task t : tasks) {
                endTimeM1 = une.getEndTime();
                endTimeM2 = deux.getEndTime();
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
}

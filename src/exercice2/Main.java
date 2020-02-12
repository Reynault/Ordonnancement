package exercice2;

import machine.Machine;
import problem.Problem;
import problem.ProblemExercice2;
import solve.Solver;
import solve.SolverExercice2Question1;
import task.Task;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Exercice n°2\n");

        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, 3, 4, 1));
        tasks.add(new Task(2, 4, 6, 1));
        tasks.add(new Task(3, 6, 8, 1));
        tasks.add(new Task(4, 3, 7, 1));
        tasks.add(new Task(5, 2, 9, 1));
        tasks.add(new Task(6, 5, 10, 1));
        System.out.println("Tasks to schedule: ");

        for (Task task : tasks) {
            System.out.println(task);
        }

        Solver solverExercice2Question1 = new SolverExercice2Question1();
        Problem problem = new ProblemExercice2(tasks);


        problem = solverExercice2Question1.solve(problem);

        List<Machine> machines = problem.getMachines();
        System.out.println("\n---------Question n°3: ");
        System.out.println("Maximum tardiness: " + problem.getSolution());
        System.out.println("Schedule: ");
        for (Machine m : machines) {
            System.out.println("\nMachine n°" + m.getId() + ": ");
            for (Task task : m.getTasks()) {
                System.out.println(task);
            }
        }
    }
}

package exercice2;

import machine.Machine;
import problem.MaximumTardiness;
import problem.Problem;
import solve.ApproximativeMethod;
import solve.BranchAndBoundEx2;
import solve.Solver;
import task.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Execution pour les questions 1 et 3 de l'exercice 2
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Exercice n°2\n");

        // tâches à planifier
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, 3, 4, 1));
        tasks.add(new Task(2, 4, 6, 1));
        tasks.add(new Task(3, 6, 8, 1));
        tasks.add(new Task(4, 3, 7, 1));
        tasks.add(new Task(5, 2, 9, 1));
        tasks.add(new Task(6, 5, 10, 1));
        System.out.println("Tâches à planifier: ");
        // affichage des tâches
        for (Task task : tasks) {
            System.out.println(task);
        }

        // question n°1: utilisation de l'algorithme proposé dans le rapport
        Problem problem = new MaximumTardiness(new ArrayList<>(tasks), 2);
        Solver approximativeMethod = new ApproximativeMethod(problem);
        problem = approximativeMethod.solve();

        List<Machine> machines = problem.getMachines();
        System.out.println("\n---------Question n°1: ");
        System.out.println("Retard maximum: " + problem.getSolution());
        System.out.println("Planification: ");
        for (Machine m : machines) {
            System.out.println("\nmachine.Machine n°" + m.getId() + ": ");
            for (Task task : m.getTasks()) {
                System.out.println(task);
            }
        }

        // question n°3: utilisation de l'implémentation de l'algorithme branch and bound qui utilise
        // les trois propriétés
        problem = new MaximumTardiness(new ArrayList<>(tasks), 2);
        Solver branchAndBound = new BranchAndBoundEx2(problem);
        problem = branchAndBound.solve();

        machines = problem.getMachines();
        System.out.println("\n---------Question n°3: ");
        System.out.println("Retard maximum: " + problem.getSolution());
        System.out.println("Planification: ");
        for (Machine m : machines) {
            System.out.println("\nmachine.Machine n°" + m.getId() + ": ");
            for (Task task : m.getTasks()) {
                System.out.println(task);
            }
        }
    }
}

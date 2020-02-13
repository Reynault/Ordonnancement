package exercice1;

import comparator.ComparatorForTasks;
import machine.Machine;
import problem.Problem;
import problem.SumWeightTardiness;
import solve.BranchAndBoundEx1;
import task.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Execution pour les questions 1, 2 et 3 de l'exercice 1
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Exercice n°1\n");

        // tâches à planifier
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, 3, 16, 2));
        tasks.add(new Task(2, 7, 15, 3));
        tasks.add(new Task(3, 2, 9, 1));
        tasks.add(new Task(4, 3, 4, 2));
        tasks.add(new Task(5, 5, 10, 4));
        System.out.println("Tâches à planifier: ");

        // affichage des tâches
        for(Task task: tasks){
            System.out.println(task);
        }

        // question n°1: trier par ordre décroissant du ratio: d/w
        Problem problem = new SumWeightTardiness(new ArrayList<>(tasks), 1);
        double tardiness = problem.getThingToMinimize(
                ComparatorForTasks.sortByRatioDescending
        );

        System.out.println("\n---------Question n°1: ");
        System.out.println("Retard: " + tardiness);
        System.out.println("Planification: ");

        for(Task task: problem.getTasks()){
            System.out.println(task);
        }

        // question n°3: utilisation du branch and bound
        problem = new SumWeightTardiness(new ArrayList<>(tasks), 1);
        BranchAndBoundEx1 branchAndBoundEx1 = new BranchAndBoundEx1(problem);
        problem = branchAndBoundEx1.solve();
        List<Machine> machines = problem.getMachines();

        System.out.println("\n---------Question n°3: ");
        System.out.println("Retard: "+problem.getSolution());
        System.out.println("Planification: ");
        for(Task task: machines.get(0).getTasks()){
            System.out.println(task);
        }
    }
}

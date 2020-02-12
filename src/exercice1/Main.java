package exercice1;

import comparator.ComparatorForTasks;
import machine.Machine;
import problem.Problem;
import problem.ProblemExercice1;
import solve.SolverExercice1;
import task.Task;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Exercice n°1\n");

        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, 3, 16, 2));
        tasks.add(new Task(2, 7, 15, 3));
        tasks.add(new Task(3, 2, 9, 1));
        tasks.add(new Task(4, 3, 4, 2));
        tasks.add(new Task(5, 5, 10, 4));
        System.out.println("Tasks to schedule: ");

        for(Task task: tasks){
            System.out.println(task);
        }

        Problem problem = new ProblemExercice1(tasks);
        double tardiness = problem.getThingToMinimize(
                ComparatorForTasks.sortByRatioDescending
        );

        System.out.println("\n---------Question n°1: ");
        System.out.println("Tardiness: " + tardiness);
        System.out.println("Schedule: ");

        for(Task task: problem.getTasks()){
            System.out.println(task);
        }

        SolverExercice1 solverExercice1 = new SolverExercice1();
        problem = solverExercice1.solve(problem);
        List<Machine> machines = problem.getMachines();
        System.out.println("\n---------Question n°3: ");
        System.out.println("Tardiness: "+problem.getSolution());
        System.out.println("Schedule: ");
        for(Task task: machines.get(0).getTasks()){
            System.out.println(task);
        }
    }
}

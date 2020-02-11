package exercice1;

import exercice1.comparator.ComparatorForTasks;
import exercice1.problem.Problem;
import exercice1.problem.Task;
import exercice1.solver.Solver;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
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

        Problem problem = new Problem(tasks);
        double tardiness = problem.getTardiness(
                ComparatorForTasks.sortByRatioDescending
        );

        System.out.println("\n---------Question n°1: ");
        System.out.println("Tardiness: " + tardiness);
        System.out.println("Schedule: ");

        for(Task task: problem.getTasks()){
            System.out.println(task);
        }

        Solver solver = new Solver();
        problem = solver.solve(problem);
        System.out.println("\n---------Question n°3: ");
        System.out.println("Tardiness: "+problem.getTardiness());
        System.out.println("Schedule: ");
        for(Task task: problem.getTasks()){
            System.out.println(task);
        }
    }
}

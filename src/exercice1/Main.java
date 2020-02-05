package exercice1;

import exercice1.comparator.ComparatorForTasks;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, 3, 16, 2));
        tasks.add(new Task(2, 7, 15, 3));
        tasks.add(new Task(3, 2, 9,  1));
        tasks.add(new Task(4, 3, 4,  2));
        tasks.add(new Task(5, 5, 10, 4));

        Problem problem = new Problem(tasks);

        int tardiness = problem.solve(
                ComparatorForTasks.sortByRatioDescending
        );

        System.out.println("Somme des retards pondérée: "+tardiness);
    }
}

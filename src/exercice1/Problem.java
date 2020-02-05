package exercice1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem {

    private List<Task> tasks;

    public Problem(List<Task> tasks) {
        this.tasks = tasks;
    }

    public int solve(Comparator comparator) {
        // Sorting with given comparator
        Collections.sort(tasks, comparator);

        int c = 0;
        int tardiness = 0;
        // Computing tardiness
        for(Task task: tasks){
            System.out.println(task);
            c += task.getP();
            if(c > task.getD()){
                tardiness += task.getW() * (c - task.getD());
            }
        }

        return tardiness;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}

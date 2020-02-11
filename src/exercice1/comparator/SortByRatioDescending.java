package exercice1.comparator;

import exercice1.problem.Task;

import java.util.Comparator;

class SortByRatioDescending implements Comparator<Task> {
    @Override
    public int compare(Task task, Task t1) {
        int res;
        if(task.getRatio() == t1.getRatio()){
            res = 0;
        }else{
            if(task.getRatio() < t1.getRatio()){
                res = 1;
            }else{
                res = -1;
            }
        }
        return res;
    }
}

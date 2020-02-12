package machine;

import task.Task;

import java.util.ArrayList;
import java.util.List;

public class Machine {
    private List<Task> tasks;
    private int id;

    public Machine(int id) {
        tasks = new ArrayList<>();
        this.id = id;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks){
        this.tasks = tasks;
    }

    public void addTask(Task t){
        this.tasks.add(t);
    }

    public double getEndTime(){
        int time = 0;
        for (Task t: tasks){
            time += t.getP();
        }
        return time;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "tasks=" + tasks +
                '}';
    }

    public int getId() {
        return id;
    }
}

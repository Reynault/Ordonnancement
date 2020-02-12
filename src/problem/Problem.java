package problem;

import machine.Machine;
import task.Task;

import java.util.Comparator;
import java.util.List;

public interface Problem {
    double getThingToMinimize(Comparator comparator);
    double getThingToMinimize();
    double getSolution();
    List<Machine> getMachines();
    void setMachines(List<Machine> machines);
    List<Task> getTasks();
    void setTasks(List<Task> tasks);
    double getSumOfP();
    double computeThingToMinimize(List<Task> tasks);
}

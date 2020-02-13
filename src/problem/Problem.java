package problem;

import machine.Machine;
import task.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Un problème est une liste de tâches et une liste de machines,
 * telle qu'il faut minimiser un élément.
 */
public abstract class Problem {
    protected List<Task> tasks;       // set of tasks
    protected List<Machine> machines; // set of machines

    /**
     * Constructeur à deux paramètres
     * @param tasks la liste des tâches à planifier
     * @param nbMachines le nombre de machines
     */
    public Problem(List<Task> tasks, int nbMachines) {
        this.tasks = tasks;
        machines = new ArrayList<>(nbMachines);
        for (int i = 0; i < nbMachines; i++){
            machines.add(new Machine(i+1));
        }
    }

    /**
     * Méthode qui permet de calculer ce que le problème souhaite minimiser
     * @param machines une liste de machines qui possèdent une planification particulière
     * @return valeur (plus grand retard, cmax etc....)
     */
    public abstract double computeThingToMinimize(List<Machine> machines);

    /**
     * Méthode qui permet de récupérer la valeur à minimiser
     * en utilisant un comparateur qui va trier la liste
     * des tâches.
     * @param comparator comparateur qui permet de trier les tâches
     * @return valeur à minimiser
     */
    public double getThingToMinimize(Comparator comparator){
        Collections.sort(tasks, comparator); // Trier les tâches en fonction du comparateur

        List<Machine> ms = new ArrayList<>(); // Création d'une liste de machines
        Machine m = new Machine(1);       // qui contient une machine
        m.setTasks(tasks);                        // avec l'ensemble des tâches à minimiser
        ms.add(m);

        return computeThingToMinimize(ms);
    }

    /**
     * Méthode qui permet de récupérer la valeur à minimiser
     * en utilisant la liste des affectations des tâches aux machines.
     * @return valeur à minimiser
     */
    public double getSolution(){
        return computeThingToMinimize(machines);
    }

    /**
     * Méthode qui permet de récupérer
     * la somme des temps de réalisation
     * @return somme du temps de réalisation des tâches
     */
    public double getSumOfP(){
        double sum = 0;
        for (Task t : tasks) {
            sum += t.getP();
        }
        return sum;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "tasks=" + tasks +
                ", machines=" + machines +
                '}';
    }
}

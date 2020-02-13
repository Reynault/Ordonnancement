package machine;

import task.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * machine.Machine contenant une liste de tâches
 */
public class Machine {
    private List<Task> tasks; // liste de tâches assignées à la machine
    private int id;           // identifieur de la machine

    /**
     * Constructeur simple avec identifieur
     *
     * @param id identifieur
     */
    public Machine(int id) {
        tasks = new ArrayList<>();
        this.id = id;
    }

    /**
     * Méthode qui permet d'ajouter une tâche à une machine
     *
     * @param t la tâche à ajouter
     */
    public void addTask(Task t) {
        this.tasks.add(t);
    }

    /**
     * Méthode qui permet de récupérer le temps de fin de production
     * de la machine
     *
     * @return temps de fin
     */
    public double getEndTime() {
        int time = 0;
        for (Task t : tasks) {
            time += t.getP();
        }
        return time;
    }

    /**
     * Méthode qui permet de récupérer la somme des retards pondérés
     * des tâches de la machine
     *
     * @return somme des retards pondérés
     */
    public double getSumTardiness() {
        int c = 0;
        int tardiness = 0;
        // Calcul du retard pondéré pour chaque tâche
        for (Task task : tasks) {
            c += task.getP();
            if (c > task.getD()) {
                tardiness += task.getW() * (c - task.getD());
            }
        }
        return tardiness;
    }

    /**
     * Méthode qui permet de récupérer le retard maximum
     *
     * @return retard maximum
     */
    public double getMaxTardiness() {
        int max = Integer.MIN_VALUE;
        int c = 0;
        // Pour chaque tâche
        for (Task t : tasks) {
            c += t.getP(); // on calcul au fur et à mesure la date de fin du projet
            if (t.getD() < c && max < (c - t.getD())) {  // puis si la tâche est en retard
                max = c - t.getD(); // on regarde si son retard est plus grand
            }
        }
        return max;
    }

    /**
     * Méthode qui permet de récupérer la somme des retards pondérée en partant de la fin
     * (Question n°2 de l'exercice 1)
     *
     * @param cmax la somme des p
     * @return la somme des retards pondérée en partant de la fin
     */
    public double getSumTardinessFromTheEnd(double cmax){
        double boundary = 0;
        // pour toutes les tâches, récupération des retards pondérés
        // en partant de la fin
        for (Task t : tasks) {
            if (t.getD() < cmax) {
                boundary += t.getW() * (cmax - t.getD());
            }
            cmax -= t.getP();
        }
        return boundary;
    }

    public Task getLastTask(){
        return (tasks.size() > 0) ? tasks.get(tasks.size()-1) : null;
    }

    public int getId() {
        return id;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "machine.Machine{" +
                "tasks=" + tasks +
                '}';
    }
}

package solve.node;

import machine.Machine;
import solve.filter.Filter;
import solve.separation.Separation;
import task.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe node représente un noeud d'un arbre de branch and bound.
 *
 * Un noeud possède une liste de tâches à attribuer et une liste
 * de machines.
 */
public final class Node {
    private final List<Task> remainingSequence; // liste des tâches à attribuer à ses enfants
    private final List<Machine> machines;       // liste des machines qui possèdent

    /**
     * Constructeur à deux paramètres
     * @param remainingSequence la liste des tâches à attribuer aux enfants
     * @param machines la liste des machines
     */
    public Node(List<Task> remainingSequence, List<Machine> machines) {
        this.remainingSequence = remainingSequence;
        this.machines = machines;
    }

    /**
     * Méthode qui permet de générer les enfants du
     * noeud courant.
     * @param filters utilisés pour filtrer les enfants
     * @param separations utilisés pour générer les enfants
     * @return liste des enfants
     */
    public List<Node> generateChildren(List<Filter> filters, List<Separation> separations){
        List<Node> childrens = new ArrayList<>();
        List<Machine> m;
        List<Task> newRemainingSequence;
        // Pour chaque tâche restante à attribuer
        for (Task t : remainingSequence) {
            // construction de la liste des tâches restantes à attribuer
            newRemainingSequence = new ArrayList<>(remainingSequence);
            newRemainingSequence.remove(t);
            // Il peut y avoir plusieurs méthodes séparations fournies
            for (Separation s: separations) {
                // création de la planification fournie par le noeud (avec l'objet de separation)
                m = s.separate(t, machines);

                // passage des différents filtres
                if (passFilters(m, filters)) {
                    // si le fils satisfait les filtres, ajout de l'enfant
                    childrens.add(new Node(newRemainingSequence, m));
                }
            }
        }
        return childrens;
    }

    /**
     * Méthode qui permet de passer les filtres passés en paramètre
     * sur une liste de machine, pour élaguer l'arbre
     * @param machines liste des machines
     * @param filters filtres à passer
     * @return Vrai, si tous les filtres ont été passés
     */
    private boolean passFilters(List<Machine> machines, List<Filter> filters){
        boolean isValid = true;
        // vérification avec tous les filtres
        for(Filter f: filters){
            if(!f.isValid(machines)) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    @Override
    public String toString() {
        return "Node{" +
                "remainingSequence=" + remainingSequence +
                ", machines=" + machines +
                '}';
    }

    public List<Machine> getPlanning(){
        return machines;
    }

    public List<Task> getRemainingSequence() {
        return remainingSequence;
    }
}


package solve;

import machine.Machine;
import problem.Problem;
import solve.filter.Filter;
import solve.filter.SimpleFilter;
import solve.node.Node;
import solve.separation.Separation;
import solve.separation.FirstSeparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Question n°2-3 de l'exercice n°1
 *
 * Solveur qui applique l'algorithme de branch and bound explicité dans le premier
 * exercice.
 */
public class BranchAndBoundEx1 extends Solver {
    private List<Filter> filters;                // filtres pour élaguer
    private List<Separation> separations;                // séparateurs pour séparer
    private Stack<Node> nodesToExplore;     // Noeuds à explorer

    /**
     * Constructeur qui initialise la pile des noeuds à explorer
     */
    public BranchAndBoundEx1(Problem problem) {
        super(problem);
        this.nodesToExplore = new Stack<>();

        // Génération de la liste des filtres et objet de séparation
        filters = new ArrayList<>();
        filters.add(new SimpleFilter());
        separations = new ArrayList<>();
        separations.add(new FirstSeparation());
    }

    /**
     * Méthode de résolution qui développe l'arbre
     * et sélectionne à chaque fois le meilleur fils. (Borne inférieure)
     *
     * @return le problème avec la solution (contenu dans les machines)
     */
    public Problem solve() {
        // On commence par initialiser l'arbre
        List<Machine> machines = new ArrayList<>();
        Node child;
        machines.add(new Machine(1));
        Node current = new Node(problem.getTasks(), machines);
        // On place le noeud racine en tant que noeud à explorer
        nodesToExplore.push(current);
        // Tant qu'il reste des noeuds à explorer
        while (!nodesToExplore.empty()) {
            // Récupération du noeud en tête de pile
            current = nodesToExplore.pop();
            // Génération des enfants et récupération des meilleurs
            child = getInferiorBoundary(current);
            // Ajout des noeuds pour les explorer plus tard
            if(child != null)
                    nodesToExplore.push(child);
        }

        // On récupère ensuite la planification trouvée, en retournant la liste
        // puisqu'on ajoute les machines à la fin
        machines = current.getPlanning();
        for(Machine machine: machines){
            Collections.reverse(machine.getTasks());
        }
        problem.setMachines(machines);

        return problem;
    }

    /**
     * Méthode qui permet d'utilliser la borne inférieure pour élaguer l'arbre
     *
     * @param node, liste des enfants dont on veut récupérer le meilleur
     * @return meilleur noeud
     */
    //@Override
    public Node getInferiorBoundary(Node node) {
        Node best = null;
        double value, min = Integer.MAX_VALUE;
        // récupération de la plus petite valeur
        for(Node n: node.generateChildren(filters, separations)){
            value = getNodeValue(n);
            if(value < min){
                min = value;
                best = n;
            }
        }
        return best;
    }

    /**
     * Méthode qui permet de récupérer la valeur d'un noeud (somme des retards par
     * rapport à la séquence restante)
     *
     * @param n node dont on veut récupérer la valeur
     * @return valeur de n
     */
    private double getNodeValue(Node n){
        double cmax = problem.getSumOfP();
        double tardiness = 0;
        List<Machine> machines = n.getPlanning();
        for(Machine m: machines){
            tardiness += m.getSumTardinessFromTheEnd(cmax);
        }
        return tardiness;
    }
}

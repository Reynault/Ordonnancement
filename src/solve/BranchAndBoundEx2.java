package solve;

import machine.Machine;
import problem.Problem;
import solve.filter.Filter;
import solve.filter.FirstPropertyFilter;
import solve.filter.SecondPropertyFilter;
import solve.filter.SimpleFilter;
import solve.node.Node;
import solve.separation.FirstSeparation;
import solve.separation.SecondSeparation;
import solve.separation.Separation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Application de l'algorithme de la question n°3 de l'exercice n°2
 */
public class BranchAndBoundEx2 extends Solver {

    private List<Filter> filters;                // filtres pour élaguer
    private List<Separation> separations;                // séparateurs pour séparer
    private Stack<Node> nodesToExplore;     // Noeuds à explorer

    /**
     * Constructeur qui initialise la pile des noeuds à explorer
     */
    public BranchAndBoundEx2(Problem problem) {
        super(problem);
        this.nodesToExplore = new Stack<>();

        // Génération de la liste des filtres et objet de séparation
        filters = new ArrayList<>();
        filters.add(new FirstPropertyFilter());
        filters.add(new SecondPropertyFilter());
        separations = new ArrayList<>();
        separations.add(new FirstSeparation());
    }

    /**
     * Méthode permettant d'appliquer l'algorithme de la question n°3 de l'exercice n°2
     * @return le problème avec la solution
     */
    @Override
    public Problem solve() {
        Node current;
        List<Node> childs, best = new ArrayList<>();
        List<Machine> machines = new ArrayList<>();
        machines.add(new Machine(1));
        machines.add(new Machine(2));
        // création de la racine du problème
        current = new Node(problem.getTasks(), machines);
        // récupération du noeud qui minimise le plus grand retard
        childs = getInferiorBoundary(current);
        // on n'utilisera la troisième propriété uniquement pour la racine, à partir de maintenant
        // on ajoute également les fils avec des tâches symétriques
        separations.add(new SecondSeparation());
        // ajout dans les noeuds à explorer
        for(Node n: childs) {
            nodesToExplore.push(n);
        }

        // tant qu'il y a encore des noeuds à explorer
        while (!nodesToExplore.empty()) {
            current = nodesToExplore.pop();
            // génération des enfants
            childs = getInferiorBoundary(current);
            // ajout dans la pile s'il y en a un
            if(!childs.isEmpty()) {
                for (Node n : childs) {
                    nodesToExplore.push(n);
                }
            }else {
                if(current.getRemainingSequence().isEmpty()) {
                    best.add(current);
                }
            }
        }

        // récupération du meilleur fils
        double value, min = Integer.MAX_VALUE;
        for(Node n: best){
            value = problem.computeThingToMinimize(n.getPlanning());
            if(min > value){
                min = value;
                current = n;
            }
        }

        // mise à jour de la séquence du problème
        problem.setMachines(current.getPlanning());
        return problem;
    }

    /**
     * Méthode qui permet de récupérer la borne inférieure d'un noeud passé en paramètre
     * en calculant quel est l'enfant qui minimise le retard maximum
     *
     * @param node, node duquel on récupère la borne inférieure
     * @return noeud qui minimise le retard maximum
     */
    //@Override
    protected List<Node> getInferiorBoundary(Node node) {
        List<Node> best = new ArrayList<>();
        List<Double> values = new ArrayList<>();
        List<Node> childs = node.generateChildren(filters, separations);
        double value, min = Integer.MAX_VALUE;
        // Pour chaque enfant généré à l'aide des filtres et des séparateurs
        for(Node n: childs){
            value = problem.computeThingToMinimize(n.getPlanning()); // récupération du noeud avec le retard max minimal
            values.add(value);
            if(value < min){
                min = value;
            }
        }
        for(int i = 0; i < values.size(); i++){
            if(values.get(i) == min){
                best.add(childs.get(i));
            }
        }

        return best;
    }
}
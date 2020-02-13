package solve;


import problem.Problem;
import solve.node.Node;


/**
 * Un solveur est une façon de résoudre un problème fourni en paramètre
 */
public abstract class Solver {
    protected Problem problem;    // Problème à résoudre

    public Solver(Problem problem) {
        this.problem = problem;
    }

    /**
     * Cette méthode résoud le problème passé en paramètre
     *
     * @return le problem avec une planification qui le résoud dans les machines
     */
    public abstract Problem solve();

    /**
     * Cette méthode permet de récupérer une borne inférieure
     *
     * @param node, node duquel on récupère la borne inférieure
     * @return Ici, la borne inférieure est la liste des noeud fils qui possèdent la plus petite valeur
     */
    //protected abstract Node getInferiorBoundary(Node node);

    public void setProblem(Problem problem) {
        this.problem = problem;
    }
}

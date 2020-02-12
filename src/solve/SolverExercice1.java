package solve;

import machine.Machine;
import node.Node;
import node.NodeExercice1;
import problem.Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * a node that use a tree to retrieve a schedule for a problem
 */
public class SolverExercice1 implements Solver {
    private Stack<Node> nodesToExplore;     // nodes yet to be explored

    /**
     * constructor that simply initialise the stack
     */
    public SolverExercice1() {
        this.nodesToExplore = new Stack<>();
    }

    /**
     * method that solve the problem given in parameter by
     * giving a schedule
     *
     * @param problem the problem to solve
     * @return the schedule
     */
    public Problem solve(Problem problem) {
        // initialisation of the tree  (creation of the root)
        Node current = new NodeExercice1(problem.getTasks(), new Machine(1), problem.getSumOfP());
        List<Node> childs;
        double min, boundary;
        int best = 0;

        // the root is to be explored
        nodesToExplore.add(current);
        // while there is a node to explore
        while (!nodesToExplore.empty()) {
            // we retrieve it, and get its children
            current = nodesToExplore.pop();
            childs = current.generateAndGetChildren();
            // then if it is not empty, it means that we can go
            // down in the tree
            if (!childs.isEmpty()) {
                // so in order to avoid exploring all the tree,
                // we get the child with the minimum tardiness (the inferior bound)
                min = Integer.MAX_VALUE;
                for (int i = 0; i < childs.size(); i++) {
                    boundary = childs.get(i).getValue();
                    if (min > boundary) {
                        min = boundary;
                        best = i;
                    }
                }
                // then, we push the best child, so we can explore it later
                nodesToExplore.push(childs.get(best));
            }
        }

        // and finally, the schedule to give is simply the reverse of the
        // best node sequence (which is is the machine)
        List<Machine> m = current.getCurrentSequence();
        if(!m.isEmpty()) {
            Collections.reverse(m.get(0).getTasks());
            problem.setTasks(m.get(0).getTasks());
        }

        return problem;
    }
}

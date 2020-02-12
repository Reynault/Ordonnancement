package node;

import task.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Class node that represent a separation of the evaluation
 */
public class Node {
    private List<Task> remainingSequence;   // the remaining tasks to give to the childrens
    private List<Task> currentSequence;     // the current sequence of tasks
    private double cmax;                    // cmax of the problem

    /**
     * A node is created from a sequence to assign, a current sequence (for the root, it will be
     * an empty list), and the cmax of the problem (which will be used to generate an inferior bound)
     * @param remainingSequence the remaining tasks to assign
     * @param currentSequence the current sequence of the root
     * @param cmax the end of all tasks
     */
    public Node(List<Task> remainingSequence, List<Task> currentSequence, double cmax) {
        this.remainingSequence = remainingSequence;
        this.currentSequence = currentSequence;
        this.cmax = cmax;
    }

    /**
     * Method that generate children of the current node,
     * a child will be a copy of the current node, with one more task.
     * @return a list containing children
     */
    public List<Node> generateAndGetChildren() {
        List<Node> childrens = new ArrayList<>();
        List<Task> newRemainingSequence, newCurrentSequence;
        // a child is a new node with one more task in its current sequence
        // and one less task to assign.
        for(Task t: remainingSequence){
            newRemainingSequence = new ArrayList<>(remainingSequence);
            newRemainingSequence.remove(t);

            newCurrentSequence = new ArrayList<>(currentSequence);
            newCurrentSequence.add(t);

            childrens.add(new Node(
                    newRemainingSequence, newCurrentSequence, cmax
            ));
        }
        return childrens;
    }

    /**
     * Method that returns the tardiness of its children. (The tardiness can't go below if
     * we go down in the tree from this node)
     * @return the inferior bound
     */
    public double getTardiness() {
        // we start from the end
        double endTime = cmax;
        double boundary = 0;
        // foreach tasks of the current node, we add tardiness from the end
        for(Task t: currentSequence){
            if(t.getD() < endTime){
                boundary += t.getW() * (endTime - t.getD());
            }
            endTime -= t.getP();
        }
        return boundary;
    }

    public List<Task> getCurrentSequence() {
        return currentSequence;
    }

    @Override
    public String toString() {
        return "Node{" +
                "remainingSequence=" + remainingSequence +
                ", currentSequence=" + currentSequence +
                ", cmax=" + cmax +
                '}';
    }
}

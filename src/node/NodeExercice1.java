package node;

import machine.Machine;
import task.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Class node that represent a separation of the evaluation
 */
public class NodeExercice1 implements Node {
    private List<Task> remainingSequence;   // the remaining tasks to give to the childrens
    private Machine machine;                // machine containing the current sequence of tasks
    private double cmax;                    // cmax of the problem

    /**
     * A node is created from a sequence to assign, a current sequence (for the root, it will be
     * an empty list), and the cmax of the problem (which will be used to generate an inferior bound)
     *
     * @param remainingSequence the remaining tasks to assign
     * @param machine           containing the current sequence of the root
     * @param cmax              the end of all tasks
     */
    public NodeExercice1(List<Task> remainingSequence, Machine machine, double cmax) {
        this.remainingSequence = remainingSequence;
        this.machine = machine;
        this.cmax = cmax;
    }

    /**
     * Method that generate children of the current node,
     * a child will be a copy of the current node, with one more task.
     *
     * @return a list containing children
     */
    public List<Node> generateAndGetChildren() {
        List<Node> childrens = new ArrayList<>();
        List<Task> newRemainingSequence;
        Machine m;
        // a child is a new node with one more task in its current sequence
        // and one less task to assign.
        for (Task t : remainingSequence) {
            newRemainingSequence = new ArrayList<>(remainingSequence);
            newRemainingSequence.remove(t);

            m = new Machine(1);
            m.setTasks(new ArrayList<>(machine.getTasks()));
            m.addTask(t);

            childrens.add(new NodeExercice1(
                    newRemainingSequence, m, cmax
            ));
        }
        return childrens;
    }

    /**
     * Method that returns the tardiness of its children. (The tardiness can't go below if
     * we go down in the tree from this node)
     *
     * @return the inferior bound
     */
    public double getValue() {
        // we start from the end
        double endTime = cmax;
        double boundary = 0;
        // getting current sequence from the machine
        List<Task> tasks = machine.getTasks();
        // foreach tasks of the current node, we add tardiness from the end
        for (Task t : tasks) {
            if (t.getD() < endTime) {
                boundary += t.getW() * (endTime - t.getD());
            }
            endTime -= t.getP();
        }
        return boundary;
    }

    /**
     * Method that returns the current sequence of the node
     * which is in this case the machine containing
     * the sequence
     * @return the machine
     */
    public List<Machine> getCurrentSequence() {
        ArrayList<Machine> m = new ArrayList<>();
        m.add(machine);
        return m;
    }

    @Override
    public String toString() {
        return "NodeExercice1{" +
                "remainingSequence=" + remainingSequence +
                ", machine=" + machine +
                ", cmax=" + cmax +
                '}';
    }
}

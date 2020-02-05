package exercice1;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private List<Task> sequence;
    private Problem problem;

    public Node(List<Task> sequence, List<Task> problemSequence) {
        this.problem = new Problem(problemSequence);
        this.sequence = sequence;
    }

    public List<Node> getChildren() {

        ArrayList<Node> list = new ArrayList<>();
        for (Task task : sequence) {
            sequence.remove(task);
            problem.getTasks().add(task);
            list.add(new Node(sequence, problem.getTasks()));
        }
        return list;
    }
}

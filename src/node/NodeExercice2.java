package node;

import machine.Machine;

import java.util.List;

public class NodeExercice2 implements Node{
    @Override
    public double getValue() {
        return 0;
    }

    @Override
    public List<Node> generateAndGetChildren() {
        return null;
    }

    @Override
    public List<Machine> getCurrentSequence() {
        return null;
    }
}

package node;

import machine.Machine;

import java.util.List;

public interface Node {
    double getValue();
    List<Node> generateAndGetChildren();
    List<Machine> getCurrentSequence();
}

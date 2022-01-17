package gridChallenge;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Grid implements Comparable<Grid> {

    private char colour;

    private Set<Node> nodes;

    public Grid(char colour) {
        this.colour = colour;
        nodes = new HashSet<>();
    }

    public Set<NodePosition> points() {
        return nodes.stream().map(n -> n.getPoint()).collect(Collectors.toSet());
    }

    public boolean addNode(Node node) {
        if (node != null && !nodes.contains(node)
                && node.getColour() == this.colour) {
            return nodes.add(node);
        }
        return false;
    }

    public boolean hasNode(Node node) {
        if(node == null)
            return false;
        return nodes.stream().anyMatch(n -> n.getId() == node.getId());
    }

    public void display() {
        nodes.forEach(n -> System.out.print(n.toString()));
    }

    public int size() {
        return nodes.size();
    }

    @Override
    public int compareTo(Grid o) {
        return o.size() - this.size();
    }
}

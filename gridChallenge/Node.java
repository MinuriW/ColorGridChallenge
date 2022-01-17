package gridChallenge;

public class Node {

    private NodePosition points;
    private char colour;
    private int id;

    public Node(int id, int x, int y, char colour) {
        this.colour = colour;
        this.points = new NodePosition(x, y);
        this.id = id;
    }

    public NodePosition getPoint() {
        return points;
    }

    public char getColour() {
        return colour;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (colour != node.colour) return false;
        return points.equals(node.points);
    }

    @Override
    public int hashCode() {
        int result = points.hashCode();
        result = 31 * result + (int) colour;
        return result;
    }

}

package gridChallenge;

public class NodePosition {
    private int x;
    private int y;

    public NodePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public NodePosition up() {
        return new NodePosition(x, y-1);
    }

    public NodePosition down() {
        return new NodePosition(x, y+1);
    }

    public NodePosition left() {
        return new NodePosition(x-1, y);
    }

    public NodePosition right() {
        return new NodePosition(x+1, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NodePosition nodePosition = (NodePosition) o;

        if (x != nodePosition.x) return false;
        return y == nodePosition.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }


}

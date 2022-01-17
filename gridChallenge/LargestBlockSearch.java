package gridChallenge;


import java.lang.Math;
import java.util.*;

public class LargestBlockSearch {

    public static final char[] ColorArray = {'R', 'B', 'G'};

    private HashMap<NodePosition, Node> grid;

    private int col;
    private int row;

    public void createGame(int col, int row) {
        this.col = col;
        this.row = row;

        Random random = new Random();
        this.grid = new HashMap<>();
        for (int i = 0; i < col*row ; i++ ) {
            int x = i % col;
            int y = (int) Math.floor(i/col);
            this.grid.put(new NodePosition(x, y), new Node(i, x, y, ColorArray[random.nextInt(3)]));
        }
    }

    public Node getNode(int x, int y) {
        return this.grid.get(new NodePosition(x, y));
    }

  
    private List<Node> checkAdjacentNodes(Node n, Grid grid) {
        List<Node> node = new ArrayList<>();
        NodePosition points = n.getPoint();
        Node up = this.grid.get(points.up());
        if (up != null && up.getColour() == n.getColour() && !grid.hasNode(up)) {
            node.add(up);
        }
        Node down = this.grid.get(points.down());
        if (down != null && down.getColour() == n.getColour() && !grid.hasNode(down)) {
            node.add(down);
        }
        Node right = this.grid.get(points.right());
        if (right != null && right.getColour() == n.getColour() && !grid.hasNode(right)) {
            node.add(right);
        }
        Node left = this.grid.get(points.left());
        if (left != null && left.getColour() == n.getColour() && !grid.hasNode(left)) {
            node.add(left);
        }
        return node;
    }

    public Grid checkContinuation(int x, int y) {
        NodePosition startCoord = new NodePosition(x, y);
        Node startNode = this.grid.get(startCoord);
        Grid grid = new Grid(startNode.getColour());
        grid.addNode(startNode);

        LinkedList<Node> nodesToVisit = new LinkedList<>();
        nodesToVisit.addAll(checkAdjacentNodes(startNode, grid));

        while(!nodesToVisit.isEmpty()) {
            Node nextNode = nodesToVisit.remove();
            grid.addNode(nextNode);
            nodesToVisit.addAll(checkAdjacentNodes(nextNode, grid));
        }

        return grid;
    }

    public Grid findLargest() {
        Set<NodePosition> points = new HashSet<>(this.grid.keySet());
        List<Grid> blocks = new ArrayList<>();
        while(!points.isEmpty()) {
            NodePosition nodePosition = points.iterator().next();
            Grid newBlock = checkContinuation(nodePosition.getX(), nodePosition.getY());
            blocks.add(newBlock);
            points.removeAll(newBlock.points());
        }
        Collections.sort(blocks);
        return blocks.size() > 0 ? blocks.get(0) : null;
    
    }
    public void displayGrid() {
        for (int y = 0; y < row; y++) {
            for(int x = 0; x < col; x++) {
                if(x == this.col - 1 ) {
                    System.out.println(getNode(x, y).getColour());
                } else {
                    System.out.print(getNode(x, y).getColour() + "  ");
                }
            }
        }
    }

    public void displayLargestBlock(Grid grid) {
        for (int y = 0; y < row; y++) {
            for(int x = 0; x < col; x++) {
                Node n = getNode(x, y);
                char colour = grid.hasNode(n) ? '*' : n.getColour();
                if(x == this.col - 1 ) {
                    System.out.println(colour);
                } else {
                    System.out.print(colour + "  ");
                }
            }
        }
    }


}
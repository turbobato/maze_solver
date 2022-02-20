package maze;

public abstract class MBox implements dijkstra.VertexInterface {

    private final int x;
    private final int y;
    private final Maze maze;
    private final String label;

    public MBox(int x, int y, Maze maze, String label) {
        this.x = x;
        this.y = y;
        this.maze = maze;
        this.label = label;
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    public final String getLabel() {
        return label;
    }

    public boolean isWall() {
        return false;
    }

    public final boolean isNeighbour(MBox b) { // renvoie true si b est un voisin direct, false sinon
        return (maze.neighbours(this).contains(b));
    }
}

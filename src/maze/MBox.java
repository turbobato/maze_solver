package maze;

import dijkstra.VertexInterface;

/* This abstract class implements the methods needed for the boxes in our maze app, 
implementing the interface VertexInterface */

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

    // method to be overriden in the WBox class, by default a box is not a wall
    public boolean isWall() {
        return false;
    }

    // tests if two boxes are neighbours in the maze, which means they are directly adjacent and none of them is a wall
    public final boolean isNeighbour(VertexInterface b) { 
        return (maze.neighbours(this).contains(b));
    }
}

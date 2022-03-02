package maze;

/* This class describes a box which is a wall, denoted by a label of W*/


public final class WBox extends MBox {

    public WBox(int x, int y, Maze maze) {
        super(x, y, maze, "W");
    }

    // we override the inherited method is wall to make it return true
    @Override
    public final boolean isWall() {
        return true;
    }
}

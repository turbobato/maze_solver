package maze;

public final class WBox extends MBox {

    public WBox(int x, int y, Maze maze) {
        super(x, y, maze, "W");
    }

    @Override
    public final boolean isWall() {
        return true;
    }
}

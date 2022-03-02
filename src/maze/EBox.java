package maze;

/* This class describes a box which is empty, denoted by a label of E*/

public final class EBox extends MBox {

    public EBox(int x, int y, Maze maze) {
        super(x, y, maze, "E");
    }

}

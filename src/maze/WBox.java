package maze;

public class WBox extends MBox {

    public WBox(int x, int y, Maze maze) {
        super(x, y, maze, "W");
    }
    @Override
    public boolean isWall(){
        return true;
    }
}

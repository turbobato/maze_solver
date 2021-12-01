package core;

public class WBox extends MBox {

    public WBox(int x, int y, Maze maze, String label) {
        super(x, y, maze, "W");
    }
    @Override
    public boolean isWall(){
        return true;
    }
}

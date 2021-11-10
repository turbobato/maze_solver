package core;

import api.VertexInterface;

public abstract class MBox implements VertexInterface {

    private int x;
    private int y;
    private Maze maze;
    private String label;

    MBox(int x, int y, Maze maze){
        this.x=x;
        this.y=y;
        this.maze=maze;
    }
    
    public final int GetX(){
        return x;
    }
    
    public final int GetY(){
        return y;
    }

    public final String GetLabel(){
        return label;
    }
}

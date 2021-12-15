package maze;

public abstract class MBox implements dijkstra.VertexInterface {

    private int x;
    private int y;
    private Maze maze;
    private String label;

    public MBox(int x, int y, Maze maze, String label){
        this.x=x;
        this.y=y;
        this.maze=maze;
        this.label=label;
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

    public boolean isWall(){
        return false;    
    }
    
    public boolean isNeighbour(MBox b){ //renvoie true si b est un voisin direct, false sinon
        return(maze.Neighbours(this).contains(b));
    } 
}

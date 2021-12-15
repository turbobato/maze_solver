package core;

public class MazeOutOfBoundsException extends RuntimeException {
    
    public MazeOutOfBoundsException(){
        super("on est en dehors du labyrtinhe");
    }
}

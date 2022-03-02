package maze;

/* This class extends RuntineException for when we try to access a box which position is outside
of the boundaries of the maze*/

public final class MazeOutOfBoundsException extends RuntimeException {

    public MazeOutOfBoundsException() {
        super("You are out of the maze");
    }
}

package maze;

public final class MazeOutOfBoundsException extends RuntimeException {

    public MazeOutOfBoundsException() {
        super("You are out of the maze");
    }
}

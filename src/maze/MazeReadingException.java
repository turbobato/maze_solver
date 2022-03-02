package maze;

/* This class is a custom type of Exception used when there is an issue while reading mazes from files,
for instance there is more than one arrival, the maze is not rectangular, etc*/

public final class MazeReadingException extends Exception {

    private final String fileName;
    private final String ErrorMessage;
    private final int line;

    public MazeReadingException(String fileName, int line, String ErrorMessage) {
        super(ErrorMessage + " at the line " + line + " of file : " + fileName);
        this.fileName = fileName;
        this.line = line;
        this.ErrorMessage = ErrorMessage;
    }

    public final String getFileName() {
        return fileName;
    }

    public final int getLine() {
        return line;
    }

    public final String getErrorMessage() {
        return ErrorMessage;
    }
}

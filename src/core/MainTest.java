package core;

public class MainTest {
    
    public static void main(String[] args) throws MazeReadingException {
        Maze maze  = new Maze();
        maze.initFromTextFile("data/maze.txt");
    }

}

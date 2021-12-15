import maze.*;
import dijkstra.*;

public class MainTest {
    
    public static void main(String[] args) throws MazeReadingException {
        Maze maze  = new Maze("data/maze.txt");
        maze.saveToTextFile("data/maze2.txt");;
      
    }

}

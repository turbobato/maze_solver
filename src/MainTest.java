import maze.*;
import dijkstra.*;

public class MainTest {

    public static void main(String[] args) throws MazeReadingException {
        Maze maze1 = new Maze(10,10);
        Maze maze = new Maze("data/maze.txt");
        maze1.saveToTextFile("data/maze2.txt");

    }

}

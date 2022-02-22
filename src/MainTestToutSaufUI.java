import maze.*;

import java.io.*;
import java.util.HashSet;

import dijkstra.*;

public class MainTestToutSaufUI {

    public static void main(String[] args) throws MazeReadingException {

        Maze maze = new Maze("data/maze3.txt");
        DBox departure = (DBox) maze.getDeparture();
        ABox arrival = (ABox) maze.getArrival();
        PreviousInterface previous = Dijksta.dijkstra(maze, departure);
        HashSet<VertexInterface> path = new HashSet<VertexInterface>();
        VertexInterface v = arrival;
        while (v != departure && v != null) {
            path.add(v);
            v = previous.father(v);
            if (v == null) {
                System.out.println("This labyrinth has no solution");
            }
        }
        for (int i = 0; i < maze.getLines(); i++) {
            for (int j = 0; j < maze.getColumns(); j++) {
                if (path.contains(maze.getBox(i, j))) {
                    System.out.print(".");
                } else {
                    System.out.print(maze.getBox(i, j).getLabel());
                }
            }
            if (i != maze.getLines() - 1) {
                System.out.println();
            }
        }
    }
}
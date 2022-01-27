import maze.*;

import java.io.*;
import java.util.HashSet;

import dijkstra.*;

public class MainTestToutSaufUI {

    public static void main(String[] args) throws MazeReadingException, IOException {

        Maze maze = new Maze("data/maze.txt");
        DBox departure = (DBox)maze.getDeparture();
        ABox arrival = (ABox)maze.getArrival();
        PreviousInterface previous = Dijksta.dijkstra(maze, departure);
        HashSet<VertexInterface> chemin = new HashSet<VertexInterface>();
        VertexInterface v = arrival;
        while(v!=departure) {
            chemin.add(v);
            v = previous.Pere(v);
        }
        for (int i = 0; i < maze.getLines() - 1; i++) {
            for (int j = 0; j < maze.getColumns(); j++) {
                if(chemin.contains(maze.getBox(i,j))) {
                    System.out.print(".");
                }
                else {
                    System.out.print(maze.getBox(i, j).GetLabel());
                }
            }
            System.out.println();
        }
        for (int j = 0; j < maze.getColumns(); j++) {
            if(chemin.contains(maze.getBox(maze.getLines()-1,j))) {
                System.out.print(".");
            }
            else {
                System.out.print(maze.getBox(maze.getLines()-1, j).GetLabel());
            }
        }
    }       
}   

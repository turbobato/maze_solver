package ui;

import javax.swing.*;

import dijkstra.VertexInterface;
import maze.*;

import java.awt.*;

public final class MazePanel extends JPanel {

    private final MazeApp mazeApp;
    private MBoxButton[][] boxes;

    public MazePanel(MazeApp mazeApp){
        super();
        this.mazeApp=mazeApp;
        Maze maze = this.mazeApp.getModel().getMaze();
        int columns = maze.getColumns();
        int lines = maze.getLines();
        boxes= new MBoxButton[lines][columns];
        setLayout(new GridLayout(lines,columns));
        for (int i= 0; i< columns; i++){
            for (int j=0; j<lines; j++){
                VertexInterface box = maze.getBox(i, j);
                if (box.getLabel().equals("D")){
                    add(new DBoxButton(mazeApp, box));
                }
                else if (box.getLabel().equals("A")){
                    add(new ABoxButton(mazeApp, box));
                }
                else if (box.getLabel().equals("W")){
                    add(new WBoxButton(mazeApp, box));
                }
                else if (box.getLabel().equals("E")){
                    add(new EBoxButton(mazeApp, box));
                } 
            }
        }
    }

    public void notifyForUpdate(){
        Maze maze = this.mazeApp.getModel().getMaze();
        int columns = maze.getColumns();
        int lines = maze.getLines();
        boxes= new MBoxButton[lines][columns];
        setLayout(new GridLayout(lines,columns));
        for (int i= 0; i< columns; i++){
            for (int j=0; j<lines; j++){
                VertexInterface box = maze.getBox(i, j);
                if (box.getLabel().equals("D")){
                    add(new DBoxButton(mazeApp, box));
                }
                else if (box.getLabel().equals("A")){
                    add(new ABoxButton(mazeApp, box));
                }
                else if (box.getLabel().equals("W")){
                    add(new WBoxButton(mazeApp, box));
                }
                else if (box.getLabel().equals("E")){
                    add(new EBoxButton(mazeApp, box));
                } 
            }
        }
    }
    
}

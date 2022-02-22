package ui;

import javax.swing.*;
import maze.*;
import dijkstra.*;
import java.awt.*;
import java.util.HashSet;


public final class MazePanel extends JPanel { //this is utter trash 

    private final MazeApp mazeApp;
    private MBoxPanel[][] boxes;

    public MazePanel(MazeApp mazeApp){
        super();
        this.mazeApp=mazeApp;
        Maze maze = this.mazeApp.getModel().getMaze();
        int columns = maze.getColumns();
        int lines = maze.getLines();
        boxes = new MBoxPanel[lines][columns];
        setLayout(new GridLayout(lines,columns));
        for (int i= 0; i< lines; i++){
            for (int j=0; j< columns; j++){
                MBox box = (MBox) maze.getBox(i, j);
                if (box.getLabel().equals("D")){
                    add(boxes[i][j] = new DBoxPanel(mazeApp, box));
                }
                else if (box.getLabel().equals("A")){
                    add(boxes[i][j] = new ABoxPanel(mazeApp, box));
                }
                else if (box.getLabel().equals("W")){
                    add(boxes[i][j] = new WBoxPanel(mazeApp, box));
                }
                else if (box.getLabel().equals("E")){
                    add(boxes[i][j] = new EBoxPanel(mazeApp, box));
                }
            }
        }
    }

    private final void reBuildBoxes(){
        
        this.removeAll();
        this.revalidate();
        this.repaint();
        Maze maze = this.mazeApp.getModel().getMaze();
        int columns = maze.getColumns();
        int lines = maze.getLines();
        boxes= new MBoxPanel[lines][columns];
        setLayout(new GridLayout(lines,columns));
        for (int i= 0; i< lines; i++){
            for (int j=0; j<columns; j++){
                MBox box = (MBox) maze.getBox(i, j);
                if (box.getLabel().equals("D")){
                    add(boxes[i][j] = new DBoxPanel(mazeApp, box));
                }
                else if (box.getLabel().equals("A")){
                    add(boxes[i][j] = new ABoxPanel(mazeApp, box));
                }
                else if (box.getLabel().equals("W")){
                    add(boxes[i][j] = new WBoxPanel(mazeApp, box));
                }
                else if (box.getLabel().equals("E")){
                    add(boxes[i][j] = new EBoxPanel(mazeApp, box));
                }
            }
        }
    }

    private final void displaySolution(){

        MazeAppModel mazeAppModel = mazeApp.getModel();
        if (!mazeAppModel.isArrivalSet()|| !mazeAppModel.isDepartureSet()){
            JOptionPane.showMessageDialog(mazeApp,
                        "Please set arrival and departure",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            mazeAppModel.setDisplaySolution(false);
        }
        else{
            Maze maze = mazeAppModel.getMaze();
            DBox departure = (DBox) maze.getDeparture();
            ABox arrival = (ABox) maze.getArrival();
            PreviousInterface previous = Dijksta.dijkstra(maze, departure);
            HashSet<VertexInterface> path = new HashSet<VertexInterface>();
            VertexInterface v = previous.father(arrival);
            while (v != departure && v != null) {
                path.add(v);
                v = previous.father(v);
            }
            if (v == null) {
                JOptionPane.showMessageDialog(mazeApp,
                            "This labyrinth has no solution",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                mazeAppModel.setDisplaySolution(false);
            }
            else {
                this.removeAll();
                this.revalidate();
                this.repaint();
                for (int i = 0; i < maze.getLines(); i++) {
                    for (int j = 0; j < maze.getColumns(); j++) {
                        MBox box = (MBox) maze.getBox(i, j);
                        if (path.contains(box)) {
                            add(boxes[i][j] = new SolBoxPanel(mazeApp, box));
                        } else {
                            if (box.getLabel().equals("D")){
                                add(boxes[i][j] = new DBoxPanel(mazeApp, box));
                            }
                            else if (box.getLabel().equals("A")){
                                add(boxes[i][j] = new ABoxPanel(mazeApp, box));
                            }
                            else if (box.getLabel().equals("W")){
                                add(boxes[i][j] = new WBoxPanel(mazeApp, box));
                            }
                            else if (box.getLabel().equals("E")){
                                add(boxes[i][j] = new EBoxPanel(mazeApp, box));
                            }
                        }
                    }
                }
            }
        }
    }

    public void notifyForUpdate(){
        MazeAppModel mazeAppModel = mazeApp.getModel();
        if (mazeAppModel.getRebuildLabyrinth()){
            reBuildBoxes();
            mazeApp.getModel().setRebuildLabyrinth(false);
        }
        else if (mazeAppModel.getDisplaySolution()){
            displaySolution();
        }
    }
}

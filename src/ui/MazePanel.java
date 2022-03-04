package ui;

import javax.swing.*;
import maze.*;
import dijkstra.*;
import java.awt.*;
import java.util.HashSet;

/* This class describes the panel that displays the maze.
It extends JPanel*/

public final class MazePanel extends JPanel {

    private final MazeApp mazeApp;
    private MBoxPanel[][] boxes;

    public MazePanel(MazeApp mazeApp) {
        super();
        this.mazeApp = mazeApp;
        Maze maze = this.mazeApp.getModel().getMaze();
        int columns = maze.getColumns();
        int lines = maze.getLines();
        boxes = new MBoxPanel[lines][columns];
        setLayout(new GridLayout(lines, columns));
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) { // double loop to read data from the maze in the model and subsequently
                                                // generate the view of the maze
                MBox box = (MBox) maze.getBox(i, j);
                if (box.getLabel().equals("D")) {
                    add(boxes[i][j] = new DBoxPanel(mazeApp, box));
                } else if (box.getLabel().equals("A")) {
                    add(boxes[i][j] = new ABoxPanel(mazeApp, box));
                } else if (box.getLabel().equals("W")) {
                    add(boxes[i][j] = new WBoxPanel(mazeApp, box));
                } else if (box.getLabel().equals("E")) {
                    add(boxes[i][j] = new EBoxPanel(mazeApp, box));
                }
            }
        }
    }

    // method to be called whenever the maze in the model has been updated, to
    // update the view of the maze
    private final void reBuildBoxes() {

        this.removeAll(); // we start by removing the previous boxes, because gridLayout doesn't allow to
                          // modifiy only one element, everything has to be rebuild
        this.revalidate();
        this.repaint();
        Maze maze = this.mazeApp.getModel().getMaze();
        int columns = maze.getColumns();
        int lines = maze.getLines();
        boxes = new MBoxPanel[lines][columns];
        setLayout(new GridLayout(lines, columns));
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) { // then we do a double loop to generate the maze view by reading from
                                                // the maze view contained in the model
                MBox box = (MBox) maze.getBox(i, j);
                if (box.getLabel().equals("D")) {
                    add(boxes[i][j] = new DBoxPanel(mazeApp, box));
                } else if (box.getLabel().equals("A")) {
                    add(boxes[i][j] = new ABoxPanel(mazeApp, box));
                } else if (box.getLabel().equals("W")) {
                    add(boxes[i][j] = new WBoxPanel(mazeApp, box));
                } else if (box.getLabel().equals("E")) {
                    add(boxes[i][j] = new EBoxPanel(mazeApp, box));
                }
            }
        }
    }

    // method to be called when the solution has to be displayed, in order to update
    // the view
    private final void displaySolution() {

        MazeAppModel mazeAppModel = mazeApp.getModel();
        if (!mazeAppModel.isArrivalSet() || !mazeAppModel.isDepartureSet()) { // verify that there is an arrival and a
                                                                              // departure, else show an error
            JOptionPane.showMessageDialog(mazeApp,
                    "Please set arrival and departure",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            mazeAppModel.setDisplaySolution(false); // there has been an error, stop displaying solution
        } else { // if arrival and departure are set, start solving labyrinth using static method
                 // dijkstra over the maze contained in the model
            Maze maze = mazeAppModel.getMaze();
            DBox departure = (DBox) maze.getDeparture();
            ABox arrival = (ABox) maze.getArrival();
            PreviousInterface previous = Dijksta.dijkstra(maze, departure);
            HashSet<VertexInterface> path = new HashSet<VertexInterface>(); // to store the path from departure to
                                                                            // arrival
            VertexInterface v = previous.father(arrival);
            while (v != departure && v != null) {
                path.add(v);
                v = previous.father(v);
            }
            if (v == null) { // while going through previous, if v happens to be null it means there is no
                             // path from departure to arrival
                JOptionPane.showMessageDialog(mazeApp,
                        "This labyrinth has no solution",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                mazeAppModel.setDisplaySolution(false); // there has been an error, stop displaying solution
            } else {
                this.removeAll(); // we start by removing the previous boxes, because gridLayout doesn't allow to
                                  // modifiy only one element, everything has to be rebuild
                this.revalidate();
                this.repaint();
                for (int i = 0; i < maze.getLines(); i++) {
                    for (int j = 0; j < maze.getColumns(); j++) {
                        MBox box = (MBox) maze.getBox(i, j);
                        if (path.contains(box)) { // if the box in the solution, we display a yellow box of type SolBox
                            add(boxes[i][j] = new SolBoxPanel(mazeApp, box));
                        } else { // else we just display the box
                            if (box.getLabel().equals("D")) {
                                add(boxes[i][j] = new DBoxPanel(mazeApp, box));
                            } else if (box.getLabel().equals("A")) {
                                add(boxes[i][j] = new ABoxPanel(mazeApp, box));
                            } else if (box.getLabel().equals("W")) {
                                add(boxes[i][j] = new WBoxPanel(mazeApp, box));
                            } else if (box.getLabel().equals("E")) {
                                add(boxes[i][j] = new EBoxPanel(mazeApp, box));
                            }
                        }
                    }
                }
            }
        }
    }

    // called whenever the model is modified, to update the view
    public void notifyForUpdate() {
        MazeAppModel mazeAppModel = mazeApp.getModel();
        if (mazeAppModel.getRebuildLabyrinth()) { // if there is a need to rebuild the boxes, rebuild them
            reBuildBoxes();
            mazeApp.getModel().setRebuildLabyrinth(false); // rebuild done, set the control signal to false
        } else if (mazeAppModel.getDisplaySolution()) {
            displaySolution(); // if it is asked to display the solution, display it
        }
        for (int i = 0; i < mazeAppModel.getMaze().getLines(); i++) { // rebuild the boxes
            for (int j = 0; j < mazeAppModel.getMaze().getColumns(); j++) {
                boxes[i][j].notifyForUpdate();
            }
        }
    }
}

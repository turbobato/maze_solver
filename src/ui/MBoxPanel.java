package ui;

import javax.swing.*;
import dijkstra.VertexInterface;
import java.awt.*;
import maze.*;
import java.awt.event.*;

/* This abstract class describes the behaviour of a the representation of a box
in the UI. It extends JPanel and implements MouseListener, because it is expected
to change itself when clicked on.*/

public abstract class MBoxPanel extends JPanel implements MouseListener {

    private final MazeApp mazeApp;
    private final Color color;
    private final MBox box;

    public MBoxPanel(MazeApp mazeApp, Color color, MBox box) {
        super();
        this.mazeApp = mazeApp;
        this.color = color;
        this.box = box;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(this.color);
        addMouseListener(this);
    }

    public final MBox getBox() {
        return box;
    }

    public final Color getColor() {
        return color;
    }

    // describes behaviour when we click on a box
    public final void mousePressed(MouseEvent e) {
        MazeAppModel mazeAppModel = mazeApp.getModel();
        Maze maze = mazeAppModel.getMaze();
        String currentEditionMode = mazeAppModel.getCurrentEditionMode();
        boolean editEnabled = mazeAppModel.getEditEnabled();
        int x = box.getX();
        int y = box.getY();
        if (currentEditionMode != null && editEnabled) { // verify that we can edit
            if (currentEditionMode.equals("Arrival")) { // case where we try to add Arrival
                VertexInterface box = new ABox(x, y, maze);
                if (mazeAppModel.isArrivalSet()) { // if there is already an arrival, set the new arrival and replace
                                                   // the previous by an empty box
                    VertexInterface previousArrival = maze.getArrival();
                    int x0 = previousArrival.getX();
                    int y0 = previousArrival.getY();
                    mazeAppModel.setMazeArrival(box);
                    mazeAppModel.setBox(x, y, box);
                    if (x0 != x || y0 != y) { // verify we are not clicking on the previous arrival
                        mazeAppModel.setBox(x0, y0, new EBox(x0, y0, maze));
                    }
                } else { // else, just set the new arrival
                    mazeAppModel.setMazeArrival(box);
                    mazeAppModel.setBox(x, y, box);
                }
            } else if (currentEditionMode.equals("Departure")) { // case where we try to add Departure
                VertexInterface box = new DBox(x, y, maze);
                if (mazeAppModel.isDepartureSet()) { // if there is already a departure, set the new arrival and replace
                                                     // the previous by an empty box
                    VertexInterface previousDeparture = maze.getDeparture();
                    int x0 = previousDeparture.getX();
                    int y0 = previousDeparture.getY();
                    mazeAppModel.setMazeDeparture(box);
                    mazeAppModel.setBox(x, y, box);
                    if (x0 != x || y0 != y) { // verify we are not clicking on the previous departure
                        mazeAppModel.setBox(x0, y0, new WBox(x0, y0, maze));
                    }
                } else { // else, just set the new arrival
                    mazeAppModel.setMazeDeparture(box);
                    mazeAppModel.setBox(x, y, box);
                }
            } else if (currentEditionMode.equals("Wall")) { // case where we try to add a wall
                VertexInterface previous = maze.getBox(x, y);
                if (previous.getLabel().equals("A")) { // if we set the wall on the arrival, arrival is not set anymore
                    mazeAppModel.setMazeArrival(null);
                } else if (previous.getLabel().equals("D")) { // if we set the wall on the departure, departure is not
                                                              // set anymore
                    mazeAppModel.setMazeDeparture(null);
                }
                VertexInterface box = new WBox(x, y, maze);
                mazeAppModel.setBox(x, y, box);
            } else if (currentEditionMode.equals("Empty")) { // case where we try to add an empty box
                VertexInterface previous = maze.getBox(x, y);
                if (previous.getLabel().equals("A")) { // if we set the empty box on the arrival, arrival is not set
                                                       // anymore
                    mazeAppModel.setMazeArrival(null);
                } else if (previous.getLabel().equals("D")) { // if we set the empty box on the departure, departure is
                                                              // not set anymore
                    mazeAppModel.setMazeDeparture(null);
                }
                VertexInterface box = new EBox(x, y, maze);
                mazeAppModel.setBox(x, y, box);
            }
        }
        mazeAppModel.setRebuildLabyrinth(true); // maze has been changed, rebuild it

    }

    /*
     * we don't use mouseClicked, mouseReleased, mouseEnterd nor mouseExited so
     * they are left empty because we declared implementing MouseListener interface
     */
    public final void mouseClicked(MouseEvent e) {
    }

    public final void mouseReleased(MouseEvent e) {
    }

    public final void mouseEntered(MouseEvent e) {
    }

    public final void mouseExited(MouseEvent e) {
    }

    // called whenever the model is modified, to update the view
    public void notifyForUpdate() {
    } // here there is nothing to update, but we keep this method empty in a goal of
      // global coherence of the app

}

package ui;

import java.util.ArrayList;
import javax.swing.event.*;
import dijkstra.VertexInterface;
import maze.Maze;

/* This class implements the model that is being observed by the MazeApp */

public final class MazeAppModel {

    private Maze maze; // the maze that the view displays
    private String currentEditionMode; // tells what type of box to add
    private boolean editEnabled; // tells whether edition mode is on or off
    private boolean displaySolution; // tells whether or not to display the solution
    private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>(); // all the observers that observe
                                                                                   // this model
    private boolean rebuildLabyrinth; // tells whether or not the maze has to be rebuilt

    public MazeAppModel() {
        maze = new Maze(10, 10); // by default, initialize with a 10 by 10 maze
        currentEditionMode = "Empty";
        editEnabled = false;
        displaySolution = false;
        rebuildLabyrinth = false;
    }

    // method to be called whenever a change is made to the model, in order to
    // notifiy all the observers
    public final void stateChanges() {
        ChangeEvent evt = new ChangeEvent(this);
        for (ChangeListener listener : listeners)
            listener.stateChanged(evt);
    }

    /*
     * Below are only getters and setter whose name are explicit.
     * Every setter triggers the launch of the stateChanges method, because by
     * definition setters make changes to the model
     */

    public final void setMaze(Maze maze) {
        this.maze = maze;
        stateChanges();
    }

    public final Maze getMaze() {
        return maze;
    }

    public final void setCurrentEditionMode(String currentEditionMode) {
        this.currentEditionMode = currentEditionMode;
        stateChanges();
    }

    public final String getCurrentEditionMode() {
        return currentEditionMode;
    }

    public final void setEditEnabled(boolean editEnabled) {
        this.editEnabled = editEnabled;
        stateChanges();
    }

    public final boolean getEditEnabled() {
        return editEnabled;
    }

    public final void setDisplaySolution(boolean displaySolution) {
        this.displaySolution = displaySolution;
        stateChanges();
    }

    public final boolean getDisplaySolution() {
        return displaySolution;
    }

    public final void setRebuildLabyrinth(boolean rebuildLabyrinth) {
        this.rebuildLabyrinth = rebuildLabyrinth;
        stateChanges();
    }

    public final boolean getRebuildLabyrinth() {
        return rebuildLabyrinth;
    }

    public final void addObserver(ChangeListener listener) {
        listeners.add(listener);
    }

    public final boolean isArrivalSet() {
        return (maze.getArrival() != null);
    }

    public final boolean isDepartureSet() {
        return (maze.getDeparture() != null);
    }

    public final void setMazeDeparture(VertexInterface departure) {
        maze.setDeparture(departure);
        stateChanges();
    }

    public final void setMazeArrival(VertexInterface arrival) {
        maze.setArrival(arrival);
        stateChanges();
    }

    public final void setBox(int i, int j, VertexInterface box) {
        maze.setBox(i, j, box);
        stateChanges();
    }

}

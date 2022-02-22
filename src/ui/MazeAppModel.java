package ui;

import java.util.ArrayList;

import javax.swing.event.*;

import dijkstra.VertexInterface;
import maze.Maze;

public final class MazeAppModel {

    private Maze maze;
    private String currentEditionMode;
    private boolean editEnabled;
    private boolean displaySolution;
    private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();
    private boolean rebuildLabyrinth;

    public MazeAppModel() {
        maze = new Maze(10, 10);
        currentEditionMode = null;
        editEnabled = false;
        displaySolution = false;
        rebuildLabyrinth = false;
    }

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

    public final void stateChanges() {
        ChangeEvent evt = new ChangeEvent(this);
        for (ChangeListener listener : listeners)
            listener.stateChanged(evt);
    }

}

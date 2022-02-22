package ui;

import java.util.ArrayList;

import javax.swing.event.*;

import maze.Maze;

public final class MazeAppModel {

    private Maze maze;
    private String currentEditionMode;
    private boolean modified;
    private boolean editEnabled;
    private boolean displaySolution;
    private ArrayList<ChangeListener> listeners 
          = new ArrayList<ChangeListener>() ;

    public MazeAppModel() {
        maze = new Maze(10, 10);
        currentEditionMode = null;
        modified = false;
        editEnabled = false;
        displaySolution = false; 
    }

    public final void setMaze(Maze maze) {
        this.maze = maze;
        stateChanges();
    }

    public final Maze getMaze() {
        return maze;
    }

    public final void setModified(boolean modified) {
        this.modified = modified;
        stateChanges();
    }

    public final boolean getModified() {
        return modified;
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

    public final boolean getEditEnabled(){
        return editEnabled;
    }

    public final void setDisplaySolution(boolean displaySolution){
        this.displaySolution = displaySolution;
        stateChanges();
    }

    public final boolean getDisplaySolution(){
        return displaySolution;
    }

    public final void addObserver(ChangeListener listener){
        listeners.add(listener);
    }

    public void stateChanges() {
        ChangeEvent evt = new ChangeEvent(this) ;
        for (ChangeListener listener : listeners)
		listener.stateChanged(evt);
    }
}

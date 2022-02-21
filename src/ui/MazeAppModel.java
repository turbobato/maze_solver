package ui;

import maze.Maze;

public final class MazeAppModel {

    private Maze maze;
    private String currentEditionMode;
    private boolean modified;
    private boolean editEnabled;

    public MazeAppModel() {
        maze = null;
        currentEditionMode = null;
        modified = false;
    }

    public final void setMaze(Maze maze) {
        this.maze = maze;
    }

    public final Maze getMaze() {
        return maze;
    }

    public final void setModified(boolean modified) {
        this.modified = modified;
    }

    public final boolean getModified() {
        return modified;
    }

    public final void setCurrentEditionMode(String currentEditionMode) {
        this.currentEditionMode = currentEditionMode;
    }

    public final String getCurrentEditionMode() {
        return currentEditionMode;
    }

    public final void setEditEnabled(boolean editEnabled) {
        this.editEnabled = editEnabled;
    }

    public final boolean getEditEnabled(){
        return editEnabled;
    }
}

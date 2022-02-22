package ui;

import javax.swing.*;
import java.awt.*;

public final class ButtonsPanel extends JPanel {
    
    private final CreateMaze createMaze;
    private final LoadMaze loadMaze;
    private final SaveMaze saveMaze;
    private final EditMaze editMaze;
    private final EditEnable editEnable;
    private final SolveMaze solveMaze;

    public ButtonsPanel(MazeApp mazeApp){
        super();
        setLayout(new GridLayout(6,1));
        add(createMaze = new CreateMaze(mazeApp));
        add(loadMaze = new LoadMaze(mazeApp));
        add(saveMaze = new SaveMaze(mazeApp));
        add(editMaze = new EditMaze (mazeApp));
        add(editEnable = new EditEnable(mazeApp));
        add(solveMaze = new SolveMaze(mazeApp));
    }

    public void notifyForUpdate(){
    createMaze.notifyForUpdate();
    loadMaze.notifyForUpdate();
    saveMaze.notifyForUpdate();
    editMaze.notifyForUpdate();
    editEnable.notifyForUpdate();
    solveMaze.notifyForUpdate();
    }

}

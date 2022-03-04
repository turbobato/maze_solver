package ui;

import javax.swing.*;
import java.awt.*;

/* This class extends the JPanel class to describe the right panel of the UI,
which contains all the buttons. To see what each button does, see the classes
named after each button.*/

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

    // called whenever the model is modified, to update the view
    public void notifyForUpdate(){
        createMaze.notifyForUpdate();
        loadMaze.notifyForUpdate();
        saveMaze.notifyForUpdate();
        editMaze.notifyForUpdate();
        editEnable.notifyForUpdate();
        solveMaze.notifyForUpdate();
    }

}

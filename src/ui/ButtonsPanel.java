package ui;

import javax.swing.*;
import java.awt.*;

public final class ButtonsPanel extends JPanel {
    
    private final MazeButton loadButton;
    private final MazeButton saveButton;
    private final MazeButton editMaze;
    private final MazeButton solveMaze;
    private final MazeButton exitMaze;

    public ButtonsPanel(MazeApp mazeApp){
        super();
        setLayout(new GridLayout(5,1));
        add(loadButton = new MazeButton("Load from file", mazeApp));
        add(saveButton = new MazeButton("Save to file", mazeApp));
        add(editMaze = new MazeButton("Edit", mazeApp));
        add(solveMaze = new MazeButton("Solve", mazeApp));
        add(exitMaze = new MazeButton("Exit", mazeApp));
    }

}

package ui;

import javax.swing.*;

public final class MazePanel extends JPanel {

    private final MazeApp mazeApp;
    private final MBoxPanel[][] boxes;

    public MazePanel(MazeApp mazeApp){
        super();
        this.mazeApp=mazeApp;
        boxes=null;
    }
    
}

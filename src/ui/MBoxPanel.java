package ui;

import javax.swing.*;
import java.awt.*;

public abstract class MBoxPanel extends JPanel {

    private final MazeApp mazeApp;
    private final Color color;

    public MBoxPanel(MazeApp mazeApp, Color color){
        super();
        this.mazeApp = mazeApp;
        this.color = color;
        setBackground(color);
        setPreferredSize(new Dimension(8,8));

    }
    
}

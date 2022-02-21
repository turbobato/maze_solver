package ui;

import javax.swing.*;
import java.awt.*;

public final class WindowPanel extends JPanel {

    private final ButtonsPanel buttonsPanel;
    private final MazePanel mazePanel;

    public WindowPanel(MazeApp mazeApp){
        super();
        setLayout(new BorderLayout());
        add(buttonsPanel = new ButtonsPanel(mazeApp), BorderLayout.CENTER);
        add(mazePanel = new MazePanel(mazeApp), BorderLayout.WEST);
    }
    
}

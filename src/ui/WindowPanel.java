package ui;

import javax.swing.*;
import java.awt.*;

public final class WindowPanel extends JPanel {

    private final ButtonsPanel buttonsPanel;
    private final MazePanel mazePanel;

    public WindowPanel(MazeApp mazeApp){ //works but the sizes are screwed
        super();
        setLayout(new BorderLayout());
        add(buttonsPanel = new ButtonsPanel(mazeApp), BorderLayout.CENTER);
        add(mazePanel = new MazePanel(mazeApp), BorderLayout.WEST);
        buttonsPanel.setPreferredSize(new Dimension(200, 600));
        mazePanel.setPreferredSize(new Dimension(600, 600));
    }
    public final void notifyForUpdate(){
        buttonsPanel.notifyForUpdate();
        mazePanel.notifyForUpdate();
    }
}

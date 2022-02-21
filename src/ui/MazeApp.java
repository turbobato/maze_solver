package ui;

import javax.swing.*;

public final class MazeApp extends JFrame {

    private final WindowPanel windowPanel;

    public MazeApp() {
        super("Maze Application");
        this.windowPanel= new WindowPanel(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

}
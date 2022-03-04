package ui;

import javax.swing.event.*;
import javax.swing.*;

/* This class describes the main frame containing our UI app, and functions
with an observer-observable pattern with the MazeAppModel class.
Hence it extends JFrame and implements ChangeListener*/

public final class MazeApp extends JFrame implements ChangeListener {

    private final WindowPanel windowPanel;
    private final ImageIcon img = new ImageIcon("data/icon.jpg");
    private MazeAppModel mazeAppModel = new MazeAppModel(); // the model that is being observed

    public MazeApp() {
        super("Maze Application");
        setIconImage(img.getImage());
        mazeAppModel.addObserver(this); // registers to the model
        this.windowPanel = new WindowPanel(this);
        add(windowPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public final void setModel(MazeAppModel mazeAppModel) {
        this.mazeAppModel = mazeAppModel;
    }

    public final MazeAppModel getModel() {
        return mazeAppModel;
    }

    // method that is run when the model tells it has been modified
    public void stateChanged(ChangeEvent evt) {
        windowPanel.notifyForUpdate();
    }

}
package ui;

import javax.swing.*;
import java.awt.*;

/* This class describes the behaviour of the main Panel.
It extends JPanel*/

public final class WindowPanel extends JPanel {

    private final ButtonsPanel buttonsPanel;
    private final MazePanel mazePanel;

    public WindowPanel(MazeApp mazeApp) { 
        super();
        setLayout(new BorderLayout());
        add(buttonsPanel = new ButtonsPanel(mazeApp), BorderLayout.CENTER);
        add(mazePanel = new MazePanel(mazeApp), BorderLayout.WEST);
        buttonsPanel.setPreferredSize(new Dimension(200, 600));
        mazePanel.setPreferredSize(new Dimension(600, 600));
        JOptionPane.showMessageDialog(mazeApp, // help message when launching the app
                "Welcome to this maze editer/solver\n" 
                +"Here I provide some help : in grey, the walls, in white, the empty boxes, in blue the departure, in red the arrival and in yellow the path to arrival \n"
                +"If a button is green, it means the option associated with it is enabled, if it is red it means it is disabled\n"
                +"Happy maze editing !",
                "Help",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // called whenever the model is modified, to update the view
    public final void notifyForUpdate() {
        buttonsPanel.notifyForUpdate();
        mazePanel.notifyForUpdate();
    }
}

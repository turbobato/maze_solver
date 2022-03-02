package ui;

import javax.swing.*;
import java.awt.*;

public final class WindowPanel extends JPanel {

    private final ButtonsPanel buttonsPanel;
    private final MazePanel mazePanel;

    public WindowPanel(MazeApp mazeApp) { // works but the sizes are screwed
        super();
        setLayout(new BorderLayout());
        add(buttonsPanel = new ButtonsPanel(mazeApp), BorderLayout.CENTER);
        add(mazePanel = new MazePanel(mazeApp), BorderLayout.WEST);
        buttonsPanel.setPreferredSize(new Dimension(200, 600));
        mazePanel.setPreferredSize(new Dimension(600, 600));
        JOptionPane.showMessageDialog(mazeApp,
                "Welcome to this maze editer/solver\n" 
                +"Here I provide some help : in grey, the walls, in white, the empty boxes, in blue the departure, in red the arrival and in yellow the path to arrival \n"
                +"If a button is green, it means the option associated with it is enabled, if it is red it means it is disabled\n"
                +"Happy maze editing !",
                "Help",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public final void notifyForUpdate() {
        buttonsPanel.notifyForUpdate();
        mazePanel.notifyForUpdate();
    }
}

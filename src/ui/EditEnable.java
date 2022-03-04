package ui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/* This class describes the behaviour of a button which, when clicked, will enable
edit mode and make it so clicks on the boxes will change the boxes. 
It extends JButton, and implements ActionListener in order to describe
the behaviour of the button when clicked*/

public final class EditEnable extends JButton implements ActionListener {

    private final MazeApp mazeApp;

    public EditEnable(MazeApp mazeApp) {
        super("Enable edit mode");
        this.mazeApp = mazeApp;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt) {
        MazeAppModel mazeAppModel = mazeApp.getModel();
        mazeAppModel.setEditEnabled(!mazeAppModel.getEditEnabled()); // when click, invert the value of the editEnabled
                                                                     // field
    }

    // we override paintComponent to make it so the button changes color when
    // clicked
    @Override
    protected void paintComponent(Graphics g) {
        MazeAppModel mazeAppModel = mazeApp.getModel();
        if (mazeAppModel.getEditEnabled()) {
            setBackground(Color.GREEN); // if edit mode is enabled, the button is Green
        } else {
            setBackground(Color.RED); // if diasabled, it is red
        }
        super.paintComponent(g);
    }

    // called whenever the model is modified, to update the view
    public void notifyForUpdate() {
        setEnabled(!mazeApp.getModel().getDisplaySolution()); // we disable edit mode when displaying solution, to avoid
                                                              // issues
        this.repaint(); // repaint to update the color
    }
}

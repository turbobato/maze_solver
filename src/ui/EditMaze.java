package ui;

import javax.swing.*;
import java.awt.event.*;

/* This class describes the behaviour of a button which allows to choose what
box will be added when clicking on the maze. It extends JButton and implements
ActionListener to describe the behaviour of the button*/

public final class EditMaze extends JButton implements ActionListener {

    private final MazeApp mazeApp;
    private final String[] optionsToChoose = { "Wall", "Empty", "Arrival", "Departure" };

    public EditMaze(MazeApp mazeApp) {
        super("Type of box to add");
        this.mazeApp = mazeApp;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt) {
        MazeAppModel mazeAppModel = mazeApp.getModel();
        String editMode = (String) JOptionPane.showInputDialog(null, // drop down menu to choose between the four
                                                                     // options
                "Choose what you want to add", "Chose edit mode",
                JOptionPane.INFORMATION_MESSAGE, null,
                optionsToChoose, mazeAppModel.getCurrentEditionMode());
        if (editMode != null) { // we test that editMode is not null to ensure the user hasn't pressed on the
                                // cancel button and has effectively chosen an editMode
            mazeAppModel.setCurrentEditionMode(editMode);
        }
    }

    // called whenever the model is modified, to update the view
    public void notifyForUpdate() {
    } // here there is nothing to update, but we keep this method empty in a goal of
      // global coherence of the app
}

package ui;

import javax.swing.*;
import java.awt.event.*;

public final class EditMaze extends JButton implements ActionListener {

    private final MazeApp mazeApp;
    private final String[] optionsToChoose = { "Wall", "Empty", "Arrival", "Departure" };

    public EditMaze(MazeApp mazeApp) {
        super("Type of box to add");
        this.mazeApp = mazeApp;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt){
        MazeAppModel mazeAppModel = mazeApp.getModel();
        String editMode = (String) JOptionPane.showInputDialog(null,
            "Choose what you want to add", "Chose edit mode",
            JOptionPane.INFORMATION_MESSAGE, null,
            optionsToChoose, optionsToChoose[0]);
        if (editMode != null){
            mazeAppModel.setCurrentEditionMode(editMode);
        }
    }

}

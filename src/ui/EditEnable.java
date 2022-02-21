package ui;

import javax.swing.*;
import java.awt.event.*;

public final class EditEnable extends JButton implements ActionListener {
    
    private final MazeApp mazeApp;

    public EditEnable(MazeApp mazeApp){
        super("Enable edit mode");
        this.mazeApp = mazeApp;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt){
        MazeAppModel mazeAppModel = mazeApp.getModel();
        mazeAppModel.setEditEnabled(!mazeAppModel.getEditEnabled());
    }

}

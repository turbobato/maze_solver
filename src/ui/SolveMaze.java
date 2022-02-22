package ui;

import javax.swing.*;
import java.awt.event.*;

public final class SolveMaze extends JButton implements ActionListener {
    
    private final MazeApp mazeApp;

    public SolveMaze(MazeApp mazeApp){
        super("Display Solution");
        this.mazeApp = mazeApp;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt){
        MazeAppModel mazeAppModel = mazeApp.getModel();
        mazeAppModel.setDisplaySolution(!mazeAppModel.getDisplaySolution());
    }
    public void notifyForUpdate(){
        
    }
}
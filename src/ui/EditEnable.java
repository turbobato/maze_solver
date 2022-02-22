package ui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public final class EditEnable extends JButton implements ActionListener {
    
    private final MazeApp mazeApp;

    public EditEnable(MazeApp mazeApp){ //this one works 
        super("Enable edit mode");
        this.mazeApp = mazeApp;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt){
        MazeAppModel mazeAppModel = mazeApp.getModel();
        mazeAppModel.setEditEnabled(!mazeAppModel.getEditEnabled());
    }

    @Override protected void paintComponent(Graphics g){
        MazeAppModel mazeAppModel = mazeApp.getModel();
        if (mazeAppModel.getEditEnabled()){
            setBackground(Color.GREEN);
        }
        else {
            setBackground(Color.RED);
        }
        super.paintComponent(g);
    }
    public void notifyForUpdate(){
        setEnabled(!mazeApp.getModel().getDisplaySolution());
        this.repaint();
    }
}

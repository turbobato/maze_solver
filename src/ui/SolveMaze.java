package ui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

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
        mazeAppModel.setEditEnabled(false);
    }
    
    @Override protected void paintComponent(Graphics g){
        MazeAppModel mazeAppModel = mazeApp.getModel();
        if (mazeAppModel.getDisplaySolution()){
            setBackground(Color.GREEN);
        }
        else {
            setBackground(Color.RED);
        }
        super.paintComponent(g);
    }
    public void notifyForUpdate(){
        this.repaint();
    }
}
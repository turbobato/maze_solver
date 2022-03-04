package ui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/* This class describes the behaviour of the button used to display
the solution of the maze. It extends JButton and implements ActionListener to describe the behaviour of the button*/

public final class SolveMaze extends JButton implements ActionListener {
    
    private final MazeApp mazeApp;

    public SolveMaze(MazeApp mazeApp){
        super("Display Solution");
        this.mazeApp = mazeApp;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt){
        MazeAppModel mazeAppModel = mazeApp.getModel();
        mazeAppModel.setDisplaySolution(!mazeAppModel.getDisplaySolution()); // when clicked, inverts the boolean displaySolution
        mazeAppModel.setRebuildLabyrinth(!mazeAppModel.getDisplaySolution()); // rebuild maze is display solution went from true to false
        mazeAppModel.setEditEnabled(false); // disable edit mode while solution is displayed to avoid issues
    }
    
    // we override paintComponent to make it so the button changes color when
    // clicked
    @Override protected void paintComponent(Graphics g){
        MazeAppModel mazeAppModel = mazeApp.getModel();
        if (mazeAppModel.getDisplaySolution()){
            setBackground(Color.GREEN); // if edit mode is enabled, the button is Green
        }
        else {
            setBackground(Color.RED); // if diasabled, it is red
        }
        super.paintComponent(g);
    }

    // called whenever the model is modified, to update the view
    public void notifyForUpdate(){
        this.repaint(); // repaint to update the color
    }
}
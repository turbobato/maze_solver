package ui;

import javax.swing.*;
import java.awt.event.*;

public final class CreateMaze extends JButton implements ActionListener {
    
    private final MazeApp mazeApp;

    public CreateMaze(MazeApp mazeApp){
        super("Create a new maze");
        this.mazeApp = mazeApp;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt){
        
    }
}
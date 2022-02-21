package ui;

import javax.swing.*;

import maze.Maze;

import java.awt.event.*;
import java.io.File;
   
public final class SaveMaze extends JButton implements ActionListener {

    private final MazeApp mazeApp;

    public SaveMaze(MazeApp mazeApp) {
        super("Save maze to text file");
        this.mazeApp = mazeApp;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        MazeAppModel mazeAppModel = mazeApp.getModel();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getPath();
            Maze maze = mazeAppModel.getMaze();
            maze.saveToTextFile(fileName);
        }
    }
}
package ui;

import javax.swing.*;

import maze.Maze;
import maze.MazeReadingException;

import java.awt.event.*;
import java.io.File;

public final class LoadMaze extends JButton implements ActionListener {

    private final MazeApp mazeApp;

    public LoadMaze(MazeApp mazeApp) {
        super("Load maze from text file");
        this.mazeApp = mazeApp;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        MazeAppModel mazeAppModel = mazeApp.getModel();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getPath();
            Maze maze = mazeAppModel.getMaze();
            try {
                maze.initFromTextFile(fileName);
            } catch (MazeReadingException e) {
                JOptionPane.showMessageDialog(mazeApp,
                        e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
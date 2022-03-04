package ui;

import javax.swing.*;
import maze.Maze;
import maze.MazeReadingException;
import java.awt.event.*;
import java.io.File;

/* This class describes the button that allows to load a maze from a text file.
It extends JButton and implements ActionListener to describe the behaviour of the button*/

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
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) { // if the user selected a file
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getPath(); // we get the path to this file in a String
            Maze maze = mazeAppModel.getMaze();
            try { // then we try to initialize the maze from this text file
                maze.initFromTextFile(fileName);
                mazeAppModel.setRebuildLabyrinth(true); // the maze has changed, rebuild it
            } catch (MazeReadingException e) { // if anything goes wrong, display an error message
                JOptionPane.showMessageDialog(mazeApp,
                        e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // called whenever the model is modified, to update the view
    public void notifyForUpdate() {
        setEnabled(!mazeApp.getModel().getDisplaySolution()); // disable if the solution is displayed, to avoid issues
    }
}
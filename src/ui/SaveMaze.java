package ui;

import javax.swing.*;
import maze.Maze;
import java.awt.event.*;
import java.io.File;

/* This class describes the behavious of the button used to save the maze
to a text file. It extends JButton and implements ActionListener to describe the behaviour of the button*/

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
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) { // if the user didn't press on cancel and effectively selectioned a
                                                     // file
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getPath();
            Maze maze = mazeAppModel.getMaze();
            maze.saveToTextFile(fileName);
        }
    }

    // called whenever the model is modified, to update the view
    public void notifyForUpdate() {
        setEnabled(!mazeApp.getModel().getDisplaySolution()); // disable if the solution is displayed, to avoid issues
    }
}
package ui;

import javax.swing.*;
import maze.Maze;
import java.awt.event.*;
import java.awt.*;

/* This clas describes all the components needed to create a new maze,
and extends JPanel*/

public final class CreateMaze extends JPanel {

    /*
     * the CreateMaze panel has different components that need to interact which
     * each other,
     * we choose not to create new classes for those components but to wrap them up
     * in one class,
     * in order to make it more simple
     */
    private final MazeApp mazeApp;
    private final JSpinner jSpinnerX = new JSpinner(new SpinnerNumberModel(10, 1, 30, 1)); // used to select the number
                                                                                           // of rows
    private final JSpinner jSpinnerY = new JSpinner(new SpinnerNumberModel(10, 1, 30, 1)); // used to select the number
                                                                                           // of columns
    private final JLabel labelRows = new JLabel("Rows");
    private final JLabel labelColumns = new JLabel("Columns");
    private final JLabel labelConfirm = new JLabel("Create");
    private final JButton confirmCreation; // used to confirm the creation

    public CreateMaze(MazeApp mazeApp) {
        super();
        this.mazeApp = mazeApp;
        confirmCreation = new JButton("Create");
        confirmCreation.setBackground(Color.GREEN);
        confirmCreation.addActionListener(new ActionListener() { // use of anonym classes to create a new action
                                                                 // listener
            public void actionPerformed(ActionEvent e) {
                Integer x1 = (Integer) jSpinnerX.getValue();
                Integer y1 = (Integer) jSpinnerY.getValue();
                int x = x1.intValue(); // gets the value in the rows spinner
                int y = y1.intValue(); // gets the value in the columns spinner
                MazeAppModel mazeAppModel = mazeApp.getModel();
                mazeAppModel.setDisplaySolution(false); // resets the DisplaySolution button
                mazeAppModel.setEditEnabled(false); // resets the EditEnabled button
                mazeAppModel.setMaze(new Maze(x, y)); // create a new maze
                mazeAppModel.setRebuildLabyrinth(true); // tells the app to rebuild the view
            }
        });
        setLayout(new GridLayout(2, 3));
        add(labelRows); // add all components to the panel
        add(labelColumns);
        add(labelConfirm);
        add(jSpinnerX);
        add(jSpinnerY);
        add(confirmCreation);
    }

    // called whenever the model is modified, to update the view
    public void notifyForUpdate() {
    } // here there is nothing to update, but we keep this method empty in a goal of
      // global coherence of the app
}
package ui;

import javax.swing.*;

import maze.Maze;

import java.awt.event.*;
import java.awt.*;

public final class CreateMaze extends JPanel {

    private final MazeApp mazeApp;
    private final JSpinner jSpinnerX = new JSpinner(new SpinnerNumberModel(1, 1, 30, 1));
    private final JSpinner jSpinnerY = new JSpinner(new SpinnerNumberModel(1, 1, 30, 1));
    private final JLabel labelRows = new JLabel("Rows");
    private final JLabel labelColumns = new JLabel("Columns");
    private final JLabel labelConfirm = new JLabel("Confirm Creation");
    private final JButton confirmCreation;

    public CreateMaze(MazeApp mazeApp) {
        super();
        this.mazeApp = mazeApp;
        confirmCreation = new JButton("Confirm");
        confirmCreation.setBackground(Color.GREEN);
        confirmCreation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x = ((Integer) jSpinnerX.getValue()).intValue();
                int y = ((Integer) jSpinnerY.getValue()).intValue();
                MazeAppModel mazeAppModel = mazeApp.getModel();
                mazeAppModel.setMaze(new Maze(x, y));
            }
        });
        setLayout(new GridLayout(2, 3));
        add(labelRows);
        add(labelColumns);
        add(labelConfirm);
        add(jSpinnerX);
        add(jSpinnerY);
        add(confirmCreation);
        /*ImageIcon icon = new ImageIcon("data\\checkmark.png");
        int offset = confirmCreation.getInsets().left;
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(confirmCreation.getWidth() - offset,
                confirmCreation.getHeight() - offset, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(resizedImage);
        confirmCreation.setIcon(icon);*/
    }
    public void notifyForUpdate(){
        
    }
}
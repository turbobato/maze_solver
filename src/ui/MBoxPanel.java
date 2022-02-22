package ui;

import javax.swing.*;
import java.awt.*;

public abstract class MBoxPanel extends JPanel  {

    private final MazeApp mazeApp;
    private final Color color;
    private final int x;
    private final int y;

    public MBoxPanel (MazeApp mazeApp, Color color, int x, int y) {
        super();
        this.mazeApp = mazeApp;
        this.color = color;
        this.x = x;
        this.y = y;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(this.color);
    }

    public final int getX(){
        return x;
    }

    public final int getY(){
        return y;
    }

    public final Color getColor(){
        return color;
    }

    
    /*public final void actionPerformed(ActionEvent evt) {
        MazeAppModel mazeAppModel = mazeApp.getModel();
        Maze maze = mazeAppModel.getMaze();
        String currentEditionMode = mazeAppModel.getCurrentEditionMode();
        if (currentEditionMode != null){
            if (currentEditionMode.equals("Arrival")){
                ABox box = new ABox(x, y, maze);
                maze.setArrival(box);
                maze.setBox(x, y, box);
            }
            else if (currentEditionMode.equals("Departure")){
                DBox box = new DBox(x, y, maze);
                maze.setDeparture(box);
                maze.setBox(x, y, box);
            }
            else if (currentEditionMode.equals("Wall")){
                WBox box = new WBox(x, y, maze);
                maze.setBox(x, y, box);
            }
            else if (currentEditionMode.equals("Empty")){
                EBox box = new EBox(x, y, maze);
                maze.setBox(x, y, box);
            }
        }
    }*/

}

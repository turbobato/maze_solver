package ui;

import javax.swing.*;

import dijkstra.VertexInterface;

import java.awt.*;
import maze.*;
import java.awt.event.*;

public abstract class MBoxPanel extends JPanel implements MouseListener {

    private final MazeApp mazeApp;
    private final Color color;
    private final MBox box;

    public MBoxPanel (MazeApp mazeApp, Color color, MBox box) {
        super();
        this.mazeApp = mazeApp;
        this.color = color;
        this.box = box;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(this.color);
        addMouseListener(this);
    }

    public final MBox getBox(){
        return box;
    }

    public final Color getColor(){
        return color;
    }

    public final void mousePressed(MouseEvent e) {
        MazeAppModel mazeAppModel = mazeApp.getModel();
        Maze maze = mazeAppModel.getMaze();
        String currentEditionMode = mazeAppModel.getCurrentEditionMode();
        boolean editEnabled = mazeAppModel.getEditEnabled();
        int x = box.getX();
        int y = box.getY();
        if (currentEditionMode != null && editEnabled){
            if (currentEditionMode.equals("Arrival")){
                VertexInterface box = new ABox(x, y, maze);
                if (mazeAppModel.isArrivalSet()){
                    VertexInterface previousArrival = maze.getArrival();
                    int x0 = previousArrival.getX();
                    int y0 = previousArrival.getY();
                    mazeAppModel.setMazeArrival(box);
                    mazeAppModel.setBox(x, y, box);
                    if (x0!=x || y0 != y) {
                    mazeAppModel.setBox(x0, y0, new WBox(x0, y0, maze));
                    }
                }
                else{
                    mazeAppModel.setMazeArrival(box);
                    mazeAppModel.setBox(x, y, box);    
                }
            }
            else if (currentEditionMode.equals("Departure")){
                VertexInterface box = new DBox(x, y, maze);
                if (mazeAppModel.isDepartureSet()){
                    VertexInterface previousDeparture = maze.getDeparture();
                    int x0 = previousDeparture.getX();
                    int y0 = previousDeparture.getY();
                    mazeAppModel.setMazeDeparture(box);
                    mazeAppModel.setBox(x, y, box);
                    if (x0 != x || y0 != y) {
                    mazeAppModel.setBox(x0, y0, new WBox(x0, y0, maze));
                    }
                }
                else{
                    mazeAppModel.setMazeDeparture(box);
                    mazeAppModel.setBox(x, y, box);    
                }
            }
            else if (currentEditionMode.equals("Wall")){
                VertexInterface previous = maze.getBox(x, y);
                if (previous.getLabel().equals("A")){
                    mazeAppModel.setMazeArrival(null);
                }
                else if (previous.getLabel().equals("D")){
                    mazeAppModel.setMazeDeparture(null);
                }
                VertexInterface box = new WBox(x, y, maze);
                mazeAppModel.setBox(x, y, box);
            }
            else if (currentEditionMode.equals("Empty")){
                VertexInterface previous = maze.getBox(x, y);
                if (previous.getLabel().equals("A")){
                    mazeAppModel.setMazeArrival(null);
                }
                else if (previous.getLabel().equals("D")){
                    mazeAppModel.setMazeDeparture(null);
                }
                VertexInterface box = new EBox(x, y, maze);
                mazeAppModel.setBox(x, y, box);
            }
        }
        mazeAppModel.setRebuildLabyrinth(true);
        
	}
	public final void mouseClicked(MouseEvent e) {}

	public final void mouseReleased(MouseEvent e) {}

	public final void mouseEntered(MouseEvent e) {}
	
	public final void mouseExited(MouseEvent e) {}

}

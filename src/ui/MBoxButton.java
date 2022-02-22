package ui;

import javax.swing.*;

import dijkstra.VertexInterface;
import maze.MBox;

import java.awt.*;

public abstract class MBoxButton extends JButton {

    private final MazeApp mazeApp;
    private final Color color;
    private final VertexInterface box;

    public MBoxButton(MazeApp mazeApp, VertexInterface box, Color color){
        super();
        this.mazeApp = mazeApp;
        this.color = color;
        this.box = box;
        setBackground(this.color);
    }
    public final VertexInterface getBox(){
        return box;
    }
}

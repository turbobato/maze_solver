package ui;

import java.awt.Color;

import dijkstra.VertexInterface;

public final class WBoxButton extends MBoxButton {

    public WBoxButton(MazeApp mazeApp, VertexInterface box){
        super(mazeApp, box, Color.GRAY);
    }
    
}

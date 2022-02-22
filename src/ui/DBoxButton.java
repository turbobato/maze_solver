package ui;

import java.awt.Color;

import dijkstra.VertexInterface;

public final class DBoxButton extends MBoxButton {

    public DBoxButton(MazeApp mazeApp, VertexInterface box){
        super(mazeApp, box, Color.GREEN);
    }
    
}

package ui;

import java.awt.Color;

import dijkstra.VertexInterface;

public final class ABoxButton extends MBoxButton {

    public ABoxButton(MazeApp mazeApp, VertexInterface box){
        super(mazeApp, box, Color.RED);
    }
    
}

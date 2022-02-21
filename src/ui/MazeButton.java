package ui;

import javax.swing.*;

public final class MazeButton extends JButton{
    
    private final MazeApp mazeApp;

    public MazeButton(String str, MazeApp mazeApp){
        super(str);
        this.mazeApp = mazeApp;
    }

}

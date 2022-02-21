package ui;

import javax.swing.*;
import java.awt.*;

public final class MazePanel extends JPanel {

    private final MazeApp mazeApp;
    private final MBoxPanel[][] boxes;

    public MazePanel(MazeApp mazeApp){
        super();
        this.mazeApp=mazeApp;
        boxes= new MBoxPanel[10][10];
        setLayout(new GridLayout(10,10));
        for (int i= 0; i< 10; i++){
            for (int j=0; j<10; j++){
                add(new WBoxPanel(mazeApp));
            }
        }
    }
    
}

package ui;

import java.awt.Color;
import maze.*;

/* This class implements the boxes of type Wall in the ui,
extending the abstract class MBoxPanel*/

public final class WBoxPanel extends MBoxPanel {

    public WBoxPanel(MazeApp mazeApp, MBox box){
        super(mazeApp, Color.GRAY, box);
    }
    
}

package ui;

import java.awt.Color;
import maze.*;

/* This class implements the boxes of type Empty in the ui,
extending the abstract class MBoxPanel*/

public final class EBoxPanel extends MBoxPanel {

    public EBoxPanel(MazeApp mazeApp, MBox box){
        super(mazeApp, Color.WHITE, box);
    }
    
}

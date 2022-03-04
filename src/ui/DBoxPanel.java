package ui;

import java.awt.Color;
import maze.*;

/* This class implements the boxes of type Departure in the ui,
extending the abstract class MBoxPanel*/

public final class DBoxPanel extends MBoxPanel {

    public DBoxPanel(MazeApp mazeApp, MBox box){
        super(mazeApp, Color.BLUE, box);
    }

}

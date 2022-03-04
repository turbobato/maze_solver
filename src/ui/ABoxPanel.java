package ui;

import java.awt.Color;
import maze.*;

/* This class implements the boxes of type Arrival in the ui,
extending the abstract class MBoxPanel*/

public final class ABoxPanel extends MBoxPanel {

    public ABoxPanel(MazeApp mazeApp, MBox box) {
        super(mazeApp, Color.RED, box);
    }

}

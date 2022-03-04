package ui;

import java.awt.Color;
import maze.*;

/* This class implements the boxes used to display the solution in the ui,
extending the abstract class MBoxPanel*/

public final class SolBoxPanel extends MBoxPanel {

    public SolBoxPanel(MazeApp mazeApp, MBox box) {
        super(mazeApp, Color.YELLOW, box);
    }

}

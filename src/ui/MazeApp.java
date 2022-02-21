package ui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public final class MazeApp extends JFrame implements Observer {

    private final WindowPanel windowPanel;
    private final ImageIcon img = new ImageIcon("data\\icon.jpg");
    private MazeAppModel mazeAppModel = new MazeAppModel();


    public MazeApp() {
        super("Maze Application");
        setIconImage(img.getImage());
        this.windowPanel= new WindowPanel(this);
        add(windowPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public final void setModel(MazeAppModel mazeAppModel){
        this.mazeAppModel=mazeAppModel;
    }

    public final MazeAppModel getModel(){
        return mazeAppModel;
    }

    public final void update(Observable o, Object arg) {
        notifyForUpdate();
    }

    public final void notifyForUpdate(){
        windowPanel.notifyForUpdate();
    }

}
package ui;

import javax.swing.event.*;

import javax.swing.*;

public final class MazeApp extends JFrame implements ChangeListener {

    private final WindowPanel windowPanel;
    private final ImageIcon img = new ImageIcon("data\\icon.jpg");
    private MazeAppModel mazeAppModel = new MazeAppModel();


    public MazeApp() {
        super("Maze Application");
        setIconImage(img.getImage());
        this.windowPanel= new WindowPanel(this);
        add(windowPanel);
        mazeAppModel.addObserver(this);
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

    public void stateChanged(ChangeEvent evt){
        windowPanel.notifyForUpdate();
    }


}
package ui;

import javax.swing.*;

import dijkstra.VertexInterface;
import maze.*;

import java.awt.*;

public final class MazePanel extends JPanel { //this is utter trash 

    private final MazeApp mazeApp;
    private MBoxPanel[][] boxes;

    public MazePanel(MazeApp mazeApp){
        super();
        this.mazeApp=mazeApp;
        Maze maze = this.mazeApp.getModel().getMaze();
        int columns = maze.getColumns();
        int lines = maze.getLines();
        boxes = new MBoxPanel[10][10];
        setLayout(new GridLayout(10,10));
        System.out.println(lines);
        System.out.println(columns);
        for (int i= 0; i< 10; i++){
            for (int j=0; j< 10; j++){
                VertexInterface box = maze.getBox(i, j);
                
                /*if (box.getLabel().equals("D")){
                    add(boxes[i][j] = new DBoxPanel(mazeApp, box));
                }
                else if (box.getLabel().equals("A")){
                    add(boxes[i][j] = new ABoxPanel(mazeApp, box));
                }
                else if (box.getLabel().equals("W")){
                    add(boxes[i][j] = new WBoxPanel(mazeApp, box));
                }
                else if (box.getLabel().equals("E")){*/
                /*JPanel pan= new JPanel();
                pan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                add(pan);*/

                JPanel pan = new WBoxPanel(mazeApp,box.getX(),box.getY());  
                add(pan);
                
                //}
            }
        }
    }
/*
    private void buildBoxes()
    {
        
        Maze maze = this.mazeApp.getModel().getMaze();
        int columns = maze.getColumns();
        int lines = maze.getLines();
        //boxes= new MBoxButton[lines][columns];
        setLayout(new GridLayout(lines,columns));
        for (int i= 0; i< columns; i++){
            for (int j=0; j<lines; j++){
                VertexInterface box = maze.getBox(i, j);
                MazeBox b=null;
                if (box.getLabel().equals("D")){
                    b=(new DBoxButton(mazeApp, box));
                }
                else if (box.getLabel().equals("A")){
                    b=(new ABoxButton(mazeApp, box));
                }
                else if (box.getLabel().equals("W")){
                    b=(new WBoxButton(mazeApp, box));
                }
                else if (box.getLabel().equals("E")){
                    b=(new EBoxButton(mazeApp, box));
                } 
                add(b);
                boxes.add(b);
            }
        }
    }
/*
    @Override 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Maze maze = this.mazeApp.getModel().getMaze();
        int columns = maze.getColumns();
        int lines = maze.getLines();
        boxes = new MBoxButton[lines][columns];
        setLayout(new GridLayout(lines,columns));
        for (int i= 0; i< columns; i++){
            for (int j=0; j<lines; j++){
                VertexInterface box = maze.getBox(i, j);
                if (box.getLabel().equals("D")){
                    add(new DBoxButton(mazeApp, box));
                }
                else if (box.getLabel().equals("A")){
                    add(new ABoxButton(mazeApp, box));
                }
                else if (box.getLabel().equals("W")){
                    add(new WBoxButton(mazeApp, box));
                }
                else if (box.getLabel().equals("E")){
                    add(new EBoxButton(mazeApp, box));
                }
            }  
        }  
    }
*/
    public void notifyForUpdate(){
       /* revalidate();
        repaint();
        Maze maze = this.mazeApp.getModel().getMaze();
        for (MazeBox b : boxes)
        {
                b.notifyForUpdate(); 
        }*/
        
    }
}

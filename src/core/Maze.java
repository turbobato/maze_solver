package core;

import java.util.ArrayList;

import interfaces.GraphInterface;
import interfaces.VertexInterface;

public class Maze implements GraphInterface{
    
    private ArrayList<ArrayList<VertexInterface>> boxes;

    public Maze(ArrayList<ArrayList<VertexInterface>> boxes){
        this.boxes=boxes;   
    }

    public ArrayList<VertexInterface> GetVerticies (){
        ArrayList<VertexInterface> AllVerticies;
        AllVerticies = boxes.get(0);
        for (int i=1 ; i<boxes.size(); i++){
            AllVerticies.addAll(boxes.get(i));
        }
        return AllVerticies;
    }
    public int GetCount(){
        return boxes.size()*boxes.get(0).size();
    }
    public int GetWeight(VertexInterface v1, VertexInterface v2){
        MBox b1 = (MBox) v1, b2 = (MBox) v2;
        if (b1.isNeighbour(b2)){
            return 1;
        }
        else{
            return Integer.MAX_VALUE;
        }
    }
    private boolean isInMaze(int x, int y){ //regarde si la case d'indice (x,y) est dans le labyrinthe 
        int n = boxes.size() , m = boxes.get(0).size();
        return ((x<n)&&(y<m));
    }
    public ArrayList<VertexInterface> Neighbours (VertexInterface v){
        MBox b = (MBox) v;
        int x = b.GetX() , y = b.GetY();
        ArrayList<VertexInterface> resultat = new ArrayList<VertexInterface>();
        for (int i=x-1; i <= x+1; i++){
            for (int j=y-1; j<=y+1; j++){
                if(isInMaze(i,j)&&i!=j){ //on exclu le cas i=j
                    MBox candidate = (MBox) boxes.get(i).get(j); //potentiel voisin, reste à vérifier s'il est un mur
                    if (!candidate.isWall()){
                        resultat.add(candidate);
                    }
                }
            }
        }
        return resultat;
    }
}


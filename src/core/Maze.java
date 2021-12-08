package core;

import java.util.ArrayList;
import java.io.*;

import interfaces.GraphInterface;
import interfaces.VertexInterface;

public class Maze implements GraphInterface{
    
    private ArrayList<ArrayList<VertexInterface>> boxes;

    public Maze(){ //initialise un labyrinthe vide (pour plus tard l'initialiser avec un fichier texte par exemple)
        this.boxes=null;
    }

    public Maze(ArrayList<ArrayList<VertexInterface>> boxes){ //initialise un labyrinthe à partir de la liste de ses boxes
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
    public final void initFromTextFile(String fileName)
        throws MazeReadingException
    {
        BufferedReader is = null;
        try {
            is = new BufferedReader(new FileReader(fileName));
            int columns = is.readLine().length(); //on récupère le nombre de caractères dans la première ligne du fichier test (qui devra correspondre au nombre de colonnes)
            int lines = 1; //on initialise le nombre de lignes à 1 car on a déjà lu la première ligne avec l'instruction précédente
            String temp = is.readLine();
            while(temp != null){ //boucle qui lit le fichier ligne à ligne
                lines++; //on incrémente le nombre de lignes 
                if (temp.length()!=columns) { //on vérifie qu'il y a bien le même nombre de colonnes à chaque ligne
                    throw new MazeReadingException(fileName, lines, "Le labyrinthe n'est pas rectangulaire");
                }
                temp=is.readLine(); //on passe à la ligne suivante
            } 
               
            boxes = new ArrayList<ArrayList<VertexInterface>>(lines); //on initialise le labyrinthe à la bonne taille (ici le bon nombre de lignes)
            for (int i=0; i<lines; i++){
                boxes.add(i, new ArrayList<VertexInterface>(columns)); //on met le bon nombre de colonnes à chaque ligne
            }
            is = new BufferedReader(new FileReader(fileName));
            for (int i= 0; i< lines; i++){
                String line = is.readLine();
                for (int j=0; j< columns; j++){
                    char caractere = line.charAt(j);
                    if (caractere=='D') boxes.get(i).add(j,new DBox(i,j,this));
                    else if (caractere=='A') boxes.get(i).add(j,new ABox(i,j,this));
                    else if (caractere=='W') boxes.get(i).add(j,new WBox(i,j,this));
                    else if (caractere=='E') boxes.get(i).add(j,new EBox(i,j,this));
                    else {
                        throw new MazeReadingException(fileName, i, "Un caractère invalide (différent de D A W E) a été lu");
                    }
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally{
            try {
                if (is != null) is.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
       
}


package maze;

import java.util.ArrayList;
import java.io.*;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;

public class Maze implements GraphInterface {

    private ArrayList<ArrayList<VertexInterface>> boxes;
    private int lines;
    private int columns;
    private DBox departure;
    private ABox arrival;

    public Maze() { // initialise un labyrinthe vide (pour plus tard l'initialiser avec un fichier
                    // texte par exemple)
        this.boxes = null;
        lines = 0;
        columns = 0;
    }

    public Maze(String fileName) throws MazeReadingException { // initialise le labyrinthe à partir d'un fichier texte
        initFromTextFile(fileName);
    }

    public boolean isInMaze(int x, int y) { // regarde si la case d'indice (x,y) est dans le labyrinthe
        return ((x < lines) && (y < columns)&& (x>=0)&&(y>=0));
    }

    public VertexInterface getBox(int i, int j) throws MazeOutOfBoundsException { // renvoie la box en position (i, j)
        if (isInMaze(i, j)) {
            return boxes.get(i).get(j);
        } else
            throw new MazeOutOfBoundsException();

    }

    public void setBox(int i, int j, VertexInterface box) throws MazeOutOfBoundsException { // change la box à la
                                                                                            // position (i, j)
        if (isInMaze(i, j)) {
            boxes.get(i).add(j, box);
        } else
            throw new MazeOutOfBoundsException();
    }

    public int getLines() { // renvoie le nombre de lignes
        return lines;
    }

    public void setLines(int lines) { // change la valeur du nombre de lignes
        this.lines = lines;
    }

    public int getColumns() { // renvoie le nombre de colonnes
        return columns;
    }

    public void setColumns(int columns) { // change la valeur du nombre de colonnes
        this.columns = columns;
    }

    public VertexInterface getDeparture() { // renvoie la case départ
        return departure;
    }

    public VertexInterface getArrival() { // renvoie la case arrivée
        return arrival;
    }

    public void setDeparture(VertexInterface departure) { // change la case départ
        this.departure = (DBox) departure;
    }

    public void setArrival(VertexInterface arrival) { // change la case arrivée
        this.arrival = (ABox) arrival;
    }

    public ArrayList<VertexInterface> GetVerticies() { // renvoie la liste de toutes les boxes
        ArrayList<VertexInterface> AllVerticies = new ArrayList<VertexInterface>();
        for (int i = 0; i < getLines(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                AllVerticies.add(getBox(i, j));
            }
        }
        return AllVerticies;
    }

    public int GetCount() { // renvoie le nombre de cases dans le labyrinthe
        return lines * columns;
    }

    public int GetWeight(VertexInterface v1, VertexInterface v2) { // renvoie le poids d'une arrête (1 si on peut aller
                                                                   // d'une case à l'autre, +infty sinon)
        MBox b1 = (MBox) v1, b2 = (MBox) v2;
        if (b1.isNeighbour(b2)) {
            return 1;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public ArrayList<VertexInterface> Neighbours(VertexInterface v) { // renvoie la liste des voisins de v
        MBox b = (MBox) v;
        int x = b.GetX(), y = b.GetY();
        ArrayList<VertexInterface> resultat = new ArrayList<VertexInterface>();
        if (isInMaze(x-1, y)) { 
            MBox candidate = (MBox) getBox(x-1, y); // potentiel voisin, reste à vérifier s'il est un mur
            if (!candidate.isWall()) {
               resultat.add(candidate);
            }
        }
        if (isInMaze(x+1, y)) { 
            MBox candidate = (MBox) getBox(x+1, y); // potentiel voisin, reste à vérifier s'il est un mur
            if (!candidate.isWall()) {
               resultat.add(candidate);
            }
        }
        if (isInMaze(x, y-1)) { 
            MBox candidate = (MBox) getBox(x, y-1); // potentiel voisin, reste à vérifier s'il est un mur
            if (!candidate.isWall()) {
               resultat.add(candidate);
            }
        }
        if (isInMaze(x, y+1)) { 
            MBox candidate = (MBox) getBox(x, y+1); // potentiel voisin, reste à vérifier s'il est un mur
            if (!candidate.isWall()) {
               resultat.add(candidate);
            }
        }
        return resultat;
    }

    public final void initFromTextFile(String fileName)
            throws MazeReadingException {
        BufferedReader is = null;
        try {
            is = new BufferedReader(new FileReader(fileName));
            int columns = is.readLine().length(); // on récupère le nombre de caractères dans la première ligne du
                                                  // fichier test (qui devra correspondre au nombre de colonnes)
            int lines = 1; // on initialise le nombre de lignes à 1 car on a déjà lu la première ligne avec
                           // l'instruction précédente
            String temp = is.readLine();
            while (temp != null) { // boucle qui lit le fichier ligne à ligne
                lines++; // on incrémente le nombre de lignes
                if (temp.length() != columns) { // on vérifie qu'il y a bien le même nombre de colonnes à chaque ligne
                    throw new MazeReadingException(fileName, lines, "Le labyrinthe n'est pas rectangulaire");
                }
                temp = is.readLine(); // on passe à la ligne suivante
            }
            setLines(lines); // on initialise le bon nombre
            setColumns(columns);

            boxes = new ArrayList<ArrayList<VertexInterface>>(lines); // on initialise le labyrinthe à la bonne taille
                                                                      // (ici le bon nombre de lignes)
            for (int i = 0; i < lines; i++) {
                boxes.add(i, new ArrayList<VertexInterface>(columns)); // on met le bon nombre de colonnes à chaque
                                                                       // ligne
            }
            is = new BufferedReader(new FileReader(fileName));
            int DCount = 0; // on va compter le nombre de D (il faut qu'il n'y en ait qu'un...)
            int ACount = 0; // pareil pour A
            for (int i = 0; i < lines; i++) {
                String line = is.readLine();
                for (int j = 0; j < columns; j++) {
                    char caractere = line.charAt(j);
                    if (caractere == 'D') {
                        if (DCount == 0) {
                            setBox(i, j, new DBox(i, j, this));
                            setDeparture(getBox(i, j)); // on récupère le départ
                            DCount++;
                        } else
                            throw new MazeReadingException(fileName, i, "Il y a plus d'un départ"); // on a lu plus
                                                                                                    // d'une fois le
                                                                                                    // symbole D
                    } else if (caractere == 'A') {
                        if (ACount == 0) {
                            setBox(i, j, new ABox(i, j, this));
                            setArrival(getBox(i, j)); // on récupère l'arrivée
                            ACount++;
                        } else
                            throw new MazeReadingException(fileName, i, "Il y a plus d'une arrivée"); // on a lu plus
                                                                                                      // d'une fois le
                                                                                                      // symbole A
                    } else if (caractere == 'W')
                        setBox(i, j, new WBox(i, j, this));
                    else if (caractere == 'E')
                        setBox(i, j, new EBox(i, j, this));
                    else {
                        throw new MazeReadingException(fileName, i,
                                "Un caractère invalide (différent de D A W E) a été lu");
                    }
                }
            }
            if (ACount != 1 || DCount != 1) { // il faut vérifier qu'on a lu exactement un départ et exactement une
                                                  // arrivée
                    throw new MazeReadingException(fileName, lines,
                            "La lecture s'est terminée et il manque un départ ou une arrivée");
                }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public final void saveToTextFile(String fileName) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(fileName);
            for (int i = 0; i < lines - 1; i++) {
                for (int j = 0; j < columns; j++) {
                    pw.print(getBox(i, j).GetLabel());
                }
                pw.println();
            }
            for (int j = 0; j < columns; j++) {
                pw.print(getBox(lines - 1, j).GetLabel()); // on traite à partle cas de la dernière ligne (pour ne pas
                                                           // avoir un println en trop)
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null)
                pw.close(); // pas besoin de try catch car selon la documentation de printwriter, les
                            // méthodes ne throw pas d'exception (par contre les constructeurs le peuvent)
        }

    }

}

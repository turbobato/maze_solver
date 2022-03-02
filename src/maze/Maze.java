package maze;

import java.util.ArrayList;
import java.io.*;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;

/* This class implements the GraphInterface and describes the maze used in our MazeApplication,
which is composed of a grid of boxes of type VertexInterface */

public final class Maze implements GraphInterface {

    private ArrayList<ArrayList<VertexInterface>> boxes; // the matrix of boxes is described by an ArrayList of
                                                         // ArrayList
    private int lines;
    private int columns;
    private DBox departure;
    private ABox arrival;

    // initializes the maze from a text file
    public Maze(String fileName) throws MazeReadingException {
        initFromTextFile(fileName);
    }

    // initializes a maze of size lines * columns, with only EBoxes
    public Maze(int lines, int columns) {
        this.lines = lines;
        this.columns = columns;
        boxes = new ArrayList<ArrayList<VertexInterface>>();
        for (int i = 0; i < lines; i++) {
            boxes.add(i, new ArrayList<VertexInterface>());
            for (int j = 0; j < columns; j++) {
                addBox(i, j, new EBox(i, j, this));
            }
        }
    }

    // tests whether the box (x, y) is within the boundaries of the maze
    private final boolean isInMaze(int x, int y) {
        return ((x < lines) && (y < columns) && (x >= 0) && (y >= 0));
    }

    // returns the box in position (i, j), throwing a MazeOutOfBoundsException if
    // (i, j) is out of the boundaries of the maze
    public final VertexInterface getBox(int i, int j) throws MazeOutOfBoundsException {
        if (isInMaze(i, j)) {
            return boxes.get(i).get(j);
        } else
            throw new MazeOutOfBoundsException();

    }

    // changes the box in position (i, j), throwing a MazeOutOfBoundsException if
    // (i, j) is out of the boundaries of the maze
    public final void setBox(int i, int j, VertexInterface box) throws MazeOutOfBoundsException {
        if (isInMaze(i, j)) {
            boxes.get(i).set(j, box);
        } else
            throw new MazeOutOfBoundsException();
    }

    // adds a new box to position (i, j) throwing a MazeOutOfBoundsException if (i,
    // j) is out of the boundaries of the maze. Only to be used if there was nothing
    // in position (i, j previously) !!!
    public final void addBox(int i, int j, VertexInterface box) throws MazeOutOfBoundsException {
        if (isInMaze(i, j)) {
            boxes.get(i).add(j, box);
        } else
            throw new MazeOutOfBoundsException();
    }

    public final int getLines() {
        return lines;
    }

    public final void setLines(int lines) {
        this.lines = lines;
    }

    public final int getColumns() {
        return columns;
    }

    public final void setColumns(int columns) {
        this.columns = columns;
    }

    public final VertexInterface getDeparture() {
        return departure;
    }

    public final VertexInterface getArrival() {
        return arrival;
    }

    public final void setDeparture(VertexInterface departure) {
        this.departure = (DBox) departure;
    }

    public final void setArrival(VertexInterface arrival) {
        this.arrival = (ABox) arrival;
    }

    // returns the list of all boxes
    public final ArrayList<VertexInterface> getVerticies() {
        ArrayList<VertexInterface> allVerticies = new ArrayList<VertexInterface>();
        for (int i = 0; i < getLines(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                allVerticies.add(getBox(i, j));
            }
        }
        return allVerticies;
    }

    // returns the number of boxes in the maze
    public final int getCount() {
        return lines * columns;
    }

    // returns the weight between two boxes (1 if it is possible to go from v1 to
    // v2, else +infinity)
    public final int getWeight(VertexInterface v1, VertexInterface v2) {
        if (v1.isNeighbour(v2)) {
            return 1;
        } else {
            return Integer.MAX_VALUE; // Integer.MAX_VALUE represents +infinity
        }
    }

    // returns the list of neighbours of v, by testing if the adjacent boxes are in
    // the maze, and if they are not walls
    public final ArrayList<VertexInterface> neighbours(VertexInterface v) {
        MBox b = (MBox) v;
        int x = b.getX(), y = b.getY();
        ArrayList<VertexInterface> result = new ArrayList<VertexInterface>();
        if (isInMaze(x - 1, y)) {
            MBox candidate = (MBox) getBox(x - 1, y);
            if (!candidate.isWall()) {
                result.add(candidate);
            }
        }
        if (isInMaze(x + 1, y)) {
            MBox candidate = (MBox) getBox(x + 1, y);
            if (!candidate.isWall()) {
                result.add(candidate);
            }
        }
        if (isInMaze(x, y - 1)) {
            MBox candidate = (MBox) getBox(x, y - 1);
            if (!candidate.isWall()) {
                result.add(candidate);
            }
        }
        if (isInMaze(x, y + 1)) {
            MBox candidate = (MBox) getBox(x, y + 1);
            if (!candidate.isWall()) {
                result.add(candidate);
            }
        }
        return result;
    }

    // initializes the maze using a text file at location fileName
    public final void initFromTextFile(String fileName)
            throws MazeReadingException {
        BufferedReader is = null;
        try {
            is = new BufferedReader(new FileReader(fileName));
            int columns = is.readLine().length(); // the number of columns is the length of the first line
            int lines = 1; // we have already read a line, so lines starts at one
            String temp = is.readLine();
            while (temp != null) { // loop for reading the file line by line
                lines++;
                if (temp.length() != columns) { // test that all lines have the same length
                    throw new MazeReadingException(fileName, lines, "Labyrinth is not rectangular");
                }
                temp = is.readLine();
            }
            
            boxes = new ArrayList<ArrayList<VertexInterface>>();
            setLines(lines);
            setColumns(columns);

            is = new BufferedReader(new FileReader(fileName)); // we start a new BufferedReader to go trough the text
                                                               // file one again
            int DCount = 0; // we will count the number of D characters (there must be only one)
            int ACount = 0; // same for A
            for (int i = 0; i < lines; i++) {
                boxes.add(i, new ArrayList<VertexInterface>());
                String line = is.readLine();
                for (int j = 0; j < columns; j++) {
                    char caractere = line.charAt(j);
                    if (caractere == 'D') {
                        if (DCount == 0) { // test that D has been read only once
                            addBox(i, j, new DBox(i, j, this));
                            setDeparture(getBox(i, j));
                            DCount++;
                        } else
                            throw new MazeReadingException(fileName, i, "There is more than one departure");
                    } else if (caractere == 'A') { // test that A has been read only once
                        if (ACount == 0) {
                            addBox(i, j, new ABox(i, j, this));
                            setArrival(getBox(i, j));
                            ACount++;
                        } else
                            throw new MazeReadingException(fileName, i, "There is more than one arrival");
                    } else if (caractere == 'W')
                        addBox(i, j, new WBox(i, j, this));
                    else if (caractere == 'E')
                        addBox(i, j, new EBox(i, j, this));
                    else {
                        throw new MazeReadingException(fileName, i,
                                "An invalid character (different from A E D W) has been encountered");
                    }
                }
            }
            if (ACount != 1 || DCount != 1) { // test that we have one arrival and one departure
                throw new MazeReadingException(fileName, lines,
                        "The files lacks a departure or an arrival");
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

    // saves a maze to a text file at location fileName
    public final void saveToTextFile(String fileName) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(fileName);
            for (int i = 0; i < lines; i++) {
                for (int j = 0; j < columns; j++) {
                    pw.print(getBox(i, j).getLabel());
                }
                if (i != lines - 1) {
                    pw.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null)
                pw.close(); // no need to do a try catch, the documentation specifies that pw.close()
                            // doesn't throw exceptions
        }

    }

}

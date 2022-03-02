package dijkstra;

/* This interface describes the behaviour of a vertex in a maze, that has a X coordinate, a Y coordinate and a label.
In our maze application, it is implemented using the Box.java classes, in the package maze.
The names of the methods are self-explanatory
*/

public interface VertexInterface {

	public String getLabel(); 

	public boolean isNeighbour(VertexInterface b);

	public int getX();

	public int getY();
	
}

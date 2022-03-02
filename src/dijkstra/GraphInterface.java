package dijkstra;

import java.util.ArrayList;

/*This interface describes the behaviour of a weighted graph data structure.
In our dijkstra implementation, this class is implemented by the Maze class of the maze package.
*/

public interface GraphInterface {

	// returns the weight of edge (v1, V2)
	public int getWeight(VertexInterface v1, VertexInterface v2); 

	// returns the list of neighbours of v
	public ArrayList<VertexInterface> neighbours(VertexInterface v); 

	// returns the total number of verticies
	public int getCount(); 

	// returns the list of all vertifices in the graph
	public ArrayList<VertexInterface> getVerticies(); 

}

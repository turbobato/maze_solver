package dijkstra;

/*This interface describes the behaviour of a data structure used to associate int to vertexes.
 In our dijkstra implementation, this class is implemented by the Pi class.
The name of the methods are self-explanatory.
*/

public interface PiInterface {

	public int getPi(VertexInterface v);

	public void writePi(VertexInterface v, int x);

	// initializes Pi as needed for the dijkstra algorithm with v as departure,
	// which means pi(v')=
	// +infinty for every vertice differenent from the departure.
	public void initializePi(VertexInterface v);
}

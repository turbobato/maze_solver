package dijkstra;

/*This interface describes the behaviour of a data structure in which you can add elements of the type VertexInterface,
and check if a vertex is contained in the set. In our dijkstra implementation, this class is implemented by the ASet class.
The name of the methods are self-explanatory.
*/

public interface ASetInterface {

	public void addToSet(VertexInterface v);

	public boolean isInSet(VertexInterface v);
}

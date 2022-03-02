package dijkstra;

/*This interface describes the behaviour of a data structure storing items of type VertexInterface, that are 
ordered following a father to son hierarchy, needed to store minimal weight paths in dijkstra.
In our dijkstra implementation, this class is implemented by the Previous class.
The name of the methods are self-explanatory.
*/

public interface PreviousInterface {

	public VertexInterface father(VertexInterface v);

	// after executing rewrite(v1,v2) we have father(v1) = v2
	public void rewrite(VertexInterface v1, VertexInterface v2);
}

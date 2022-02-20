package dijkstra;

public interface PiInterface {

	public int getPi(VertexInterface v); // Retourne pi(v)

	public void writePi(VertexInterface v, int x); // Met la valeur de pi(v) à x

	public void initializePi(VertexInterface v); // Initialise les valeurs de pi pour Dijkstra en partant de v sur le
													// graphe g
}

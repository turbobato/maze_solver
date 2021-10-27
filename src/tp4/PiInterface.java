package tp4;

public interface PiInterface {

	public int DonnePi(VertexInterface v); //Retourne pi(v)
	
	public void EcritPi(VertexInterface v, int x); //Met la valeur de pi(v) à x
	
	public void InitialisePi(GraphInterface g, VertexInterface v); //Initialise les valeurs de pi pour Dijkstra en partant de v sur le graphe g
}

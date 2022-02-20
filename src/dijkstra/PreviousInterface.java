package dijkstra;

public interface PreviousInterface {

	public VertexInterface father(VertexInterface v); // Retourne le père de v dans un chemin optimal

	public void rewrite(VertexInterface v1, VertexInterface v2); // Met le père de v1 à la valeur v2
}

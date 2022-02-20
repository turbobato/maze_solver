package dijkstra;

public interface ASetInterface {

	public void Add(VertexInterface v); // Ajoute un sommet à l'ensemble

	public boolean isInSet(VertexInterface v); // Vérifie si v est dans A
}

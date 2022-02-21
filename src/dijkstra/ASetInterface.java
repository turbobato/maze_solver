package dijkstra;

public interface ASetInterface {

	public void addToSet(VertexInterface v); // Ajoute un sommet à l'ensemble

	public boolean isInSet(VertexInterface v); // Vérifie si v est dans A
}

package interfaces;

public interface ASetInterface {

	public void Add(VertexInterface sommet); //Ajoute un sommet à l'ensemble
	
	public boolean isInSet(VertexInterface v); //Vérifie si v est dans A
}
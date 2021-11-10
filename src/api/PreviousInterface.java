package api;

public interface PreviousInterface {
	
	public VertexInterface Pere(VertexInterface v); //Retourne le père de v dans un chemin optimal
	
	public void Rewrite(VertexInterface v1, VertexInterface v2); //Met le père de v1 à la valeur v2
}

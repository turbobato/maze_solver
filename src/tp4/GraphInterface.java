package tp4;

import java.util.ArrayList;

public interface GraphInterface {

	public int GetWeight(VertexInterface v1, VertexInterface v2); //Donne le poids de l'arrête v1,v2
	
	public ArrayList<VertexInterface> Neighbours(VertexInterface v); //Donne la liste des voisins de v
	
	
}

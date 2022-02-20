package dijkstra;

import java.util.ArrayList;

public interface GraphInterface {

	public int getWeight(VertexInterface v1, VertexInterface v2); // Donne le poids de l'arrête v1,v2

	public ArrayList<VertexInterface> neighbours(VertexInterface v); // Donne la liste des voisins de v

	public int getCount(); // Donne le nombre de sommets

	public ArrayList<VertexInterface> getVerticies(); // Donne tous les sommets du graphe

}

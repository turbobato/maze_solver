package dijkstra;

import java.util.ArrayList;

public class Dijksta {
	
	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r){
		PiInterface pi = new Pi(g);
		ASetInterface a = new ASet();
		PreviousInterface previous= new Previous();
		return dijkstra(g, r, a, pi, previous);
	}

	private static PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface a, PiInterface pi, PreviousInterface previous) {
		a.Add(r);
		VertexInterface pivot = r;
		pi.InitialisePi(r);
		int j = 1;
		while (j<g.GetCount()){
			ArrayList<VertexInterface> voisins = g.Neighbours(pivot);
			ArrayList<VertexInterface> sommets = g.GetVerticies();
			for(VertexInterface v : voisins){
				if (!a.isInSet(v)) {
					if (pi.DonnePi(pivot)+g.GetWeight(pivot,v)<pi.DonnePi(v)){
						pi.EcritPi(v,pi.DonnePi(pivot)+g.GetWeight(pivot,v));
						previous.Rewrite(v,pivot);
					}
				}

			}
			int min=Integer.MAX_VALUE;
			VertexInterface prochain=pivot;
			for (VertexInterface v : sommets){
				if (!a.isInSet(v)){
					if (pi.DonnePi(v)<min){
						prochain=v;
					}
				}
			}
			pivot=prochain;
			a.Add(pivot);
			j++;
		}
		return previous;
	}
}

package dijkstra;

import java.util.ArrayList;

public final class Dijksta {

	public final static PreviousInterface dijkstra(GraphInterface g, VertexInterface r) {
		PiInterface pi = new Pi(g);
		ASetInterface a = new ASet();
		PreviousInterface previous = new Previous();
		return dijkstra(g, r, a, pi, previous);
	}

	private final static PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface a, PiInterface pi,
			PreviousInterface previous) {
		a.addToSet(r);
		VertexInterface pivot = r;
		pi.initializePi(r);
		int j = 1;
		while (j < g.getCount()) {
			ArrayList<VertexInterface> neighbours = g.neighbours(pivot);
			ArrayList<VertexInterface> verticies = g.getVerticies();
			for (VertexInterface v : neighbours) {
				if (!a.isInSet(v)) {
					if (pi.getPi(pivot) + g.getWeight(pivot, v) < pi.getPi(v)) {
						pi.writePi(v, pi.getPi(pivot) + g.getWeight(pivot, v));
						previous.rewrite(v, pivot);
					}
				}

			}
			int min = Integer.MAX_VALUE;
			VertexInterface next = pivot;
			for (VertexInterface v : verticies) {
				if (!a.isInSet(v)) {
					if (pi.getPi(v) < min) {
						next = v;
					}
				}
			}
			pivot = next;
			a.addToSet(pivot);
			j++;
		}
		return previous;
	}
}

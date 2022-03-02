package dijkstra;

import java.util.ArrayList;

/* This class only has static methods and is used to provide an implementation of the Dijkstra algorithm
using the data types described by the interfaces of the dijkstra package.
*/

public final class Dijksta {

	/*
	 * This static method returns a data strucutre of type previous that can give
	 * the father of any vertice v
	 * in the shortest path from r to v in the graph g. By recursively iterating
	 * through previous, we can thus obtain the
	 * shortest path from r to any vertice in the graph g.
	 */

	public final static PreviousInterface dijkstra(GraphInterface g, VertexInterface r) {
		PiInterface pi = new Pi(g);
		ASetInterface a = new ASet();
		PreviousInterface previous = new Previous();
		return dijkstra(g, r, a, pi, previous);
	}

	/*
	 * This static method is only used when called in PreviousInterface
	 * dijkstra(GraphInterface g, VertexInterface r)
	 * and allows to compute previous.
	 */

	private final static PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface a,
			PiInterface pi,
			PreviousInterface previous) {
		a.addToSet(r); // the starting point is treated separately
		VertexInterface pivot = r;
		pi.initializePi(r);
		int j = 1;
		while (j < g.getCount()) { // we iterate n-1 times (j starts at 1), where n is the number of verticies in
									// the graph, so that all verticies get treated.
			ArrayList<VertexInterface> neighbours = g.neighbours(pivot);
			ArrayList<VertexInterface> verticies = g.getVerticies();
			for (VertexInterface v : neighbours) { // we go trough the neighbours of the current pivot to update pi if
													// needed
				if (!a.isInSet(v)) {
					if (pi.getPi(pivot) + g.getWeight(pivot, v) < pi.getPi(v)) {
						pi.writePi(v, pi.getPi(pivot) + g.getWeight(pivot, v));
						previous.rewrite(v, pivot);
					}
				}

			}
			int min = Integer.MAX_VALUE;
			VertexInterface next = pivot;
			for (VertexInterface v : verticies) { // we go trough all verticies to see which one will be the next pivot
													// (the one that has the smallest pi at the moment)
				if (!a.isInSet(v)) {
					if (pi.getPi(v) < min) {
						next = v;
						min = pi.getPi(v);
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

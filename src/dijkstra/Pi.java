package dijkstra;

import java.util.Hashtable;

public class Pi extends Hashtable<VertexInterface, Integer> implements PiInterface {

    private GraphInterface g; // La fonction pi est associée à un graphe

    public Pi(GraphInterface g) {
        super();
        this.g = g;
    }

    public int DonnePi(VertexInterface v) {
        return super.get(v).intValue();
    }

    public void EcritPi(VertexInterface v, int x) {
        super.remove(v);
        super.put(v, new Integer(x));
    }

    public void InitialisePi(VertexInterface v) {
        EcritPi(v, 0);
        for (VertexInterface v1 : g.GetVerticies()) {
            if (v1 != v) {
                EcritPi(v1, Integer.MAX_VALUE);
            }
        }
    }
}

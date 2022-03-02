package dijkstra;

import java.util.Hashtable;

/* This class just implements the interface PreviousInterface, using HashTables. 
See the interface PreviousInterface for further explanation on what the methods do.
We use super methods for implementing the methods needed.
*/

public final class Previous extends Hashtable<VertexInterface, VertexInterface> implements PreviousInterface {

    public Previous() {
        super();
    }

    public final VertexInterface father(VertexInterface v) {
        return super.get(v);
    }

    public final void rewrite(VertexInterface v1, VertexInterface v2) {
        super.remove(v1);
        super.put(v1, v2);
    }
}

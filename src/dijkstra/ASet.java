package dijkstra;

import java.util.HashSet;

/* This class just implements the interface ASetInterface, using HashSets. 
See the interface ASetInterface for further explanation on what the methods do.
We use super methods for implementing the methods needed.
*/

public final class ASet extends HashSet<VertexInterface> implements ASetInterface {

    public ASet() {
        super();
    }

    public final void addToSet(VertexInterface v) {
        super.add(v);
    }

    public final boolean isInSet(VertexInterface v) {
        return super.contains(v);
    }
}

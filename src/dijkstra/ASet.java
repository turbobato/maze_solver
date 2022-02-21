package dijkstra;

import java.util.HashSet;

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

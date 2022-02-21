package dijkstra;

import java.util.HashSet;

public final class ASet extends HashSet<VertexInterface> implements ASetInterface {

    public ASet() {
        super();
    }

    public void addToSet(VertexInterface v) {
        super.add(v);
    }

    public boolean isInSet(VertexInterface v) {
        return super.contains(v);
    }
}

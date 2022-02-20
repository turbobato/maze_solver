package dijkstra;

import java.util.Hashtable;

public final class Previous extends Hashtable<VertexInterface, VertexInterface> implements PreviousInterface {

    public Previous() {
        super();
    }

    public VertexInterface father(VertexInterface v) {
        return super.get(v);
    }

    public void rewrite(VertexInterface v1, VertexInterface v2) { // met le père de v1 à la valeur v2
        super.remove(v1);
        super.put(v1, v2);
    }
}

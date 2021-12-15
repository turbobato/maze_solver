package dijkstra;

import java.util.HashSet;

public class ASet extends HashSet<VertexInterface> implements ASetInterface {
    
    public ASet(){
        super();
    }

    public void Add(VertexInterface sommet){
        super.add(sommet);
    }

    public boolean isInSet(VertexInterface sommet){
        return super.contains(sommet);
    }
}

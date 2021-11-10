package core;

public abstract class MBox {

    private int x;
    private int y;

    MBox(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    public final int GetX(){
        return x;
    }
    
    public final int GetY(){
        return y;
    }
}

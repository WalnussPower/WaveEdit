package waveedit.datamodel;

public class Field {
    public static final int EMPTY = 0;
    
    public static final int WALL = 1;
    
    public static final int NEXUS = 2;
    
    final private int x;
    
    final private int y;
    
    private int kind;

    public Field(final int pX, final int pY, final int pKind) {
        x = pX;
        y = pY;
        kind = pKind;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }
    
    @Override
    public String toString(){
        return kind+" ";
    }

}

package waveedit.datamodel;

public class GameMap {

    private Field[][] map;

    private int x;

    private int y;

    public GameMap() {
        this(21, 13);
        initialize();
    }

    public GameMap(final int pXSize, final int pYSize) {
        map = new Field[pXSize][pYSize];
        x = pXSize;
        y = pYSize;
    }

    public void setField(final int pX, final int pY, final int pKind) {
        map[pX][pY] = new Field(pX, pY, pKind);
    }

    private void initialize() {
        for (int i = 0; i <= y; i++) {
            for (int j = 0; j <= x; j++) {
                setField(j, i, Field.EMPTY);
            }
        }
    }

    public Field getField(final int pX, final int pY) {
        return map[pX][pY];

    }
}

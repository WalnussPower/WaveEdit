package waveedit.datamodel;

import waveedit.Main;

public class GameMap {

    private Field[][] map;

    private int cols;

    private int rows;

    public GameMap() {
        this(21, 13);
        initialize();
    }

    public GameMap(final int pWidth, final int pHeight) {
        map = new Field[pHeight][pWidth];
        cols = pWidth;
        rows = pHeight;
    }

    public GameMap(Field[][] pMap) {
        map = new Field[pMap.length][];
        int cRow = 0;
        for(Field[] row: pMap){
            if(row==null)
                throw new IllegalArgumentException("Error: provided Field[][] contains NULL-row at index "+cRow);
            Field[] copiedRow = new Field[pMap[0].length];
            int i = 0;
            for(Field f: row){
                copiedRow[i] = new Field(f.getX(), f.getY(), f.getKind());
                i++;
            }
            map[cRow] = copiedRow;
            cRow++;
        }
        map = pMap;
        cols = pMap[0].length;
        rows = pMap.length;
    }
    
    public int getCols(){
        return cols;
    }
    
    public int getRows(){
        return rows;
    }

    public void setField(final int pCol, final int pRow, final int pKind) {
        map[pRow][pCol] = new Field(pCol, pRow, pKind);
    }

    private void initialize() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                setField(col, row, Main.EMPTY);
                
            }
        }
    }

    public Field getField(final int col, final int row) {
        return map[row][col];

    }
    
    public GameMap copy(){
        GameMap copy = new GameMap(map);
        return copy;
    }
}

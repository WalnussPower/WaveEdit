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
		for (int row = 0; row <= y; row++) {
			for (int col = 0; col <= x; col++) {
				setField(col, row, Field.EMPTY);

			}
		}
	}

	public Field getField(final int pX, final int pY) {
		return map[pX][pY];

	}
}

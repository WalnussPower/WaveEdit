package waveedit.datamodel;

import static org.junit.Assert.*;

import org.junit.Test;

import waveedit.Main;

public class GameMapTest {

	@SuppressWarnings("unused")
	@Test
	public void testGameMap() {
		GameMap test = new GameMap();
		boolean failed = true;
		try {
			Field f = test.getField(21, 12);
		} catch (IndexOutOfBoundsException e){
			failed = false;
		}
		if(failed)
			fail("failed x parameter");
		try {
			Field f = test.getField(20, 13);
		} catch (IndexOutOfBoundsException e){
			failed = false;
		}
		if(failed)
			fail("failed y parameter");
		try {
			Field f = test.getField(21, 13);
		} catch (IndexOutOfBoundsException e){
			failed = false;
		}
		if(failed)
			fail("failed x+y parameter");
	}

	@SuppressWarnings("unused")
	@Test
	public void testGameMapIntInt() {
		GameMap test = new GameMap(20,12);
		boolean failed = true;
		try {
			Field f = test.getField(20, 11);
		} catch (IndexOutOfBoundsException e){
			failed = false;
		}
		if(failed)
			fail("failed x parameter");
		try {
			Field f = test.getField(20, 12);
		} catch (IndexOutOfBoundsException e){
			failed = false;
		}
		if(failed)
			fail("failed y parameter");
		try {
			Field f = test.getField(20, 12);
		} catch (IndexOutOfBoundsException e){
			failed = false;
		}
		if(failed)
			fail("failed x+y parameter");		
	}

	@Test
	public void testGameMapFieldArrayArray() {
		GameMap test = new GameMap(new Field[][] {
			{ new Field(0, 0, Main.EMPTY), new Field(1, 0, Main.WALL)},
			{ new Field(0, 1, Main.NEXUS), new Field(1, 1, Main.WALL)},
			{ new Field(0, 2, Main.EMPTY), new Field(1, 2, Main.NEXUS)},
		});
		assertEquals(3, test.getRows());
		assertEquals(2, test.getCols());
		assertEquals(Main.EMPTY, test.getField(0, 0).getKind());
		assertEquals(Main.EMPTY, test.getField(0, 2).getKind());
		assertEquals(Main.WALL, test.getField(1, 0).getKind());
		assertEquals(Main.WALL, test.getField(1, 1).getKind());
		assertEquals(Main.NEXUS, test.getField(0, 1).getKind());
		assertEquals(Main.NEXUS, test.getField(1, 2).getKind());
	}

}

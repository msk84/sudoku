package net.msk.sudoku;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SudokuTest {

	private Sudoku sudokuInvalid;
	private Sudoku sudokuValid;
	
	@Before
	public void setUp() {
		final Integer[] sudokuInvalid = {
				1,2,3,4,5,6,7,8,9,
				2,3,4,5,6,7,8,9,1,
				3,4,5,6,7,8,9,1,2,
				4,5,6,7,8,9,1,2,3,
				5,6,7,8,9,1,2,3,4,
				9,1,2,3,4,5,6,7,8,
				8,9,1,2,3,4,5,6,7,
				7,8,9,1,2,3,4,5,6,
				6,7,8,9,1,2,3,4,5};
		this.sudokuInvalid = new Sudoku(sudokuInvalid);
		
		final Integer[] sudokuValid = {
				1,2,3,4,5,6,7,8,9,
				4,5,6,7,8,9,1,2,3,
				7,8,9,1,2,3,4,5,6,
				2,3,4,5,6,7,8,9,1,
				5,6,7,8,9,1,2,3,4,
				8,9,1,2,3,4,5,6,7,
				3,4,5,6,7,8,9,1,2,
				6,7,8,9,1,2,3,4,5,
				9,1,2,3,4,5,6,7,8};
		this.sudokuValid = new Sudoku(sudokuValid);
	}
	
	@Test
	public void getRow() {
		assertEquals(new Row(new Integer[] {9,1,2,3,4,5,6,7,8}), this.sudokuInvalid.getRow(6));
	}
	
	@Test
	public void getColumn() {
		assertEquals(new Column(new Integer[] {1,2,3,4,5,9,8,7,6}), this.sudokuInvalid.getColumn(1));
		assertEquals(new Column(new Integer[] {2,3,4,5,6,1,9,8,7}), this.sudokuInvalid.getColumn(2));
	}
	
	@Test
	public void getField() {
		assertEquals(new Field(new Integer[] {1,2,3,2,3,4,3,4,5}), this.sudokuInvalid.getField(1));
		assertEquals(new Field(new Integer[] {4,5,6,5,6,7,6,7,8}), this.sudokuInvalid.getField(2));
	}
	
	@Test
	public void isValidValueGroup() {
		assertTrue(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getColumn(1)));
		assertTrue(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getColumn(2)));
		assertTrue(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getColumn(3)));
		assertTrue(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getColumn(4)));
		assertTrue(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getColumn(5)));
		assertTrue(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getColumn(6)));
		assertTrue(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getColumn(7)));
		assertTrue(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getColumn(8)));
		assertTrue(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getColumn(9)));
		
		assertTrue(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getRow(1)));
		assertTrue(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getRow(2)));
		assertTrue(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getRow(3)));
		assertTrue(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getRow(4)));
		assertTrue(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getRow(5)));
		assertTrue(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getRow(6)));
		assertTrue(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getRow(7)));
		assertTrue(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getRow(8)));
		assertTrue(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getRow(9)));
		
		assertFalse(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getField(1)));
		assertFalse(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getField(2)));
		assertFalse(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getField(3)));
		assertFalse(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getField(4)));
		assertFalse(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getField(5)));
		assertFalse(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getField(6)));
		assertFalse(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getField(7)));
		assertFalse(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getField(8)));
		assertFalse(this.sudokuInvalid.isValidValueGroup(this.sudokuInvalid.getField(9)));
		
		assertTrue(this.sudokuValid.isValidValueGroup(this.sudokuValid.getField(1)));
		assertTrue(this.sudokuValid.isValidValueGroup(this.sudokuValid.getField(2)));
		assertTrue(this.sudokuValid.isValidValueGroup(this.sudokuValid.getField(3)));
		assertTrue(this.sudokuValid.isValidValueGroup(this.sudokuValid.getField(4)));
		assertTrue(this.sudokuValid.isValidValueGroup(this.sudokuValid.getField(5)));
		assertTrue(this.sudokuValid.isValidValueGroup(this.sudokuValid.getField(6)));
		assertTrue(this.sudokuValid.isValidValueGroup(this.sudokuValid.getField(7)));
		assertTrue(this.sudokuValid.isValidValueGroup(this.sudokuValid.getField(8)));
		assertTrue(this.sudokuValid.isValidValueGroup(this.sudokuValid.getField(9)));
	}
	
	@Test
	public void isValid() {
		assertFalse(this.sudokuInvalid.isValid());
		assertTrue(this.sudokuValid.isValid());
	}
}

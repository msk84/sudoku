package net.msk.sudoku;

import java.util.Arrays;

public class Sudoku {
	
	private Integer[][] sudoku;
	
	public Sudoku() {
		this.sudoku = new Integer[9][9];
	}
	
	Sudoku(final Integer[][] sudoku) {
		this.sudoku = sudoku.clone();
	}
	
	Row getRow(final int rowIndex) {
		return new Row(Arrays.copyOf(this.sudoku[rowIndex], 9));
	}
	
	Column getColumn(final int columnIndex) {
		return new Column(Arrays.stream(this.sudoku).map(col -> col[columnIndex]).toArray(Integer[]::new));
	}
	
	Field getField(final int fieldIndex) {
		int xOffset = 0;
		int yOffset = 0;
		
		if (fieldIndex == 2) {
			xOffset = 3;
		}
		else if (fieldIndex == 3) {
			xOffset = 6;
		}
		else if (fieldIndex == 4) {
			yOffset = 3;
		}
		else if (fieldIndex == 5) {
			xOffset = 3;
			yOffset = 3;
		}
		else if (fieldIndex == 6) {
			xOffset = 6;
			yOffset = 3;
		}
		else if (fieldIndex == 7) {
			yOffset = 6;
		}
		else if (fieldIndex == 8) {
			xOffset = 3;
			yOffset = 6;
		}
		else if (fieldIndex == 9) {
			xOffset = 6;
			yOffset = 6;
		}
		
		final Integer[] result = new Integer[9];
		int i = 0;
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				result[i++] = this.sudoku[row + yOffset][col + xOffset];
			}
		}
		
		return new Field(result);
	}
	
	boolean isValidValueGroup(final ValueGroup valueGroup) {
		final boolean[] checkValues = new boolean[9];
		
		for(final Integer value : valueGroup.getValues()) {
			if(checkValues[value - 1]) {
				return false;
			}
			else {
				checkValues[value - 1] = true;
			}
		}
		return true;
	}

	boolean isValid() {
		for(int i = 0; i < 9; i++) {
			if(!this.isValidValueGroup(this.getColumn(i)) ||
			!this.isValidValueGroup(this.getRow(i)) ||
			!this.isValidValueGroup(this.getField(i))) {
				return false;
			}
		}
		
		return true;
	}
}

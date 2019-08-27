package net.msk.sudoku;

public class Sudoku {
	
	private Integer[] sudoku;
	
	public Sudoku() {
		this.sudoku = new Integer[81];
	}
	
	Sudoku(final Integer[] sudoku) {
		this.sudoku = sudoku.clone();
	}
	
	Row getRow(final int rowNumber) {
		final Integer[] result = new Integer[9];
		int j = 0;
		final int rowStartIndex = (rowNumber - 1) * 9;
		
		for (int i = rowStartIndex; i < rowStartIndex + 9; i++) {
			result[j] = this.sudoku[i];
			j++;
		}
		
		return new Row(result);
	}
	
	Column getColumn(final int columnNumber) {
		final Integer[] result = new Integer[9];
		int colIndex = (columnNumber - 1);
		
		for (int i = 0; i < 9; i++) {
			result[i] = this.sudoku[colIndex];
			colIndex += 9;
		}
		
		return new Column(result);
	}
	
	Field getField(final int fieldNumber) {
		final Integer[] result = new Integer[9];
		final int rowOffset = fieldNumber > 6 ? 36 : fieldNumber > 3 ? 18 : 0;
		int fieldIndex = ((fieldNumber - 1) * 3) + rowOffset;
		int j = 0;
		
		for (int i = 0; i < 3; i++) {
			result[j++] = this.sudoku[fieldIndex++];
			result[j++] = this.sudoku[fieldIndex++];
			result[j++] = this.sudoku[fieldIndex++];
			fieldIndex += 6;
		}
		
		return new Field(result);
	}
	
	boolean isValidValueGroup(final ValueGroup valueGroup) {
		final boolean[] checkValues = new boolean[9];
		
		for (final Integer value : valueGroup.getValues()) {
			if (checkValues[value - 1]) {
				return false;
			}
			else {
				checkValues[value - 1] = true;
			}
		}
		return true;
	}
	
	boolean isValid() {
		for (int i = 1; i < 10; i++) {
			if (!this.isValidValueGroup(this.getColumn(i)) ||
					!this.isValidValueGroup(this.getRow(i)) ||
					!this.isValidValueGroup(this.getField(i))) {
				return false;
			}
		}
		
		return true;
	}
}

package net.msk.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sudoku {
	
	private Integer[] sudoku;
	
	public Sudoku() {
		this.sudoku = new Integer[81];
	}
	
	Sudoku(final Integer[] sudoku) {
		this.sudoku = sudoku.clone();
	}
	
	Integer getValue(final int index) {
		return this.sudoku[index];
	}
	
	void setValue(final int index, final Integer value) {
		this.sudoku[index] = value;
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
			if (value == null) {
				continue;
			}
			else if (!checkValues[value - 1]) {
				checkValues[value - 1] = true;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	boolean isValidCell(final int index) {
		final int rowNumber = (index / 9) + 1;
		final int colNumber = (index % 9) + 1;
		final int fieldNumber = (((index % 9) / 3) + 1) + (3 * ((index / 27)));
		
		return this.isValidValueGroup(this.getRow(rowNumber)) &&
				this.isValidValueGroup(this.getColumn(colNumber)) &&
				this.isValidValueGroup(this.getField(fieldNumber));
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
	
	boolean isComplete() {
		for (final Integer currentValue : this.sudoku) {
			if (currentValue == null) {
				return false;
			}
		}
		return this.isValid();
	}
	
	void print() {
		System.out.println(" " + String.join(" | ", this.getRow(1).toStringArray()));
		System.out.println("-------------------------------------");
		System.out.println(" " + String.join(" | ", this.getRow(2).toStringArray()));
		System.out.println("-------------------------------------");
		System.out.println(" " + String.join(" | ", this.getRow(3).toStringArray()));
		System.out.println("-------------------------------------");
		System.out.println(" " + String.join(" | ", this.getRow(4).toStringArray()));
		System.out.println("-------------------------------------");
		System.out.println(" " + String.join(" | ", this.getRow(5).toStringArray()));
		System.out.println("-------------------------------------");
		System.out.println(" " + String.join(" | ", this.getRow(6).toStringArray()));
		System.out.println("-------------------------------------");
		System.out.println(" " + String.join(" | ", this.getRow(7).toStringArray()));
		System.out.println("-------------------------------------");
		System.out.println(" " + String.join(" | ", this.getRow(8).toStringArray()));
		System.out.println("-------------------------------------");
		System.out.println(" " + String.join(" | ", this.getRow(9).toStringArray()));
	}
	
	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final Sudoku sudoku1 = (Sudoku) o;
		return Arrays.equals(this.sudoku, sudoku1.sudoku);
	}
	
	@Override
	public int hashCode() {
		return Arrays.hashCode(this.sudoku);
	}
}

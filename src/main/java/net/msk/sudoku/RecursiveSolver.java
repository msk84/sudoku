package net.msk.sudoku;

public class RecursiveSolver implements Solver {
	
	@Override
	public Sudoku solve(final Sudoku sudoku, int index) {
		
		if (sudoku.getValue(index) != null) {
			index = this.findNextEmpty(sudoku, index);
		}
		
		if (index == 81) {
			if (sudoku.isValid()) {
				return sudoku;
			}
		}
		
		for (int i = 1; i < 10; i++) {
			sudoku.setValue(index, i);
			if (sudoku.isValidCell(index)) {
				final Sudoku result = this.solve(sudoku, i);
				if (result != null) {
					return result;
				}
			}
			else {
				sudoku.setValue(index, null);
			}
		}
		
		return null;
	}
	
	private int findNextEmpty(final Sudoku sudoku, final int index) {
		for (int i = index; i < 81; i++) {
			if (sudoku.getValue(i) == null) {
				return i;
			}
		}
		return 81;
	}
	
}

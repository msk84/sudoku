package net.msk.sudoku;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class RecursiveSolverTest {
	
	@Test
	public void solve() {
		final Solver solver = new RecursiveSolver();
		
		final Integer[] testSudoku = {
				null, null, 6, 7, 3, null, 8, 5, null,
				null, null, 7, 4, 5, 1, null, null, 6,
				3, 5, null, null, 6, 8, 4, null, 9,
				6, 4, null, null, 7, 2, 1, 8, null,
				2, 9, 5, 1, null, 3, 6, 4, 7,
				null, 7, 8, 5, 4, null, null, 2, 3,
				7, null, 4, 8, 9, null, null, 6, 2,
				5, null, null, 3, 2, 4, 7, null, null,
				null, 3, 2, null, 1, 7, 5, null, null,
		};
		final Sudoku sudoku = new Sudoku(testSudoku);
		
		final Sudoku result = solver.solve(sudoku, 0);
		
		final Integer[] finishedSudoku = {
				4, 2, 6, 7, 3, 9, 8, 5, 1,
				9, 8, 7, 4, 5, 1, 2, 3, 6,
				3, 5, 1, 2, 6, 8, 4, 7, 9,
				6, 4, 3, 9, 7, 2, 1, 8, 5,
				2, 9, 5, 1, 8, 3, 6, 4, 7,
				1, 7, 8, 5, 4, 6, 9, 2, 3,
				7, 1, 4, 8, 9, 5, 3, 6, 2,
				5, 6, 9, 3, 2, 4, 7, 1, 8,
				8, 3, 2, 6, 1, 7, 5, 9, 4,
		};
		assertEquals(new Sudoku(finishedSudoku), result);
		result.print();
	}
	
	@Test
	public void test1() {
		final Solver solver = new RecursiveSolver();
		
		final Integer[] testSudoku = {
				null, null, 1, 6, null, 5, 4, null, null,
				5, null, null, null, 9, null, null, null, 8,
				null, 6, null, null, null, null, null, 9, null,
				null, 4, 9, 7, null, 1, 6, 5, null,
				null, null, null, null, null, null, null, null, null,
				null, 5, 2, 3, null, 8, 9, 4, null,
				null, 1, null, null, null, null, null, 8, null,
				6, null, null, null, 3, null, null, null, 9,
				null, null, 3, 1, null, 6, 7, null, null,
		};
		final Sudoku sudoku = new Sudoku(testSudoku);
		
		final Sudoku result = solver.solve(sudoku, 0);
		result.print();
		
		final Integer[] finishedSudoku = {
				2, 9, 1, 6, 8, 5, 4, 3, 7,
				5, 7, 4, 2, 9, 3, 1, 6, 8,
				3, 6, 8, 4, 1, 7, 2, 9, 5,
				8, 4, 9, 7, 2, 1, 6, 5, 3,
				1, 3, 6, 5, 4, 9, 8, 7, 2,
				7, 5, 2, 3, 6, 8, 9, 4, 1,
				4, 1, 5, 9, 7, 2, 3, 8, 6,
				6, 2, 7, 8, 3, 4, 5, 1, 9,
				9, 8, 3, 1, 5, 6, 7, 2, 4
		};
		assertEquals(new Sudoku(finishedSudoku), result);
	}
}
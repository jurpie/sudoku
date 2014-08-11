/**
 * A class with a main function that runs the Sudoku solver
 * @author Sherry
 *
 */
public class SudokuMain {

	/**
	 * Runs the Sudoku solver
	 * @param args
	 */
	public static void main(String[] args) {
		final String start = "060002000004105000005000984307008050000000000050700203473000600000807300000200040";
		Grid grid = new Grid(start);
		Solver sudokuSolver = new Solver(grid);
		System.out.print(grid);
		sudokuSolver.solve();
	}

}

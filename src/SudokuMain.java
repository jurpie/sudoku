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
		// TODO Auto-generated method stub
		Grid grid = new Grid();
		Solver sudokuSolver = new Solver(grid);
		System.out.print(grid);
		sudokuSolver.solve();
	}

}

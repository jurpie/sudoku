/**
 * 
 */

/**
 * @author Sherry
 *
 */

public class Solver {
	private Grid grid;
	
	public Solver (Grid grid){
		this.grid = grid;
	}
	
	public void solve(){		
		do{

			updatePossibilities();
			solveCells();
			solveGroups();
		} while (!grid.isSolved() && Grid.changed);
	}
	
	public void updatePossibilities(){
		for (int rownum = 1; rownum <=9; rownum++){
			CellGroup row = grid.getRow(rownum);
			row.updatePossibilities();
		}
		
		for (int colnum = 1; colnum <=9; colnum++){
			CellGroup col = grid.getCol(colnum);
			col.updatePossibilities();
		}
		
		for (int blocknum = 1; blocknum <=9; blocknum++){
			CellGroup block = grid.getBlock(blocknum);
			block.updatePossibilities();
		}
	}
	
	public void solveCells(){
		for (int row = 1; row <= 9; row++){
			for (int col = 1; col <= 9; row++){
				Cell cell = grid.getCell(row, col);
				if (cell.solve()){
					grid.getRow(row).updatePossibilities();
					grid.getCol(col).updatePossibilities();
					grid.getBlock(row, col).updatePossibilities();
				}
			}
		}
	}
	public void solveGroups(){
		for (int rownum = 1; rownum <=9; rownum++){
			CellGroup row = grid.getRow(rownum);
			row.solveSingles();
		}
		
		for (int colnum = 1; colnum <=9; colnum++){
			CellGroup col = grid.getCol(colnum);
			col.solveSingles();
		}
		
		for (int blocknum = 1; blocknum <=9; blocknum++){
			CellGroup block = grid.getBlock(blocknum);
			block.solveSingles();
		}
	}
}

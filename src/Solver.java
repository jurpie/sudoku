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
	
	public boolean solve(){
		boolean solved = false;
		return solved;
	}
	
	public void update_possibilities(){
		for (int rownum = 1; rownum <=9; rownum++){
			CellGroup row = grid.getRow(rownum);
			boolean[] mask = row.commonPossibilities();
			for (Cell cell : row){
				cell.maskPossibilities(mask);
			}
		}
		
		for (int colnum = 1; colnum <=9; colnum++){
			CellGroup col = grid.getCol(colnum);
			boolean[] mask = col.commonPossibilities();
			for (Cell cell : col){
				cell.maskPossibilities(mask);
			}
		}
		
		for (int blocknum = 1; blocknum <=9; blocknum++){
			CellGroup block = grid.getBlock(blocknum);
			boolean[] mask = block.commonPossibilities();
			for (Cell cell : block){
				cell.maskPossibilities(mask);
			}
		}
	}
}

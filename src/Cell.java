 /**
 * 
 */

/**
 * @author Sherry
 *
 */
public class Cell {

	private boolean[] possibilities;
	private int solution = 0;
	private boolean solved;
	
	public Cell(){
		possibilities = new boolean[9];
	}
	
	public Cell(int solution){
		this.solution = solution;
		solved = true;
	}
	
	public boolean[] getPossibilities(){
		return possibilities;
	}
	

	public int getSolution(){
		return solution;
	}
	
	public boolean isSolved(){
		return solved;
	}
}

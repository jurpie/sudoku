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
		
	public Cell(){
		possibilities = new boolean[9];
		for (int i = 0; i < 9; i++){
			possibilities[i] = true;
		}
	}
	
	public Cell(int solution){
		this.solution = solution;
		possibilities = null;
	}
	
	public boolean[] getPossibilities(){
		return possibilities;
	}
	
	public void setPossibilities(int i, boolean bool){
		possibilities[i] = bool;
	}

	public void maskPossibilities(boolean[] mask){
		for (int i = 1; i <= 9; i++){
			possibilities[i] = possibilities[i] && mask[i];
		}
	}
	
	public int getSolution(){
		return solution;
	}
	
	public boolean isSolved(){
		return (possibilities == null);
	}
}

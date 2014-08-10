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
	
	public void setPossibility(int index, boolean state){
		possibilities[index - 1] = state;
	}
	
	public void setPossibilities(boolean[] possibilities){
		this.possibilities = possibilities;
	}
	
	public boolean isPossible(int value){
		return possibilities[value - 1];
	}

	public void maskPossibilities(boolean[] mask){
		for (int i = 1; i <= 9; i++){
			possibilities[i] = possibilities[i] && mask[i];
		}
	}
	
	public int countPossibilities(){
		int count = 0;
		for(int i = 0; i < 9; i++){
			if(possibilities[i])
				count++;
		}
		return count;
	}
	
	public int getSolution(){
		return solution;
	}
	
	public boolean isSolved(){
		return (possibilities == null);
	}
	
	public boolean solve(){
		if(this.countPossibilities() == 1)
		{
			solution = 0;
			while(!possibilities[solution++]);
			possibilities = null;
			return true;
		}
		return false;
	}
}

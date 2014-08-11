import java.util.Iterator;

public class CellGroup implements Iterable<Cell> {
	private Cell[] group;
	
	public CellGroup(Cell[] cells){
		group = cells;
	}
	
	public CellGroup(int count){
		group = new Cell[count];
	}
	
	public boolean[] commonPossibilities(){
		boolean[] notPossible = new boolean[9];
		
		for(int i = 0; i < group.length; i++){
			if (group[i].isSolved()){
				notPossible[group[i].getSolution() - 1] = true;
			}
		}
		
		boolean[] possible = new boolean[9];
		for(int i = 0; i < 9; i++){
			possible[i] = ! notPossible[i];
		}
		
		return possible;		
	}
	
	public Cell getCell(int number){
		return group[number];
	}
	
	public Cell[] toArray(){
		return group;
	}
	
	public void updatePossibilities(){
		boolean[] mask = this.commonPossibilities();
		for (Cell cell : group){
			if(!cell.isSolved())
				cell.maskPossibilities(mask);
		}
	}
	
	public Iterator<Cell> iterator(){
		return new CellIterator(group);
	}
	
	public void solveSingles(){
		int[] valCount = new int[9];
		for(Cell cell: this){
			if(cell.isSolved())
			{
				valCount[cell.getSolution() - 1] = -99;
			}
			else{
				boolean[] poss = cell.getPossibilities();
				for(int i = 0; i < 9; i++){
					if(poss[i])
						valCount[i]++;
				}
			}
		}
		for(int i = 0; i < 9; i++){
			if(valCount[i] == 1){
				for(Cell cell: this){
					if(!cell.isSolved() && cell.isPossible(i+1)){
						cell.solve(i+1);
					}
				}
			}
		}
	}
	public String toString(){
		String output = "CellGroup: ";
		for(Cell cell : this){
			if(!cell.isSolved())
				output += ".";
			else{
				output += cell.getSolution();
			}
		}
		return output;
	}
	
}
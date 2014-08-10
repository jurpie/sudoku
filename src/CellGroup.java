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
			if (!group[i].isSolved()){
				notPossible[group[i].getSolution()] = true;
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

		boolean[] mask = commonPossibilities();
		for (Cell cell : group){
			cell.maskPossibilities(mask);
		}
	}
	
	public Iterator<Cell> iterator(){
		return new CellIterator(group);
	}
	
}
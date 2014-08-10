import java.util.Iterator;

public class CellGroup implements Iterable<Cell> {
	private Cell[] group;
	
	public CellGroup(Cell[] cells){
		group = cells;
	}
	
	public CellGroup(int count){
		group = new Cell[count];
	}
	
	public boolean[] common_possibilities(){
		boolean[] notPossible = new boolean[9];
		
		for(int i = 0; i < group.length; i++){
			
		}
	}
	
	public Cell getCell(int number){
		return group[number];
	}
	
	public Cell[] toArray(){
		return group;
	}
	
	public Iterator<Cell> iterator(){
		return new CellIterator(group);
	}
	
}
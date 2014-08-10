import java.util.Iterator;

public class CellIterator implements Iterator<Cell>{
	int index;
	Cell[] cells;
	
	public CellIterator(Cell[] cells){
		index = 0;
		this.cells = cells;
	}
	
	public boolean hasNext(){
		return index < cells.length;
	}
	
	public Cell next(){
		return cells[index++];
	}
	
	public void remove(){
		System.err.println("CellIterator.remove(): DON'T USE ME O_O.");
		throw new UnsupportedOperationException();
	}
}
	
	
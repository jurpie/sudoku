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
		return Cell[index++];
	}
}
	
	
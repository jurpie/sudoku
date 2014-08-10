public class CellIterator implements Iterator<Cell>{
	int index;
	Cell[] cells;
	
	public CellIterator(CellGroup cells){
		index = 0;
		this.cells = cells.toArray();
	}
	
	public boolean hasNext(){
		return index < cells.length;
	}
	
	public Cell next(){
		return Cell[index++];
	}
}
	
	
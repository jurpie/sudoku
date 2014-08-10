import java.util.Scanner;

public class Grid{
	Cell[][] grid = new Cell[9][9];
	
	public Grid() {
		Scanner kb = new Scanner(System.in);
		for(int row = 0; row < 9; row++){
			for (int col = 0; col < 9; col++){
				boolean valid = false;
				while(!valid){
					System.out.print("Enter (" + (row + 1) + "," + (col + 1) + "): ");
					grid[row][col] = new Cell(kb.nextInt());
					if(grid[row][col].getSolution() > 9 || grid[row][col].getSolution() < 1)
						System.out.println("Invalid entry!");
					else valid = true;
				}
			}
		}
		kb.close();
	}
	
	public Grid(Cell[][] cells){
		this.grid = cells;
	}
	
	public CellGroup getRow(int row){
		return new CellGroup(grid[row-1]);
	}
	
	public CellGroup getCol(int col){
		Cell[] column = new Cell[9];
		for(int row = 0; row < 9; row++){
			column[row] = grid[row][col-1];
		}
		return new CellGroup(column);
	}
	
	public CellGroup getBlock(int block){
		block -= 1;
		int row = block / 3 + 1;
		int col = block % 3 + 1;
		return this.getBlock(row, col);
	}
	
	public CellGroup getBlock(int row, int col){
		Cell[] block = new Cell[9];
		row -= 1; col -= 1;
		for(int rowI = 0; rowI < 3; rowI++){
			for(int colI = 0; colI < 3; colI++){
				block[rowI + 3*colI] = grid[row + rowI][col + colI];
			}
		}
		return new CellGroup(block);
	}
	
	public Cell getCell(int row, int col){
		return grid[row-1][col-1];
	}
	
	public Cell getCell(int num){
		num -= 1;
		int row = num / 9;
		int col = num % 9;
		return grid[row][col];
	}
	
	public boolean isSolved()
	{
		for(int cellNum = 0; cellNum < 81; cellNum++)
			 if(!this.getCell(cellNum + 1).isSolved())
				return false;
		return true;
	}
	
	public String toString(){
		String output = ".-----------------------------------.\n| ";
		for(int rownum = 1; rownum <= 9; rownum++){
			for(Cell cell : this.getRow(rownum)){
				if(cell.isSolved())
					output += cell.getSolution();
				else
					output += " ";
				output += " | ";
			}
			if(rownum != 9){
				output += "|---|---|---|---|---|---|---|---|---|";
				output += "\n| ";
			}
		}
		output += "`-----------------------------------'";
		return output;
	}
}

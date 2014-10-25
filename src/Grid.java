import java.util.Scanner;

public class Grid{
	public static boolean changed = false;
	
	Cell[][] grid = new Cell[9][9];
	
	public Grid() {
		Scanner kb = new Scanner(System.in);
		for(int row = 0; row < 9; row++){
			for (int col = 0; col < 9; col++){
				boolean first = true;
				int input;
				do{
					if(first)
						first = false;
					else
						System.out.println("Invalid Entry!");
					
					System.out.print("Enter (" + (row + 1) + "," + (col + 1) + "): ");
					input = kb.nextInt();
				} while (input > 9 || input < 0);
				
				if(input == 0)
					grid[row][col] = new Cell();
				else
					grid[row][col] = new Cell(input);				
			}
		}
		kb.close();
	}
	
	public Grid(String input){
		for(int row = 0; row < 9; row++){
			for (int col = 0; col < 9; col++){
				int nextInt = Integer.parseInt(String.valueOf(input.charAt(row * 9  + col)));
				if(nextInt == 0)
					grid[row][col] = new Cell();
				else
					grid[row][col] = new Cell(nextInt);
			}
		}
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
		row *= 3; col *= 3;
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
	
	public boolean equals(Grid grid){
		for (int row = 1; row <= 9; row++){
			for (int col = 1; col <= 9; col++){
				if (this.getCell(row, col) != grid.getCell(row, col)){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isSolved()
	{
		for(int cellNum = 0; cellNum < 81; cellNum++)
			 if(!this.getCell(cellNum + 1).isSolved())
				return false;
		return true;
	}
	
	public String toString(){
		String output = "╔═══╤═══╤═══╦═══╤═══╤═══╦═══╤═══╤═══╗\n║ ";
		for(int rownum = 1; rownum <= 9; rownum++){
			for(int colnum = 1; colnum <= 9; colnum++){
				Cell cell = this.getCell(rownum, colnum);
				if(cell.isSolved())
					output += cell.getSolution();
				else
					output += " ";
				if(colnum%3 != 0)
					output += " │ ";
				else
					output += " ║ ";
			}
			if(rownum != 9){
				if(rownum%3 != 0)
					output += "\n╟───┼───┼───╫───┼───┼───╫───┼───┼───╢";
				else
					output += "\n╠═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╣";
				output += "\n║ ";
			}
		}
		output += "\n╚═══╧═══╧═══╩═══╧═══╧═══╩═══╧═══╧═══╝\n";
		return output;
	}
}

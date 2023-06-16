package datastructure;

public class NQueens {
	
	public static void placeQueen(int n){
		int board [][] = new int[n][n];
		placeQueens(n,0);
	}
	
	public static void placeQueens(int n, int row) {
		if(row == n) {
			//valid configuration
		}
		
		//check for all column
		 // check if it is safe to place queen
		  // if it is safe then place the queen and move to next rows
		
		
	}

	public static void main(String[] args) {
		
		
	}

}

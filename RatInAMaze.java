package datastructure;

public class RatInAMaze {
	
	public static void ratInAMaze(int [][] maze) {
		int n = maze.length;
		int path[][] = new int [n][n];
//		solveMaze(maze,0,0,path);
		printAllPaths(maze,0,0,path);
		
	}
	public static void printAllPaths(int maze[][] ,int i, int j,int path[][]) {
		int n = maze.length;
		//check if i and j cell are valid or not
		if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1) {
			return;
		}
		//include the cell in current path
		path[i][j] = 1;
		//destination cell
		if(i == n-1 && j == n-1) {
			for(int row = 0 ;row < n ; row++) {
				for(int col = 0; col < n; col++) {
					System.out.print(path[row][col]+" ");
				}
				System.out.println();
			}
//			System.out.println();
			path[i][j] = 0;
			return;
		}
		//explore further all direction
		//top
		printAllPaths(maze , i -1 ,j, path);
		//right
		printAllPaths(maze , i ,j + 1, path);
		//down
		printAllPaths(maze , i + 1 ,j, path);
		//left
		printAllPaths(maze , i ,j - 1, path);
		path[i][j] = 0;
	}
	
	public static boolean solveMaze(int maze[][] ,int i, int j,int path[][]) {
		int n = maze.length;
		//check if i and j cell are valid or not
		if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1) {
			return false;
		}
		//include the cell in current path
		path[i][j] = 1;
		//destination cell
		if(i == n-1 && j == n-1) {
			for(int row = 0 ;row < n ; row++) {
				for(int col = 0; col < n; col++) {
					System.out.print(path[row][col]+" ");
					path[row][col] = 0;
				}
				System.out.println();
			}
			return true;
		}
		//explore further all direction
		//top
		if(solveMaze(maze , i -1 ,j, path)){
			return true;
		}
		//right
		if(solveMaze(maze , i ,j + 1, path)){
			return true;
		}
		//down
		if(solveMaze(maze , i + 1 ,j, path)){
			return true;
		}
		//left
		if(solveMaze(maze , i ,j - 1, path)){
			return true;
		}
		return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maze[][]= {{1,1,0},{1,1,0},{0,1,1}};
		//boolean pathPossible = ratInAMaze(maze);
		//System.out.println(pathPossible);
		ratInAMaze(maze);
	}

}

package BACKTRACK;

public class Sudoku {
	
	private static void solve(int[][] board, int i, int j) {
		
		if(i==board.length) {
			display(board);
			System.out.println();
			return;
		 }
		 int row=0;
		 int col=0;
		 if(j==board[0].length-1) {
			 row=i+1;
			 col=0;
		 }else {
			 row=i;
			 col=j+1;
		 }
		 if(board[i][j]!=0) {
			 solve(board,row,col);
		 }else {
			 for(int num=1;num<=9;num++) {
				 if(isSafe(board,i,j,num)) {
					 board[i][j]=num;
					 solve(board,row,col);
					 board[i][j]=0;
				 }
			 }
		 } 
	}

	private static void display(int[][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	private static boolean isSafe(int[][] board, int row, int col, int num) {
		for(int j=0;j<board[0].length;j++) { // same row
			if(board[row][j]==num)
			return false;
		}
		for(int j=0;j<board.length;j++) { // same col
			if(board[j][col]==num) 
			return false;
		}
		
		int smallBoardRow=row/3*3;
		int smallBoardCol=col/3*3;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(board[smallBoardRow+i][smallBoardCol+j]==num) {
					return false;
				}
			}
		}
		return true;		
	}

	public static void main(String[] args) {
		int [][] grid = { {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
		         		  {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
		         		  {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
		         		  {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
		         		  {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
		         		  {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
		         		  {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
		         	      {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
		         	      {0, 0, 5, 2, 0, 6, 3, 0, 0} 
						};
		
		solve(grid,0,0);

	}

	

}

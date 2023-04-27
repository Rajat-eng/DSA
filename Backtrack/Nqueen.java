package BACKTRACK;
import java.util.Scanner;
public class Nqueen {
	
	private static void solve(int row, int n, int[][] board) {
//		O[n!] (n col -->check)*(n-1 col -->check)*(n-2--> col check)
		if(row==n)
		{
			print(board);
			System.out.println();
			return;
		}
		for(int col=0;col<n;col++) {
			if(isItSafe(board, row,col)==true) {
				board[row][col]=1;
				solve(1+row,n,board);
				board[row][col]=0;
			}
		}	
	}

	private static void print(int[][] possible) {
		for(int i=0;i<possible.length;i++) {
			for(int j=0;j<possible.length;j++) {
			  System.out.print(possible[i][j] + " ");	
			}
			System.out.println();
		}	
	}

	private static boolean isItSafe(int[][] board, int row, int col) {
		for(int i=row-1,j=col;i>=0;i--) { // same column
			if(board[i][j]==1)
				return false;
		}
		for(int i=row-1,j=col-1; i>=0 && j>=0;  i--,j--) {
//			 			left diagnol \\
			if(board[i][j]==1)
				return false;
		}
		for(int i=row-1,j=col+1; i>=0 && j<board.length;  i--,j++) { 
//					    right diagnol //
			if(board[i][j]==1)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[][] board=new int[n][n];
		solve(0,n,board);
	}

	
}

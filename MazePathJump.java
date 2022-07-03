package BACKTRACK;
import java.util.ArrayList;
public class MazePathJump {
//	 move is horizontal or vertical
	private static void mazesolve(int i, int j, int n,int [][] maze,int [][] path) {
		if(i<0 || j<0 || i>=n || j>=n || maze[i][j]==0 || path[i][j]==1 )
	           return;
			
		path[i][j]=1;
        if(i==n-1 && j==n-1){  	
            for(int r=0;r<n;r++){
                for(int c=0;c<n;c++){
                System.out.print(path[r][c] + " "); 
                }
                 System.out.println();
            }
           path[i][j]=0;
           System.out.println();
           return;            
        }
        
        for(int jump=1;jump<n;jump++) {
        	mazesolve(i+jump, j, n, maze, path);
        	mazesolve(i, j+jump, n, maze, path);
        }
        path[i][j]=0;
	}

	public static void main(String[] args) {
		int [][]maze= {{1,0,1},{1,1,1},{1,0,1}};
		int n=maze.length;
		int[][] path=new int[n][n];
		mazesolve(0,0,n,maze,path);

	}
}

package BACKTRACK;

public class MazePath {
	
	static void ratInAMaze(int maze[][], int n) {
        int [][] path=new int[n][n];
		ratInAMazehelper(0,0,n,maze,path);
	}
	
	static void ratInAMazehelper(int i,int j,int n,int [][] maze,int [][] path){
		
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
             
       ratInAMazehelper(i,j-1,n,maze,path);          
        
       ratInAMazehelper(i,j+1,n,maze,path);   
      
       ratInAMazehelper(i-1,j,n,maze,path);         
         
       ratInAMazehelper(i+1,j,n,maze,path);       
       
       path[i][j]=0;
   }

	public static void main(String[] args) {
		
		int [][]maze= {{1,1,1},{1,0,1},{1,1,1}};
		ratInAMaze(maze, maze.length);
	}

}

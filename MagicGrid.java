package DP;

public class MagicGrid {
	
	public static int getMinimumStrength(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int [][] dp= new int [r][c];
        dp[r-1][c-1]= grid[r-1][c-1]>0 ? 1:Math.abs(grid[r-1][c-1]) + 1;
        
        for(int i=r-2;i>=0;i--) {
        	dp[i][c-1]=Math.max(dp[i+1][c-1]-grid[i][c-1],1);
        }
        for(int i=c-2;i>=0;i--) {
        	dp[r-1][i]=Math.max(dp[r-1][i+1]-grid[r-1][i],1);
        }
        
        for(int i=r-2;i>=0;i--) {
        	for(int j=c-2;j>=0;j--) {
        		int minhealth= Math.min(dp[i+1][j], dp[i][j+1]);
        		dp[i][j]=Math.max(minhealth-grid[i][j],1);
        	}
        }
        
        for(int i=0;i<r;i++) {
        	for(int j=0;j<c;j++) {
        		System.out.print(dp[i][j] + " ");
        	}
        	System.out.println();
        }
        
        return dp[0][0];
        
    }

	public static void main(String[] args) {
		int [][]arr= {{-2,-3,3},{-5,-10,1},{10,30,-5}};
		int ans=getMinimumStrength(arr);
		System.out.println(ans);
	}

}

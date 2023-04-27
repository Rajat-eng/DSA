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
        
//        for(int i=0;i<dp.length;i++) {
//        	for(int j=0;j<dp[0].length;j++) {
//        		System.out.print(dp[i][j] + " ");
//        	}
//        	System.out.println();
//        }
        
        return dp[0][0];
        
    }
	
	public static int getMinimumStrengthMemo(int[][]grid,int i,int j,int n,int m,int[][]dp) {
		if(i>=n||j>=m) {
			return Integer.MAX_VALUE;
		}
		 
		if(dp[i][j] != -1){
		    return dp[i][j];
		}
		
		if(i == n-1 && j == m-1){
		    return dp[i][j]=grid[i][j] <= 0 ? Math.abs(grid[i][j]) + 1 : 1;
		}
		
		int op1 = getMinimumStrengthMemo(grid,i+1, j, n, m, dp);
	    int op2 = getMinimumStrengthMemo(grid,i, j+1, n, m, dp);
	    int minHealthRequired = Math.min(op1, op2) - grid[i][j];
	    return dp[i][j] = (minHealthRequired <= 0) ? 1 : minHealthRequired;
	}

	public static void main(String[] args) {
		int [][]arr= {{-2,-3,3},{-5,-10,1},{10,30,-5}};
		int[][] dp=new int[arr.length][arr[0].length];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				dp[i][j]=-1;
			}
		}
		int ans=getMinimumStrengthMemo(arr,0,0,arr.length,arr[0].length,dp);
      
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
      
		System.out.println(ans);
	}

}

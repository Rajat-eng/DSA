package DP;

public class goldmine {
	
	public static int maxgold(int[][]mine) {
		int m=mine.length;
		int n=mine[0].length;
		int [][] storage=new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				storage[i][j]=-1;
			}
		}
		int maxgold=0;
		for(int i=0;i<m;i++) {
			int goldcollected=maxgoldM(mine,i,0,storage);
			maxgold=Math.max(maxgold, goldcollected);
		}
		return maxgold;
	}
	
	private static int maxgoldM(int[][] mine, int i, int j, int[][] storage) {
		int m=mine.length;
		int n=mine[0].length;
		
		if(i>=m||i<0||j>=n)
			return Integer.MIN_VALUE;
		
		if(storage[i][j]!=-1)
			return storage[i][j];
		
		if(j==n-1)
			return mine[i][j];
		
		int op1=maxgoldM(mine,i,j+1,storage);// straight
		int op2=maxgoldM(mine, i+1, j+1, storage); //lower diagnol
		int op3=maxgoldM(mine, i-1, j+1, storage); // upper diagnol
		storage[i][j]= mine[i][j] + Math.max(op1, Math.max(op2, op3));
		return storage[i][j];
	}

	private static int maxgoldDP(int[][]mine) {
		int m=mine.length;
		int n=mine[0].length;
		int maxgold=0;
		int[][] dp=new int[m][n];
		
		for(int i=0;i<m;i++) {
			dp[i][n-1]=mine[i][n-1];  // filling last column
		}
		
		for(int j=n-2;j>=0;j--) {
			for(int i=0;i<m;i++) {
				if(i==0) { // cannot go up
					dp[i][j]=mine[i][j] + Math.max(dp[i][j+1],dp[i+1][j+1]);
				}else if(i==m-1) { // cannot go down
					dp[i][j]=mine[i][j] + Math.max(dp[i][j+1],dp[i-1][j+1]);
				}else {
					dp[i][j]=mine[i][j] + Math.max(dp[i][j+1],Math.max(dp[i+1][j+1],dp[i-1][j+1]));	
				}		
			}
		}
			
		for(int i=0;i<m;i++) {
			maxgold=Math.max(maxgold, dp[i][0]);
		}
		return maxgold;
	}

	public static void main(String[] args) {
		int [][] arr={ {0,1,4,2,8,2},{4,3,6,5,0,4},{1,2,4,1,4,6},{2,0,7,3,2,2},{3,1,5,9,2,4},{2,7,0,8,5,1} };
		System.out.println(maxgold(arr));
		System.out.println(maxgoldDP(arr));
	}

}

package DP;

public class minCostOfTriangulation {
	
	public static int solve(int[]arr) {
		int n=arr.length;
		int[][] dp=new int[n][n];
		for(int l=0;l<n;l++) {
			for(int i=0,j=l;j<n;i++,j++) {
				if(l==0 || l==1) // one point or two point
					dp[i][j]=1;
				else if(l==2) {
					dp[i][j]=arr[i]*arr[i+1]*arr[j]; // three points multiply
				}else {
					dp[i][j]=Integer.MAX_VALUE;
					for(int k=i+1;k<j;k++) {
						int tri=arr[i]*arr[j]*arr[k]; // last two points and selected point
						int left=dp[i][k];
						int right=dp[k][j];
						int total=tri+left+right;
						dp[i][j]=Math.min(total, dp[i][j]);
					}
				}
				System.out.print(dp[i][j] + " ");
		    }
			System.out.println();
		}
		return dp[0][n-1];		
	}

	public static void main(String[] args) {
		int points[]= {2,3,1,5,6,4};
		
		
		int ans=solve(points);
		System.out.println(ans);
	}

}

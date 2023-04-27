package DP;
public class BurstBaloons {
	
	public static int solve(int[] arr) {
//	O[n^3]
		int n=arr.length;
		int[][] dp=new int[n][n];
		for(int l=0;l<n;l++) {
			for(int i=0,j=l;j<n;i++,j++) {
				if(l==1) {
					dp[i][j]=  (i==0?1:arr[i-1])* arr[i]* (i==n-1?1:arr[i+1]);
				}else {
					dp[i][j]=Integer.MIN_VALUE;
					for(int k=i;k<=j;k++) {
//					k is last to be burst
					int left = k==i?0:dp[i][k-1];
					int right= k==j?0:dp[k+1][j];
					int value= (i==0?1:arr[i-1]) * arr[k] * (j==n-1?1:arr[j+1]);
					int temp=left+right+value;
					dp[i][j]=Math.max(dp[i][j],temp);
				}
			  }				
			}	
		}
		return dp[0][n-1];
	}

	public static void main(String[] args) {
		int[] Baloons= {2,3,1,5,6,4};
//		 cost of 2 is 2*3*1
//		 cost of 4 is 6*4*1
//		 cost of 1 is 3*1*5
		System.out.println(solve(Baloons));
	}

}

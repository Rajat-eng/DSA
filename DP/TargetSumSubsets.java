package DP;

public class TargetSumSubsets {
	
   static boolean isSubsetPresent(int[] arr, int n, int sum) {
	   boolean dp[][]=new boolean[1+n][1+sum];
	   
	   for(int i=0;i<=n;i++) {
		  for(int j=0;j<=sum;j++) {
			if(i==0 && j==0) {
				dp[i][j]=true;
			}else if(i==0) {
				dp[i][j]=false;
			}else if(j==0) {
				dp[i][j]=true;
			}else {
				if(dp[i-1][j]==true)
					dp[i][j]=true;  
				else {
					int val=arr[i-1];  // index 0 is sum 0 index 1 is arr[0]
					if(j>=val) {
						if(dp[i-1][j-val]==true)
							dp[i][j]=true;
					}
				}
			}
		  } 
	   }
	   return dp[arr.length][sum];
    }

	public static void main(String[] args) {
		
		int []arr= {1,5,11,5};
		System.out.println(isSubsetPresent(arr, arr.length,11));
	}
}

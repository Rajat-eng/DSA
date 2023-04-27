package DP;
// elements at even is added
// elements at odd is subtracted
// find max sum possible
public class MaxAlternatingSubsequence {
	
	private static long solution(int[] arr) {
		if(arr.length==0) {
			return Integer.MIN_VALUE;
		}
		long [][] dp=new long[1+arr.length][2];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j]=-1;
			}
		}
		return helper(arr,0,0,dp);
	}

	private static long helper(int[] arr, int idx, int pos,long[][]dp) {
		if(idx>=arr.length) {
			return 0;
		}
		if(dp[idx][pos]!=-1) {
			return dp[idx][pos];
		}
		long ans=0;
		if(pos==0) { // even
			ans=helper(arr, idx+1, 1,dp) + (long)arr[idx]; // make pos odd(1) & add element
		}else {
			ans=helper(arr, idx+1, 0,dp) - (long)arr[idx];
		}
		ans=Math.max(ans, helper(arr, idx+1, pos,dp));
		dp[idx][pos]=ans;
		return ans;
	}

	public static void main(String[] args) {
		int [] arr= {5,3};
		long ans=solution(arr);
		System.out.println(ans);
	}

	

}

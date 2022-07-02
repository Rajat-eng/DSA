package DP;
// given n friends
// find ways in which each can live alone or in pair
public class friendspairing {
	
	public static int pair(int n) {
		int dp[]=new int[1+n];
		for(int i=0;i<=n;i++) {
			dp[i]=-1;
		}
		return pairM(n,dp);
	}


	private static int pairM(int n, int[] dp) {
		
		if(n<=2)
			return n;
		
		if(dp[n]!=-1)
			return dp[n];
		
		
		dp[n]= pairM(n-1,dp) + (n-1)*pairM(n-2,dp);
		return dp[n];
	}


	public static void main(String[] args) {
		int numFriends=3;
		System.out.println(pair(numFriends));
	}

}

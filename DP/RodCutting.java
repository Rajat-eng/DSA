package DP;
//Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n.
//Determine the maximum value obtainable by cutting up the rod and selling the pieces.
public class RodCutting {
	
	private static int solve(int[] price) {
		  int n = price.length;
		int []dp=new int[1+n];
		dp[0]=0;
		for(int i=1;i<=n;i++) {
			dp[i]=Integer.MIN_VALUE;
			for(int j=1;j<=i;j++) {
				int temp=price[j-1]+dp[i-j];
				dp[i]=Math.max(dp[i], temp);
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {

        int price[]  = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int ans =solve(price);
        System.out.println(ans);
	}

	

}

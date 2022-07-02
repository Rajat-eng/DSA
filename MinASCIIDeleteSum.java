package DP;

public class MinASCIIDeleteSum {
	
	private static int solve(String s1, String s2) {
		int m=s1.length(); // row
		int n=s2.length(); // column
		int dp[][]=new int [1+m][1+n];
		for(int i=m;i>=0;i--) {
			for(int j=n;j>=0;j--) {
				if(i==m && j==n) {
					dp[i][j]=0;
				}else if(i==dp.length-1) {
					dp[i][j]=(int)s2.charAt(j) +dp[i][j+1];
				}else if(j==dp[0].length-1) {
					dp[i][j]=(int)s1.charAt(i) +dp[i+1][j];
				}else {
					if(s1.charAt(i)==s2.charAt(j)) {
						dp[i][j]=dp[i+1][j+1];
					}else {
						int op1=(int)s1.charAt(i) + dp[i+1][j];
						int op2=(int)s2.charAt(j) + dp[i][j+1];
						dp[i][j]=Math.min(op1, op2);
					}
				}
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		String s1="eat";
		String s2="sea";
		int ans=solve(s1,s2);
		System.out.println(ans);
	}



}

package DP;

public class LongestCommonSubstring {
	
	private static int solve(String s1, String s2) {
		int dp[][]=new int[1+s1.length()][1+s2.length()];
		int max =Integer.MIN_VALUE;
		for(int i=1;i<dp.length;i++) {
//			 i==0 or j==0 then dp[i][j]=0
			for(int j=1;j<dp[0].length;j++) {
				char ch1=s1.charAt(i-1);
				char ch2=s2.charAt(j-1);
				if(ch1!=ch2) {
					dp[i][j]=0;
				}else {
					dp[i][j]=dp[i-1][j-1]+1;
				}
				if(dp[i][j]>max) {
					max=dp[i][j];
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		String s1="pqabcxy";
		String s2="xyzabcp";
		int ans=solve(s1,s2);
		System.out.println(ans);
	}

	
}

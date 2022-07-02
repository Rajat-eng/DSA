package DP;

import java.util.HashMap;

public class LongestPalindromicSubsequence {
//	 string is c1mc2 
//	if c1=c2  then dp is lps(m) + 2
//	if c1!=c2 then dp is max(c1m,mc2)
		private static int LPS(String s) {	
			int n=s.length();
			int dp[][]=new int[n][n];
			for(int gap=0;gap<n;gap++) {
				for(int i=0,j=gap;j<n;j++,i++) {
					if(gap==0) {
						dp[j][j]=1;
					}else if(gap==1) { // ab=0  &  cc=2
							dp[i][j]=s.charAt(i)==s.charAt(j)?2:1;
					}else {
						if(s.charAt(i)==s.charAt(j)) { // bccb   
							dp[i][j]=dp[i+1][j-1] +2;
						}else {
							dp[i][j]=Math.max(dp[i][j-1], dp[i+1][j]);
						}	
					}
				}
			}
			return dp[0][n-1];
		}
		

		
		
	
	
	public static void main(String[] args) {
		String s="abbcabda";
		System.out.println(countPalindromicSubsequences("abccbc"));
		System.out.println(LPS(s));
	}

}

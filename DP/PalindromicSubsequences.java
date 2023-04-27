package DP;

public class PalindromicSubsequences {
	
	private static int countPalindromicSubsequences(String s) {
//		 string is c1mc2 
//		if c1=c2  then dp is (c1m) +(mc2) + 1
//		if c1!=c2 then dp is (c1m) +(mc2) - m
		int n=s.length();
		int dp[][]=new int[n][n];
		for(int gap=0;gap<n;gap++) {
			for(int i=0,j=gap;j<n;j++,i++) {
				if(gap==0) {
					dp[j][j]=1;
					
				}else if(gap==1) { 
					
					dp[i][j]= (s.charAt(i)==s.charAt(j))? 3:2;  // cc --> c + c + cc
					
				}else {
					
					if(s.charAt(i)==s.charAt(j)) { // bccb
						dp[i][j]=  dp[i][j-1]+ dp[i+1][j] +1; //bccb --> (bcc) + (ccb) + bccb
					}else {
						dp[i][j]=  dp[i][j-1]+ dp[i+1][j] - dp[i+1][j-1];
					}
					
				}
			}
		}
		return dp[0][n-1];
	}
	
	private static int countPalindromicSubstrings(String s) {
		int n=s.length();
		boolean dp[][]=new boolean[n][n];
		int count=0;
		for(int gap=0;gap<n;gap++) {
			for(int i=0,j=gap;j<n;j++,i++) {
				if(gap==0) {
					dp[j][j]=true;
				}
				else if(gap==1) {
					if( s.charAt(i)==s.charAt(j) ) {
						dp[i][j]=true;
					}else {
						dp[i][j]=false;
					}
				}else {
					if( s.charAt(i)==s.charAt(j)  && dp[i+1][j-1]) {
						dp[i][j]=true;
					}else{
						dp[i][j]=false;
					}
				}
				if(dp[i][j] && j-i>=1) // string length>=2
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String s="abbaeae";
		int ans1=countPalindromicSubsequences(s);
		int ans2=countPalindromicSubstrings(s);
		System.out.println(ans1 + " " + ans2);
	}

}

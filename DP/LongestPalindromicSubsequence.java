package DP;

import java.util.HashMap;

public class LongestPalindromicSubsequence {
//	 string is c1mc2 
//	if c1=c2  then dp is lps(m) + 2
//	if c1!=c2 then dp is max(c1m,mc2)
		private static String LPS(String s) {	
			int n=s.length();
			int ans=0,si=-1;
			boolean dp[][]=new boolean[n][n];
			
			for(int gap=0;gap<n;gap++) {
				for(int i=0,j=gap;j<n;j++,i++) {
					
					if(gap==0) {
						dp[j][j]=true;
						
					}else if(gap==1) { // ab=0  &  cc=2
						if(s.charAt(i)==s.charAt(j)) {
							dp[i][j]=true;
						} 
					}else {
						if(s.charAt(i)==s.charAt(j)) { // bccb   
							dp[i][j]=dp[i+1][j-1];			
						}else {
							dp[i][j]=false;
						}	
					}
				
					if(dp[i][j]) {
						int len=j-i+1;
						if(len>ans) {
							ans=len;
							si=i;
						}		
					}
				}
			}
			return s.substring(si,si+ans);
		}
	
	public static void main(String[] args) {
		String s="aacabdkacaa";  // babcbab
		//int removedchar=s.length()-LPS(s);
		
		System.out.println(LPS(s));
	}

}

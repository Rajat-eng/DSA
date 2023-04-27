package DP;

// mississippi
// mis*i.*p*i
// s* can become -,s,ss,sss,sss 
// . can match any char
// solution is s* has to become ss
// .* has to become ssi

public class RegularExpressionMatching {
	
	public static  boolean solve(String source,String pattern) {
//		 j along source
//	     i along pattern
		boolean[][] dp=new boolean[1+ pattern.length()][1+source.length()];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				if(i==0 && j==0) {
					dp[i][j]=true;
				}else if(i==0) {
					dp[i][j]=false;
				}else if(j==0) {
					char pat=pattern.charAt(i-1);
					if(pat=='*') {
						dp[i][j]=dp[i-2][j];
					}else {
						dp[i][j]=false;
					}
				}else {
					char src=source.charAt(j-1);
					char pat=pattern.charAt(i-1);
					if(pat=='*') {
						dp[i][j]=dp[i-2][j];  //s*can become -
						char prevpattern=pattern.charAt(i-2);
						if(prevpattern==src || prevpattern=='.') {
//							pattern prev char before * is equal to last char of source
							dp[i][j]=dp[i][j] || dp[i][j-1];
						}
					}else if(pat=='.') {
//						Diagnol above
						dp[i][j]=dp[i-1][j-1];
					}else if(pat==src) {
//						Diagnol above
						dp[i][j]=dp[i-1][j-1];
					}else { 
//						char pat and src are not equal
						dp[i][j]=false;
					}
				}
			}
		}
		return dp[pattern.length()][source.length()];
	}

	public static void main(String[] args) {
	    String source="mississippi";
	    String pattern="mis*i.*p*i";
	    boolean ans=solve(source, pattern);
	    System.out.println(ans);
	}

}

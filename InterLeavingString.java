package DP;

public class InterLeavingString {
	
	public static boolean solution(String s1,String s2,String s3) {
		if(s1.length() + s2.length() !=s3.length()) {
			return false;
		}
		Boolean dp[][]=new Boolean[1+s1.length()][1+s2.length()];
		return helper(s1,s2,s3,0,0,dp);
	}

	private static boolean helper(String s1, String s2, String s3, int i, int j,Boolean[][] dp) {
		if(i==s1.length() && j==s2.length()) {
			return true;
		}
		if(dp[i][j]!=null) {
			return dp[i][j];
		}
		if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j)) {
			boolean f1=helper(s1, s2, s3, i+1, j,dp);
			dp[i][j]=f1;
			if(f1) {
				return true;
			}
		}
		
		if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j)) {
			boolean f2=helper(s1, s2, s3, i, j+1,dp);
			dp[i][j]=f2;
			if(f2) {
				return true;
			}
		}
		dp[i][j]=false;
		return false;
	}

	public static void main(String[] args) {
		String s1="aabcc";
		String s2="dbbca";
		String s3="aadbbcbcac";
//		s3 is prepared by s1 and s2 in same order. find whether s3 is that so?
		System.out.println(solution(s1, s2, s3));
	}

}

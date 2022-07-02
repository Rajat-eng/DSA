package DP;

import java.util.HashMap;

public class DistinctSubsequences {
	
	private static long countDistinctSubsequences(String s) {
		HashMap<Character,Integer> map=new HashMap<Character, Integer>();
		int n=s.length();
		long dp[]=new long[1+n];
		dp[0]=1; // empty sequence
		for(int i=1;i<=n;i++) {
			dp[i]=2*dp[i-1];
			char ch=s.charAt(i-1);
			if(map.containsKey(ch)) { // if map has already current character
				int j=map.get(ch);  // find its last occurence
				dp[i]=dp[i]-dp[j-1];  //abca now at a subsequenbce in dp[3]-dp[0]
			}else {
				map.put(ch, i);
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		String s="abcbac";
		System.out.println(countDistinctSubsequences(s));
	}

}

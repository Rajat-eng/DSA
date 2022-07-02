package DP;
import java.util.*;
public class DistitnctPalindromicSubsequences {
	
	private static int solve(String s) {
		int n=s.length();
		HashMap <Character,Integer> map=new HashMap<>();
		int[] prev=new int[n]; // storing index of previous repeated charatcer
		int[] next=new int[n]; // storing index of next repeated charatcer
		int dp[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			char ch=s.charAt(i);
			if(map.containsKey(ch)) {
				prev[i]=map.get(ch);
			}else {
				prev[i]=-1;
			}
			map.put(ch, i);
		}
		map.clear();
		for(int i=n-1;i>=0;i--) {
			char ch=s.charAt(i);
			if(map.containsKey(ch)) {
				next[i]=map.get(ch);
			}else {
				next[i]=-1;
			}
			map.put(ch, i);
		}
		
		for(int gap=0;gap<n;gap++) {
			for(int i=0,j=gap;j<n;j++,i++) {
				if(gap==0) {
					dp[i][j]=1;
				}else if(gap==1) {
					dp[i][j]=2;
				}else {
					if(s.charAt(i)!=s.charAt(j)) {
						dp[i][j]=dp[i+1][j] + dp[i][j-1]-dp[i+1][j-1]; // c1m + mc2 -m
					}else { //if equal
						int nextidx=next[i];
						int previdx=prev[j];
						if(nextidx>previdx) {
							//aba
//							2*s(m) +2
							dp[i][j]=2*dp[i+1][j-1]+2;	  	
						}else if(nextidx==previdx) { 
//							one repeating like ababa
//							2*s(m)+1
							dp[i][j]=2*dp[i+1][j-1] +1;
						}else {
//							2*s(m) - s(m*) where m* is s(nextidx + 1 to previdex-1)
							dp[i][j]=2*dp[i+1][j-1] -dp[nextidx+1][previdx-1];
						}
					}
				}
			}
		}
		return dp[0][n-1];
	}

	public static void main(String[] args) {
		String s="abacdaea";
		int ans=solve(s);
		System.out.println(ans);
	}
}

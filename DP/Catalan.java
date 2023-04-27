package DP;

import java.util.Scanner;

public class Catalan {
	
	public static int maxBST(int nodes) {
//		given n nodes count BST possible
		int []dp=new int[1+nodes];
		dp[0]=dp[1]=1;
		for(int i=2;i<=nodes;i++) {
			int left=0;
			int right=i-1;
			while(left<=right-1) {
				dp[i]+=dp[left]*dp[right];
				left++;
				right--;
			}
		}
		return dp[nodes];
	}
	
	public static int count(int n) {
//		given n pairs of upstrokes nad downstrikes count valleys and mountains posiible 
		int []dp=new int[1+n];
		dp[0]=dp[1]=1;
		for(int i=2;i<=n;i++) {
			int inside=0;
			int outside=i-1;
			while(inside<=outside-1) {
				dp[i]+=dp[inside]*dp[outside];
				inside++;
				outside--;
			}
		}
		return dp[n];
	}
	
	public static int countNonIntersectingChords(int points) {
		int chords=points/2;
		int []dp=new int[1+chords];
		dp[0]=dp[1]=1;
		for(int i=2;i<=chords;i++) {
			int left=0;
			int right=i-1;
			while(left<=right-1) {
				dp[i]+=dp[left]*dp[right];
				left++;
				right--;
			}
		}
		return dp[chords];
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
	}

}

package DP;

import java.util.Arrays;

//Longest subsequence such that adjacent elements have at least one common digit
public class LSwithOneCommonDigit {
	
	public static int solve(int [] input) {
		int length=0;
		int maxdigit=0;
		int [] dp=new int[10];
		int [] cnt=new int[10];
		int temp=input[0];
		while(temp!=0) {
			dp[temp%10]=1;
			temp/=10;
		}
		for(int i=1;i<input.length;i++) {
			temp=input[i];
			maxdigit=1;
			Arrays.fill(cnt, 0);
			while(temp!=0) {
				cnt[temp%10]=1;
				temp/=10;
			}
//			finding digits which are repeated
//			finding 
			for(int d=0;d<=9;d++) {
				if(cnt[d]==1) {
					dp[d]++;
					maxdigit=Math.max(maxdigit, dp[d]);
				}
			}
//			updating dp with local max where count is 1
			for(int d=0;d<=9;d++) {
				if(cnt[d]==1) {
					dp[d]=maxdigit;
				}
			}
			length=Math.max(maxdigit, length);
		}
		return length;
	}

	public static void main(String[] args) {
		 int arr[] = {1, 12, 44, 29, 33, 96, 89};
		 // ans is 1,12,29,96,89  length is 5
		 int ans=solve(arr);
		 System.out.println(ans);
	}

}

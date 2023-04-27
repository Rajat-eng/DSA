package DP;
// given size of set
// count ways to partition it in k or less than k subsets
// Let the set be {1, 2, 3}, we can partition
// it into 2 subsets in following ways
// {{1,2}, {3}},  {{1}, {2,3}},  {{1,3}, {2}}  

import java.util.Scanner;
//  to print use Backtracking
public class partitionintosubsets {
	
	public static int count(int n,int k) {
		if(n==0||k==0||k>n)
			return 0;
		if(k==1 || k==n)
			return 1;
//		 (1234,3)--  recursion
//		if 123 can make 3 partition then 4 can come woth anyone in 3 ways --> 14-2-3 || 1-24-3 || 1-2-34   --  k*f(n-1,k)
//	    if 123 can make 2 partition then 4 can come like   1-23-4 || 12-3-4 || 13-2-4  --> f(n-1,k-1)
		return k*count(n-1,k)+count(n-1,k-1);
	}
	
	public static int countDP(int n,int k) {
		int[][] dp=new int[1+n][1+k];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				if(j==1)
					dp[i][j]=1;
				else {
					if(i==j)
						dp[i][j]=1;
					else if(i<j)
						dp[i][j]=0;
					else {
						dp[i][j]=j*dp[i-1][j]+dp[i-1][j-1];
					}		
				}
			}
		}
		return dp[n][k];
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int sizeofset=sc.nextInt();
		int partitionsize=sc.nextInt();
		System.out.println(count(sizeofset,partitionsize));
		System.out.println(countDP(sizeofset,partitionsize));
		sc.close();
	}

}

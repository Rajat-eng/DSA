package DP;
// find cost such that search cost for keys is minimum
public class optimalBST {
	
	private static int solve(int[] keys, int[] frequency) {
		int n=keys.length;
		int[][] dp=new int[n][n];
		int[] prefixfreq=new int[n];
		prefixfreq[0]=frequency[0];
		for(int k=1;k<n;k++) {
			prefixfreq[k]=prefixfreq[k-1] + frequency[k];
		}
//		prefixarray-->> 1 3 6 10 15
 		for(int gap=0;gap<n;gap++) {
			for(int i=0,j=gap;j<n;i++,j++) {
				if(gap==0) {
					dp[i][j]=frequency[i];
				}else if(gap==1) {
					int f1=frequency[i];
					int f2=frequency[j];
//					10         20
//			1+2*2	\		   /       2+1*2
//					 20		   10
					dp[i][j]=Math.min(f1+2*f2, f2+2*f1);
				}else {
					dp[i][j]=Integer.MAX_VALUE;
//					 abc -- > min( a+(bc), (b)+(a)+(c), (ab)+(c) ) + (a+b+c)
					for(int k=i;k<=j;k++) {
						int left =  k==i?0:dp[i][k-1];
						int right=  k==j?0:dp[k+1][j];
						int frequencysum= (prefixfreq[j]) - (i==0?0:prefixfreq[i-1]); 
						int totalcost=left+right+frequencysum;
						dp[i][j]=Math.min(dp[i][j], totalcost);
					}
				}
			}
		}
		return dp[0][n-1];
	}

	public static void main(String[] args) {
		int keys[]= {10,20,30,40,50};
		int frequency[]= {1,2,3,4,5};
		int ans=solve(keys,frequency);
		System.out.println(ans);
	}



}

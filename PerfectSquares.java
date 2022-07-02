

package DP;

public class PerfectSquares {

	public static void main(String[] args) {
		int n=10;
		int[]dp=new int[1+n];
		dp[0]=0;
		dp[1]=1;
		for(int i=2;i<dp.length;i++) {
			int min=Integer.MAX_VALUE;
			for(int j=1;j*j<=i;j++) {
				int rem=i-j*j;
				if(dp[rem]<min)
					min=dp[rem];
			}
			dp[i]=1+min;
			System.out.print(dp[i] + " ");
		}
		System.out.println(dp[n]);
	}

}

package DP;

public class MCM {

	public static int matrixMultiplication(int[] arr, int N) {
	    int dp[][] =new int[N-1][N-1];
	    int n=dp.length;
	    for(int l=0;l<n;l++) {
			for(int i=0,j=l;j<n;i++,j++) {
				if(l==0) {
					dp[i][j]=0;
				}else if(l==1) {
					dp[i][j]=arr[i]*arr[j]*arr[j+1];
				}else {
					dp[i][j]=Integer.MAX_VALUE;
					for(int k=i;k<j;k++) {
//						ABCDE== A+BCDE, AB+CDE, ABC+DE, ABCD+E  i is A j is E
						int left=dp[i][k];
						int right=dp[k+1][j];
						int dimension=arr[i]*arr[k+1]*arr[j+1];
						int temp=left+right+dimension;
						dp[i][j]=Math.min(dp[i][j],temp);
					}		
				}
//				System.out.print(dp[i][j] + " ");
			}
//			System.out.println();
	    }
	    return dp[0][n - 1];
	}

	public static void main(String[] args) {
		int []arr= {10,20,30,40,50,60};
		int ans=matrixMultiplication(arr, arr.length);
		System.out.println(ans);
	}

}

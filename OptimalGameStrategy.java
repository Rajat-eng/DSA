package DP;

public class OptimalGameStrategy {
	

	private static int solution(int[] arr, int length) {
		int [][] dp=new int[length][length];
		for(int g=0;g<length;g++) {
			for(int i=0,j=g;j<length;i++,j++) {
				if(g==0) {
					dp[i][j]=arr[i];
				}else if(g==1) {
					dp[i][j]=Math.max(arr[i], arr[j]);
				}else {
//					if you pick 1st element then opponent can pick i+1 or jth element . opponent will pick elemnt such that you are left with min option
//					opponent picks i+1 then your value is min (i+2,j) element
					int v1= arr[i] + Math.min(dp[i+2][j], dp[i+1][j-1]);
//					opponent picks j then your value is min (i+1,j-1) element
					int v2= arr[j] + Math.min(dp[i+1][j-1], dp[i][j-2]);
					dp[i][j]=Math.max(v1, v2);
				}
			}
		}
		return dp[0][length-1];
	}

	public static void main(String[] args) {
		int[] arr= {20,30,2,10};
//		given arr there are two opponents. you can only pick coins from either end
//		find max sum that you can collect by winning
		int ans=solution(arr,arr.length);
		System.out.println(ans);
	}


}

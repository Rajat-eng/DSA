package DP;
//Given an array A[] consisting of N integers, where each value represents the marks of the ith student
//find the minimum number of chocolates required to be distributed such that:
	//Each student should be awarded with at least one chocolate
	//A student with higher marks should be awarded more chocolates than his adjacent students.
public class MinChocolateDistribution {
	private static int solution(int[] arr, int length) {
		int dp[]=new int[length];
		dp[0]=1;
		for(int i=1;i<length;i++) {
			if(arr[i]>arr[i-1]) {
				dp[i]=dp[i-1]+1;
			}else {
				dp[i]=1;
			}
		}
		int sum=0;
		for(int i=length-2;i>=0;i--) {
			
			if(arr[i]>arr[i+1]) {
				dp[i]=Math.max(dp[i+1] +1, dp[i]);
			}else {
				dp[i]=Math.max(dp[i],1);
			}
			sum+=dp[i];
		}
		return sum + dp[length-1];
	}

	public static void main(String[] args) {
		int arr[]= {1,2,10,7,6,4,5,5,5,6};
		int ans=solution(arr,arr.length);
		System.out.println(ans);
	}

	

}

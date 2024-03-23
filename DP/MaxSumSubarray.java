package DP;

public class MaxSumSubarray {

	public static long maxSubarraySum(int[] arr, int n) {

		if(n==0){
			return 0L;
		}
		
		long totalSum=0;
		long tempSum=0;
		for(int i=0;i<n;i++){
			
			tempSum+=arr[i];
			
			if(tempSum>=totalSum){
				totalSum=tempSum;
			}

			if(tempSum<=0){
				tempSum=0;
			}
		}
		if(totalSum<=0){
			return 0L;
		}
		return totalSum;
	}
	public static void main(String[] args) {
		int [] arr= {4,3,-2,6,7,-10,-10,4,5,9,-3,4,7,-28,2,9,3,2,11};
		System.out.println(maxSubarraySum(arr,arr.length));
	}
}

package DP;

public class MinAbsoluteDiffSubset {
	
	public static  int findMin(int[] arr) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		return helper(arr,0,0,sum);
	}

	private static int helper(int[] arr, int idx, int sumcalculated, int sum) {
		
		if(idx==arr.length-1){
//			current subset sum ia sumcalculated 
//			another subset sum is sum-sumcalculated
//			overall difference is sum-2*sumcalculated
			return Math.abs(sum-2*sumcalculated);  
		}
		int op1=helper(arr, 1+idx, sumcalculated+arr[idx], sum);
		int op2=helper(arr, 1+idx, sumcalculated, sum);
		return Math.min(op1,op2);
	}

	public static void main(String[] args) {
		int[] arr= {1,2,6,5};
		int ans=findMin(arr);
		System.out.println(ans);
	}

}

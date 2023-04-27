package DP;

public class MaxSumSubarray {

	private static int solve(int[] arr) {
		int csum=arr[0];
		int osum=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(csum>0) {
				csum+=arr[i];
			}else {
				csum=arr[i];
			}
			if(csum>osum) {
				osum=csum;
			}
		}
		return osum;
	}
	public static void main(String[] args) {
		int [] arr= {4,3,-2,6,7,-10,-10,4,5,9,-3,4,7,-28,2,9,3,2,11};
		System.out.println(solve(arr));
	}
}

package DP;

public class MaxSumArrayWithAtLeastKelements {
	
	private static int solution(int[] arr, int k) {
		int ans=Integer.MIN_VALUE;	
		int csum=arr[0];
		int [] maxsum=new int[arr.length];
		maxsum[0]=arr[0];// max sum ending at each element
		
		for(int i=1;i<arr.length;i++) {
			if(csum>0) {
				csum+=arr[i];
			}else {
				csum=arr[i];
			}
			maxsum[i]=csum;
		}
		int exactSumK=0;
		for(int i=0;i<k;i++) {
			exactSumK+=arr[i];
		}
		ans=Math.max(ans,exactSumK);
		int SumMoreThanK=0;
		for(int i=k;i<arr.length;i++) {
//			shifting window forward
			exactSumK+=arr[i]-arr[i-k];
//			exactsum of window + max sum before window stating point using Kadans algorithm
			SumMoreThanK=exactSumK+maxsum[i-k];
			ans=Math.max(SumMoreThanK, exactSumK);
		}
		return ans;
	}

	public static void main(String[] args) {
		int [] arr= {2,3,1,-7,6,-5,-4,4,3,3,2,-9,-5,6,1,2,1,4};
		int ans=solution(arr,4);
		System.out.println(ans);
	}

	

}
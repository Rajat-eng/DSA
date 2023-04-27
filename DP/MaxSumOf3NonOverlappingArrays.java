package DP;

public class MaxSumOf3NonOverlappingArrays {
	
	public static void sum(int[] arr,int k) {
		int n=arr.length;
		int [] left=new int[n];   // max sum of k size window at ith index
		int [] right=new int[n];  // max sum of k size window from last index to ith index
		int prefixSum[]=new int[n];
		
		for(int i=0;i<n;i++) {
			if(i==0) {
				prefixSum[i]=arr[i];
			}else {
				prefixSum[i]=prefixSum[i-1]+arr[i];
			}
		}
		int sum=0;
		for(int i=0;i<n;i++) { // moving window of size 3 from left to right and storing in left array
			if(i<k) {
			sum+=arr[i];
			left[i]=sum;
			}else {
			sum+=arr[i]-arr[i-k];
			left[i]=Math.max(left[i-1], sum);		
			}
			System.out.print (left[i] + " ");
		}
		
		System.out.println();
		sum=0;
		for(int i=n-1;i>=0;i--) {  // moving window of size 3 from right to left and storing in right array
			if(i>=n-k) {
			sum+=arr[i];
			right[i]=sum;
			}else {
			sum+=arr[i]-arr[i+k];
			right[i]=Math.max(right[i+1], sum);		
			}
			System.out.print(right[i] + " ");
		}
		
//		Now starting index of mid array can vary from k to n-2k( 4 to 7 here for non overlapping) 
//		maxsum can be sum of left subarray before start of mid array + sum of right subarray after end point midarray + sum of k size mid array
		int maxsum=0;
		int simsa=0;// starting index if middle subarray
		int silsa=0;// starting index if left subarray
		int lsum=0; // sum of left  subarray
		int rsum=0; // sum of right subarray
		int sirsa=0;// starting index if right subarray
		for(int i=k;i<=n-2*k;i++) {
			if(left[i-1] + prefixSum[i+k-1]-prefixSum[i-1] + right[i+k]>maxsum) {
				maxsum= left[i-1] + prefixSum[i+k-1]-prefixSum[i-1] + right[i+k];
				lsum=left[i-1];
				rsum=right[i+k];
				simsa=i;
			}
		}
		
		for(int i=0;i<simsa;i++) {
			// finding point where first lsum is found
			if(  prefixSum[i]- (i-k<0? 0:prefixSum[i-k]) ==lsum  ) {
				silsa=i-k+1;
				break;
			} 
		}
		for(int i=simsa+2*k-1;i<n;i++) {
			// finding point where first lsum is found
			if(  prefixSum[i]- (i-k<0? 0:prefixSum[i-k]) ==rsum  ) {
				sirsa=i-k+1;
				break;
			} 
		}
		System.out.println( "maxsum:" + maxsum  );
		System.out.println("leftStartingindex:" + silsa);
		System.out.println("rightStartingindex:" + sirsa);
	}
	

	public static void main(String[] args) {
		int[] arr= {5,2,1,4,3,4,2,1,3,6,3,3,6};
		int n=arr.length;
		sum(arr, 3);
		
	}
}

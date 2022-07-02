

package DP;
import java.util.ArrayList;

// Count minimum number of fountains to be activated to cover the entire garden
// Given an array a[]such that a[i] describes the coverage limit of ith fountain. 
// A fountain can cover the range from the position max(i – a[i], 1) to min(i + a[i], N).
public class minFountains {
	
	public static int solve (int[]arr) {
		int min=0,max=0,open=0;
		while(max<arr.length) {
			for(int i=0;i<arr.length;i++) {
				max = (i-arr[i]<=min && i+arr[i]>=max)? i+arr[i]:max;  // finding fountains which goes to left bound(min) and has max reach
			}
			if(min==max) // if max is not updated cannot fill whole garden
				return -1;
			open++;
			min=max;  // finding fountain which goes till min and again update max after while loop
		}
		return open;	
	}

	public static void main(String[] args) {
		int[] arr= {2,1,1,2,1};
		System.out.println(solve(arr));
	}

}

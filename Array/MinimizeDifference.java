import java.util.Arrays;
//Given an array of N integers and an integer k. It is allowed to modify an element either by increasing or decreasing them by k (only once).
//The task is to minimize and print the maximum difference between the shortest and longest towers.
public class MinimizeDifference {

//  find max and min --> sort the array	
//	to minimize max diff it is (max-k)-(min-k) 
//  {a    x     y    b}  update   to minimize it is b-k-(a+k) 
//	min difference is between adjavcent element  therefore
//  new min is min(a+k,y-k)
//	new max is max(b-k,x+k)
	public static int findMin(int[] arr,int k) {
		Arrays.sort(arr);
		int n=arr.length;
		int ans=arr[n-1]-arr[0];
		for(int i=1;i<n;i++) {
			int min=Math.min(arr[0]+k,arr[i]-k);
			int max=Math.max(arr[n-1]-k, arr[i-1]+k);
			int diff=max-min;
			ans=Math.min(ans, diff);
		}
		return ans;
	}
	
	public static int findMin1(int[]arr,int k) {
//		minimize diff between max and min by removing exactly k elements
		Arrays.sort(arr);
		int n=arr.length;
		int left=0;
		int right=n-1;
		for(int i=0;i<k;i++) {
//			consider arr[left+1 to right] and arr[left -- right-1]
			if(  ( arr[right]-arr[left+1] ) < ( arr[right-1]-arr[left] )  ) {
				left++;
			}else {
				right--;
			}
		}
		return arr[right]-arr[left];
	}
	
	public static void main(String[] args) {
		int[] arr={3, 16, 12, 9, 20};
		int ans=findMin(arr, 3);
		System.out.println(ans);
	}

}

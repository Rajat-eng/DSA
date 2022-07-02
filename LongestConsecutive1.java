package HashMap;

public class LongestConsecutive1 {
	
	private static void solve(int[] arr, int k) {
		int i=-1;
		int j=-1;
		int count=0;
		int ans=0;
		while(i<arr.length-1) {
			i++;
			if(arr[i]==0) {
				count++;
			}
			while(count>k) {
				j++;
//				release till next zero
				if(arr[j]==0) {
					count--;
				}
			}
//			count is k here
			int length=i-j;
			if(length>ans) {
				ans=length;
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		int[]arr= {1,1,0,1,0,0,1,1,0,1,0,1,1};
		int k=2; // At most two zeros can be flipped to 1
		solve(arr,k);
	}

}

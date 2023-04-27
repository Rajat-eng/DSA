package HashMap;
import java.util.*;
public class LargestContigousSubArray {

	private static void solve(int [] arr) {
		int length=0;
		int maxlength=Integer.MIN_VALUE;
		HashSet<Integer> duplicate=new HashSet<>();
		for(int i=0;i<arr.length-1;i++) {
			int min=arr[i];
			int max=arr[i];
			duplicate.add(arr[i]);
			for(int j=i+1;j<arr.length;j++) {
				if(duplicate.contains(arr[j])) {
					break; // eg 9886 is not valid
				}
				min=Math.min(min,arr[j]);
				max=Math.max(max, arr[j]);
				
				if(max-min>arr.length)
					break;
				
				if(max-min==j-i) {
					length=j-i+1;
					if(length>maxlength) {
						maxlength=length;
					}
				}
			}
		}
		System.out.println(maxlength);
	}
	public static void main(String[] args) {
		int [] arr= {9,2,7,5,6,23,24,22,23,19,16,17,18,39,0};
		solve(arr);
	}

}

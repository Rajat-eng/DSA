package HashMap;
import java.util.HashMap;
public class ZeroSumSubArray {
	
	private static void largestSubArray(int[] arr) {
		HashMap<Integer,Integer> map=new HashMap<>();
		int max=Integer.MIN_VALUE;
		int sum=0;
		int i=-1;
		map.put(sum, i);
		while(i<arr.length-1) {
			i++;
			sum+=arr[i];
			if(map.containsKey(sum)) {
				int length=i-map.get(sum);
				if(length>max) {
					max=length;
				}
			}else {
				map.put(sum, i);
			}
		}
		System.out.println(max);
	}
	
	
	private static void countZeroSumArray(int[] arr) {
		HashMap<Integer,Integer> map=new HashMap<>();
		int sum=0;
		int i=-1;
		int count=0;
		map.put(sum, 1);
		
		while(i<arr.length-1) {
			i++;
			sum+=arr[i];
			if(map.containsKey(sum)) {
				count+=map.get(sum);
				map.put(sum,map.get(sum)+1);
			}else {
				map.put(sum, 1);
			}
		}
		System.out.println(count);
	}
	
	
	public static void main(String[] args) {
		int[]arr= {2,8,-3,-5,2,-4,6,1,2,1,-3,4};
		largestSubArray(arr);
		countZeroSumArray(arr);
		
	}

}

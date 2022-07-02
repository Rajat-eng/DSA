package HashMap;
import java.util.HashMap;
public class CountSubArraySumEqualK {
	
	private static int solve(int[] arr, int k) {
		int count=0;int sum=0;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		map.put(sum, 1);
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			map.put(sum, map.getOrDefault(sum, 0)+1);
			int remsum=sum-k;
			if(map.containsKey(remsum)) {
				count+=map.get(remsum);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[]arr= {3,9,-2,4,1,-7,2,6,-5,8,-3,-7,6,2,1};
		int k=5;
		System.out.println(solve(arr,k));
	}

}

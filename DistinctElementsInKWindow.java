package HashMap;
import java.util.*;
public class DistinctElementsInKWindow {

	private static List<Integer> solve(int[] arr, int k) {
		List<Integer> list=new ArrayList<Integer>();
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		int i=0;
		while(i<k-1) {
			map.put(arr[i],map.getOrDefault(arr[i], 0) + 1);
			i++;
		}
		i--;
		int j=-1;
		while(i<arr.length-1) {
			i++;
			map.put(arr[i],map.getOrDefault(arr[i], 0) + 1); // acquire last window element
			list.add(map.size());
			j++;
			int freq=map.get(arr[j]);
			if(freq==1) {
				map.remove(arr[j]);
			}else {
				map.put(arr[j],freq-1);
			}
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		int[]arr= {2,5,5,6,3,2,3,2,4,5,2,2,2,2,5,6};
		int k=4;
		List<Integer> ans=new ArrayList<Integer>();
		ans=solve(arr,k);
		for(int i:ans) {
			System.out.print(i + " ");
		}
		
	}

	
}

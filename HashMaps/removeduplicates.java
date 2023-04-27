package HashMap;
import java.security.KeyStore.Entry;
import java.util.*;
public class removeduplicates {
	
	public static ArrayList<Integer> remove(int arr[]){
		ArrayList<Integer> output=new ArrayList<>();
		HashMap<Integer,Boolean> seen=new HashMap<>();  // currently it has false for all inetger values
		for(int i=0;i<arr.length;i++) {
			if(seen.containsKey(arr[i])) {
				continue;
			}
			seen.put(arr[i], true);
			output.add(arr[i]);
		}
		return output;
	}
	
	public static int maxFrequencyNumber(int[] arr) {
		HashMap<Integer,Integer> seen=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(seen.containsKey(arr[i])) {
				int freq=seen.get(arr[i]);
				freq++;
				seen.put(arr[i], freq);
			}else {
				seen.put(arr[i], 1);
			}
		}
		int max=Integer.MIN_VALUE;
		int ans=-1;
		for(Integer i: arr) {
			if(seen.get(i)>max) {
				max=seen.get(i);
				ans=i;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int [] arr= {-2,2,-2,2,6,-6,3};
		int ans=427%26;
		System.out.println(ans);
	}

}

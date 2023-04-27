package HashMap;
import java.util.*;
public class CountOfEquivalentSubArrays {
	
	private static void solve(int[] arr, int k) {
		int ans=0;
		HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
		int i=-1,j=-1;
		while(true) {
			boolean f1=false;
			boolean f2=false;
			while(i<arr.length-1) {
				f1=true;
				i++;
				map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
				if(map.size()==k) {
					ans+=arr.length-i;
					break;
				}
			}
			while(j<i) {
				f2=true;
				j++;
				if(map.get(arr[j])==1) {
					map.remove(arr[j]);
				}else {
					map.put(arr[j],map.get(arr[j])-1);
				}
				if(map.size()==k) {
					ans+=arr.length-i;
				}
				else {
					break;
				}
			}
			if(f1==false&&f2==false) {
				break;
			}
		}
		
		System.out.println(ans);
		
	}

	public static void main(String[] args) {
		int []arr= {2,5,3,5,2,4,1,3,1,4};
		HashSet<Integer> set=new HashSet<>();
	
		
		for(int i=0;i<arr.length;i++) {
			set.add(arr[i]);
		}
		int k=set.size();
		solve(arr,k);
		
	}
}

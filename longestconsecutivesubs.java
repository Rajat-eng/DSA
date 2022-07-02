package HashMap;
import java.util.*;
public class longestconsecutivesubs {
	
public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		HashMap<Integer,Boolean> map=new HashMap<>();
		ArrayList<Integer> ans=new ArrayList<>();
		
		for(int i:arr) {
			map.put(i, true);
		}
		
		for(int i:arr) {
			if(map.containsKey(i-1)) {
				map.put(i, false);
			}
		}
		int msp=0;
		int ml=0;
		for(int i:arr) {
			if(map.get(i)==true) {
				int tsp=i;
				int tl=1;
				while(map.containsKey(tsp+tl)) {
					tl++;
				}
				if(tl>ml) {
					ml=tl;
					msp=tsp;
				}
			}
		}
		for(int i=0;i<ml;i++) {
			ans.add(msp +i);
		}	
		return ans;
	}

	public static void main(String[] args) {
		int []a= {10,5,9,1,11,8,6,15,3,12,2};
		ArrayList<Integer> ans=longestConsecutiveIncreasingSequence(a);
		for(int i:ans) {
			System.out.print(i +" ");
		}
	}

}

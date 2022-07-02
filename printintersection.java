package HashMap;

import java.util.HashMap;

public class printintersection {
	

	public static void printIntersection(int[] arr1,int[] arr2) {
		HashMap<Integer,Integer> seen=new HashMap<>();
		for(int i=0;i<arr1.length;i++) {
			if(seen.containsKey(arr1[i])) {
				int freq=seen.get(arr1[i]);
				freq++;
				seen.put(arr1[i], freq);
			}else {
				seen.put(arr1[i], 1);
			}
		}
		for(Integer i: arr2) {
			if(seen.containsKey(i)&& seen.get(i)>0 ) {
				System.out.print(i + " ");
				int freq=seen.get(i);
				freq--;
				seen.put(i, freq);
			}
		}		
	}

	public static void main(String[] args) {
		int [] a= {1,2,2,3,-1,4,4,5};
		int [] b= {2,-1,-1,2,4,5,5};
		printIntersection(a, b);
	}

}

package HashMap;

import java.util.HashMap;

public class sumanddiff {
	
	public static int PairSum(int[] input, int size,int sum) {
		  HashMap<Integer,Integer> seen=new HashMap<>();
		  int count=0;
		  for(int i=0;i<size;i++) {
			int val=input[i];
			int comp=sum-val;
			if(seen.containsKey(comp) ) {
				int freqcomp=seen.get(comp);
				while(freqcomp>0) {
					count++;
					System.out.println(val +" " +comp);
					freqcomp--;
				}	
			}
			if(seen.containsKey(val)) {
				int freq=seen.get(val);
				freq++;
				seen.put(val, freq);
			}
			else {
				seen.put(val, 1);
			}
	      }
		return count;
	   }
	
	public static int getPairsWithDifferenceK(int arr[], int k) {
		HashMap<Integer,Integer> hp=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(hp.containsKey(arr[i])) {
				int freq=hp.get(arr[i]);
				freq++;
				hp.put(arr[i], freq);
			}else {
				hp.put(arr[i], 1);
			}
		}
		if(  hp.size()==1 && hp.get(arr[0])>1)  {
			int n=hp.get(arr[0]);
			for(int i=0;i<n;i++) {
				System.out.println(arr[0] + " " + arr[0]);
			}
            return n*(n-1)/2;
		}
		int count=0;
		for(Integer key: hp.keySet() ) {
			int freq=hp.get(key);
			while(freq>0) {
				if(hp.containsKey(key+k) && hp.get(key+k)>0) {
					int fl=hp.get(key+k);
					while(fl>0) {
						count++;
						System.out.println(key+k + " " +key);
						fl--;
					}
				}
				if(hp.containsKey(key -k) && hp.get(key-k)>0) {
					int fs=hp.get(key-k);
					while(fs>0) {
						count++;
						System.out.println(key-k + " " +key);
						fs--;
					}
				}
				freq--;
			}
			hp.put(key,freq);
		}
		return count;
	}
	

	public static void main(String[] args) {
		int a[]= {2,-1,3,5,6,0,-1,2,6}; //3
		int b[]= {2,2,2,2}; //0
		System.out.println(getPairsWithDifferenceK(b, 0));

	}

}

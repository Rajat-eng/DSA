package HashMap;

import java.util.HashMap;

public class sumanddiff {
	
	public static int PairSum(int[] input, int size,int sum) {
		  HashMap<Integer,Integer> seen=new HashMap<>();
		  int count=0;
		  for(int i=0;i<size;i++) {
			int val=input[i];
			if(seen.containsKey(val)) {
				int freq=seen.get(val);
				freq++;
				seen.put(val, freq);
			}
			else {
				seen.put(val, 1);
			}
	      }
		  
		  for(int key:seen.keySet()) {
			  int freq=seen.get(key);
			  int comp=sum-key;
			  if(key==comp) {
				  int k=freq*(freq-1)/2; // 5 5 5 5
				  while(k-->0) { 
					  count++;
				  }  
			  }else {
				  while(freq-->0) {
					  if(seen.containsKey(comp)) {
						  int freqc=seen.get(comp);
						  while(freqc-->0) {
							  count++;
							  System.out.println(key + " " + comp);
						  }
					  }
				  }
			  }
			  seen.put(key, 0);
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
//			hp.remove(key);
			hp.put(key, freq);
		}
		return count;
	}
	

	public static void main(String[] args) {
		int a[]= {2,-1,3,5,6,0,-1,2,6}; //3
		int b[]= {2,2,5}; //0
		int c[]= {3,3,5,5,5,5,6,4,4,7,7};
		System.out.println(PairSum(c, c.length, 10));
		//System.out.println(getPairsWithDifferenceK(a, 3));

	}

}

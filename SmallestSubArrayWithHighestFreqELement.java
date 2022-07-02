package HashMap;
import java.util.HashMap;
public class SmallestSubArrayWithHighestFreqELement {
	
	private static void solve(int[] arr) {
		int si=0,ei=0,hfreq=0;
		int length=ei-si+1;
		HashMap<Integer,Integer> smap=new HashMap<>();// starting index map
		HashMap<Integer,Integer> fmap=new HashMap<>();// freq map
		for(int i=0;i<arr.length;i++) {
			int element=arr[i];
			if(fmap.containsKey(element)) {
				fmap.put(element, fmap.get(element)+1);
			}else {
				fmap.put(element,1);
				smap.put(element, i);
			}
			if(fmap.get(element)>hfreq) {
				si=smap.get(element);
				ei=i;
				length=ei-si+1;
				hfreq=fmap.get(element);
			}else if(fmap.get(element)==hfreq) {
//				equals
				int clen=i-smap.get(element)+1;
				if(clen<length) {
					si=smap.get(element);
					ei=i;
					length=ei-si+1;
					hfreq=fmap.get(element);
				}
			}
		}
		for(int x=si;x<=ei;x++) {
			System.out.print(arr[x]+" ");
		}
	}

	public static void main(String[] args) {
		int[]arr= {1,3,2,4,2,3,4,2,5,6,5,5,7};
		solve(arr);
	}

}

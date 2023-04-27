
package HashMap;
import java.util.*;


public class TrafficLights {
	

	public static void main(String[] args) {
		int n=4,x=7;
		int []pos= {1,2,3,4};
		ArrayList<Integer> ans=solve(n,x,pos);
		System.out.println(ans);

	}

	private static ArrayList<Integer> solve(int n, int x, int[] pos) {
		ArrayList<Integer> ans=new ArrayList<Integer>();
		TreeSet<Integer> set=new TreeSet<Integer>();
		set.add(0);
		set.add(x);
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		String key= getKey(0,x);
		map.put(key, x);
		
		
		for(int i=0;i<n;i++) {
			int l=pos[i];
			Integer upperbound=set.higher(l);
			Integer lowerbound=set.lower(l);
			key=getKey(lowerbound,upperbound);
			
			if(map.containsKey(key)) {
				map.remove(key);
				String lowerKey=getKey(lowerbound,l);
				map.put(lowerKey,l-lowerbound);
				String upperKey=getKey(l,upperbound);
				map.put(upperKey,upperbound-l);
			}
			
			int value=Collections.max(map.values());
			ans.add(value);
			set.add(l);
		}
		return ans;
	}

	private static String getKey(int x, int y) {
		String s=x+"#"+y;
		return s ;
	}

}

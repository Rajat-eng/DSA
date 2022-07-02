package HashMap;
import java.util.HashMap;
public class RabbitsInForest {
	
	

	public static void main(String[] args) {
//		3 means rabbit is saying I belong to group of 4 which have same color
		int[]arr= {3,3,3,3,3,3,3,2,2,2,2,2,2,4,4,4,4,4,4,4,4,4,0,0,1,1,1};
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		int ans=0;
		for(int key:map.keySet()) {
			int groupsize=key+1;
			int rabbits=map.get(key);
			int adjusted=(int)Math.ceil(rabbits*1.0/groupsize*1.0);
			ans+=groupsize*adjusted;
		}
		System.out.println(ans);
	}

}

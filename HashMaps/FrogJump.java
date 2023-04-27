package HashMap;
import java.util.*;
public class FrogJump {
//	   at 0 pos only 1 jump forward is allowed
//	   At other points frog can take either k-1.k.k+1 jump where k is  previous jump taken by frog
	public static void main(String[] args) {
	  int [] stone= {0,1,3,5,6,8,12,17};
	  HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
	  for(int i=0;i<stone.length;i++) {
		  map.put(stone[i], new HashSet<Integer>());
	  }
	  map.get(0).add(1); // 0 has only 1 jump
	  for(int i=0;i<stone.length;i++) {
		  int currentstone=stone[i];
		  HashSet<Integer> jumps=map.get(currentstone);
		  for(int jump:jumps) {
			  int nextpositionafterjump=currentstone+jump;
			  if(nextpositionafterjump==stone[stone.length-1]) {
				  System.out.println(true);
				  return;
			  }
			  if(map.containsKey(nextpositionafterjump)) {
				  if(jump-1!=0) {
					  map.get(nextpositionafterjump).add(jump-1);
				  }
				  map.get(nextpositionafterjump).add(jump);
				  map.get(nextpositionafterjump).add(jump+1);
			  }
		  }
	  }
	  System.out.println(false);
	}

}

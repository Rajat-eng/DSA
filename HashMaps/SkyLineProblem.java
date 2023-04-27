package HashMap;
import java.util.*;
public class SkyLineProblem {
	public class pair implements Comparable<pair>{
        int x;
        int ht;
        pair(int x,int ht){
            this.x=x;
            this.ht=ht;
        }
        public int compareTo(pair o){
            if(this.x==o.x){
                return this.ht-o.ht;
            }
            return this.x-o.x;
        }
    }
	
	 public static List<List<Integer>> getSkyline(int[][] buildings) {
	        List<pair> list=new ArrayList<pair>();
	        for(int i=0;i<buildings.length;i++){
	             int sp=buildings[i][0];
	             int ep=buildings[i][1];
	             int ht=buildings[i][2];
	             list.add(new pair(sp,-ht));
	             list.add(new pair(ep,ht));
	        }
	        Collections.sort(list);
	        
	        List<List<Integer>> ans=new ArrayList<>();
	        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
	        pq.add(0);
	        int cht=0;
	        for(int i=0;i<list.size();i++){
	            int x=list.get(i).x;
	            int ht=list.get(i).ht;
	            if(ht<0){
	                pq.add(-ht);
	            }else{
	                pq.remove(ht); 
	            }
	            if(cht!=pq.peek()){
	                List<Integer> temp=new ArrayList<>();
	                temp.add(x);
	                temp.add(pq.peek());
	                ans.add(temp);
	                cht=pq.peek();
	            }
	        }
	        return ans; 
	    }
	    
	public static void main(String[] args) {
		
		int [][]buildings = {
				{2, 9, 10},
				{3, 7, 15},
				{5, 12,12},
				{15,20,10},
				{19,24, 8}
		};
		List<List<Integer>> ans= getSkyline(buildings);
	}

}

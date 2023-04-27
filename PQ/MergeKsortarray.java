package PQ;
import java.util.*;

 class pair implements Comparable<pair>{
    int li;
    int di;
    int val;
    pair(int li,int di,int val){
        this.li=li;
        this.di=di;
        this.val=val;
    }
    
    public int compareTo(pair o){
       return this.val-o.val;
    }
}
 
   public class MergeKsortarray {
	
	   public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {
	        ArrayList<Integer> result=new ArrayList<>();
	        PriorityQueue<pair> pq=new PriorityQueue<pair>();
	        
	        for(int i=0;i<input.size();i++){
	            pair p=new pair(i,0,input.get(i).get(0));
	            pq.add(p);
	        }
	        
	        while(!pq.isEmpty()){
	            pair p=pq.remove();
	            result.add(p.val);
	            p.di++;
	            
	            if(p.di<input.get(p.li).size()){
	                p.val=input.get(p.li).get(p.di);
	                pq.add(p);
	            }
	        }
	        return result;
		}
	
	public static void main(String[] args) {
		ArrayList<Integer> a1=new ArrayList<>();
		for(int i=10;i<=50;i+=10) {
			a1.add(i);
		}
		ArrayList<Integer> a2=new ArrayList<>();
		a2.add(5);
		a2.add(7);
		a2.add(9);
		a2.add(11);
		a2.add(19);
		a2.add(55);
		
		ArrayList<Integer> a3=new ArrayList<>();
		a3.add(1);
		a3.add(2);
		a3.add(3);
		
		ArrayList<ArrayList<Integer>> main=new ArrayList<>();
		main.add(a1);
		main.add(a2);
		main.add(a3);
		
		ArrayList<Integer> ans=new ArrayList<>();
		ans=mergeKSortedArrays(main);
		for(int i=0;i<ans.size();i++) {
			System.out.print(ans.get(i) + " ");
		}
	}

}

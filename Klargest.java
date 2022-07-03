package PQ;
import java.util.*;
public class Klargest {
	
	public static ArrayList<Integer> kLargest(int input[], int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
	    int i=0;
        for(i=0;i<k;i++){
          pq.add(input[i]);  
        }
        for(i=k;i<input.length;i++) {
          int minheap=pq.element();
          if(minheap<input[i]) {
        	  pq.remove();
        	  pq.add(input[i]);
          }
        }
        ArrayList<Integer> ans=new ArrayList<Integer>(); 
        while(!pq.isEmpty()) {
        	ans.add(pq.remove());
        }
        return ans;
	}
	
	public static ArrayList<Integer> kSmallest(int input[], int k){
		 PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder()); // maxPQ
		 int i=0;
	        for(i=0;i<k;i++){
	          pq.add(input[i]);  
	        }
	        for(i=k;i<input.length;i++) {
	            int maxheap=pq.element();
	            if(maxheap>input[i]) {
	          	  pq.remove();
	          	  pq.add(input[i]);
	            }
	        }
	        ArrayList<Integer> ans=new ArrayList<Integer>(); 
	        while(!pq.isEmpty()) {
	        	ans.add(pq.remove());
	        }
	        
	        return ans;
	       
	}
	

	public static void main(String[] args) {
		int a[]= {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};
		ArrayList<Integer> ans=kLargest(a, 4);
		for(int i=0;i<ans.size();i++) {
			System.out.print(ans.get(i) + " ");
		}

	}

}

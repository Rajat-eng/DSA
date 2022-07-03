package PQ;
import java.util.*;
// if a person has highest priority in front of queue then give ticket otherwsie place him at end of queue
// calculate total time till a person gets ticket
public class Ticket {

   public static int buyTicket(int input[], int k) {
	   int n=input.length;
	   int c=0;
	Queue<Integer> q=new LinkedList<Integer>();
	PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
	for(int i=0;i<n;i++) {
		pq.add(input[i]);
		q.add(i);
	}
	
	while(q.contains(k)) {
		if(input[q.peek()]==pq.peek()) {
			pq.remove();
			q.remove();
			c+=1;
		}else {
			int r=q.remove();
			q.add(r);
		}	
	}
	
	return c;
 }
	
   public static void main(String[] args) {
	   int[] arr= {2,3,2,2,4};
	   int ans=buyTicket(arr, 3);
	   System.out.println(ans);
	}

}

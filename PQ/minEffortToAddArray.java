package PQ;
import java.util.PriorityQueue;
//Effort in adding two numbers is equal to sum of both the numbers.
//We Have to find the minimum effort required to add all the numbers until only 1 number is remaining.
public class minEffortToAddArray {
	
	public static int mineffort(int []arr) {
		int mineffort=0;
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
		for(int i=0;i<arr.length;i++) {
			pq.add(arr[i]);
		}
		int e1=0;
		int e2=0;
		int cost=0;
		while(!pq.isEmpty()) {
			e1=pq.remove();
			if(pq.size()>=1) {
				e2=pq.remove();		
			}
			cost=e1+e2;	
			if(pq.size()!=0) {
				pq.add(cost);
			}
			mineffort+=cost;
		}
		return mineffort;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr= {4, 2, 7, 6, 9};
		System.out.println(mineffort(arr));
	}

}

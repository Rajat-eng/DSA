package PQ;
import java.util.*;
public class Ksort {
	
	public static void Ksortarray(int[] arr,int k) {  
//		O[nlogk]
		int i=0;	
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
		for(i=0;i<k;i++) {
			pq.add(arr[i]);
		}
		for(i=k;i<arr.length;i++) {
			arr[i-k]=pq.remove();
			pq.add(arr[i]);
		}	
		for(int j=k+1;j<arr.length;j++) {
			arr[j]=pq.remove();
		}
	}
	
	public static void main(String[] args) {
		int[] arr= {6, 5, 3, 2, 8, 10, 9};
		Ksortarray(arr, 3);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

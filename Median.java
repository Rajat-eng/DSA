package PQ;
import java.util.*;

public class Median {
	
	public static int [] findMedian(int arr[])  {
		int n=arr.length;
		int[] m=new int[n];
		PriorityQueue<Integer> lmax=new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> rmin=new PriorityQueue<Integer>();
		lmax.add(arr[0]);
		m[0]=arr[0];
		for(int i=1;i<n;i++) {
			if(arr[i]>lmax.peek()) {
				rmin.add(arr[i]);
			}
			else {
				lmax.add(arr[i]);
			}
			if(Math.abs(lmax.size()-rmin.size())>1){
				if(lmax.size()>rmin.size()) {
					int remove=lmax.remove();
					rmin.add(remove);
				}else {
					int remove=rmin.remove();
					lmax.add(remove);
				}
				m[i]=(lmax.peek() +rmin.peek())/2;
			}
			else if(lmax.size()-rmin.size()==1) {
				m[i]=lmax.peek();
			}else if(rmin.size()-lmax.size()==1) {
				m[i]=rmin.peek();
			}else { // equal size
				m[i]=(lmax.peek() +rmin.peek())/2;
			}
		}
		return m;
    }

	public static void main(String[] args) {
		int []arr= {6,2,1,3,7,5};
		int[] ans= findMedian(arr);
		for(int i=0;i<ans.length;i++) {
			System.out.print(ans[i] + " ");
		}
		
	}

}

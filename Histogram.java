package Stacks;

import java.util.Stack;

public class Histogram {
	
	public static int[] rightboundary(int [] arr) {
		int []rb=new int[arr.length];
		Stack<Integer> st=new Stack<Integer>();
		st.push(arr.length-1);
		rb[arr.length-1]=arr.length;
		for(int i=arr.length-2;i>=0;i--) {
			while ( st.size()!=0  &&  arr[i]<=arr[st.peek()] ) {  
				st.pop();
			}
			if(st.size()==0)
				rb[i]=arr.length;
			else
			rb[i]=st.peek();
			
			st.push(i);
			
		}
		return rb;	
	}
	
	public static int[] leftboundary(int [] arr) {
		int []lb=new int[arr.length];
		int n=arr.length;
		Stack<Integer> st=new Stack<Integer>();
		st.push(0);
		lb[0]=-1;
		for(int i=1;i<n;i++) {
			while ( st.size()!=0  &&  arr[i]<=arr[st.peek()] ) { 
				st.pop();
			}
			if(st.size()==0)
				lb[i]=-1;
			else
			lb[i]=st.peek();
			
			st.push(i);
			
		}
		return lb;	
	}
	
	public static int findingarea(int[] arr){
		int[] r=rightboundary(arr);
		for(int k:r) {
			System.out.print(k + " ");
		}
		System.out.println();
		int[] l=leftboundary(arr);
		for(int k:l) {
			System.out.print(k + " ");
		}
		int maxarea=0;
		for(int i=0;i<arr.length;i++) {
			int width=r[i]-l[i]-1;
			int area=width*arr[i];
			if(area>maxarea)
				maxarea=area;
		}
		return maxarea;
	}
	
	public static void main(String[] args) {
		int [] arr= {6,2,5,4,5,1,6};
		System.out.println(findingarea(arr));
	}

}

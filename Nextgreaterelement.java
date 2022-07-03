package Stacks;

import java.util.Stack;

public class Nextgreaterelement {
	
	public static int[] nge(int []arr) {
		int []nge=new int[arr.length];
		int n=arr.length;
		Stack<Integer> st=new Stack<Integer>();
		st.push(0);
		for(int i=1;i<n;i++) {
			while ( st.size()!=0  &&  arr[i]>=arr[st.peek()] ) {  // cant be converse otherwsie stackemptyexception
				int pos=st.peek();
				nge[pos]=arr[i];
				st.pop();
			}
			st.push(i);
		}
			
		while(!st.isEmpty()) {
			int pos=st.peek();
			nge[pos]=-1;
			st.pop();
			}
		return nge;	
	}
	
	public static int[] nse(int []arr) {
		int []nse=new int[arr.length];
		int n=arr.length;
		Stack<Integer> st=new Stack<Integer>();
		st.push(0);
		for(int i=1;i<n;i++) {
			while ( st.size()!=0  &&  arr[i]<=arr[st.peek()] ) {  // cant be converse otherwsie stackemptyexception
				int pos=st.peek();
				nse[pos]=arr[i];
				st.pop();
			}
			st.push(i);
		}
			
		while(!st.isEmpty()) {
			int pos=st.peek();
			nse[pos]=-1;
			st.pop();
			}
		return nse;	
		
	}
	
	public static void main(String[] args) {
		
		int []arr= {10,20,30,10,15,8,25,16,32,50,35,20,40};		
		int ansG[]=nge(arr);
		int ansS[]=nse(arr);
		 System.out.print("Larger:"+ " ");
        for(int i=0;i<ansG.length;i++) {
        	System.out.print(ansG[i] + " ");
        }
        System.out.println();
        System.out.print("Smaller:" + " ");
        for(int i=0;i<ansS.length;i++) {
        	System.out.print(ansS[i] + " ");
        }
		
	}

 }

package Stacks;

import java.util.Stack;

public class sliding {
	
	public static int[] nge(int []arr) {
		int []nge=new int[arr.length];
		int n=arr.length;
		Stack<Integer> st=new Stack<Integer>();
		st.push(0);
		for(int i=1;i<n;i++) {
			while ( st.size()!=0  &&  arr[i]>=arr[st.peek()] ) {  // cant be converse otherwise stackemptyexception
				int pos=st.peek();
				nge[pos]=i;  // nge contains index of nge element
				st.pop();
			}
			st.push(i);
		}
			
		while(!st.isEmpty()) {
			int pos=st.peek();
			nge[pos]=arr.length;
			st.pop();
			}
		return nge;	
	}
	
	public static void  windowmax(int arr[],int k) {
		int[] windowelement=nge(arr);
//		for(int i:windowelement) {
//			System.out.print(i+" ");
//		}
		int j=0;
		for(int i=0;i<arr.length-k;i++) {
			j=i;
			while(windowelement[j]<i+k) {
				j++;
			}
			System.out.print(arr[j] + " ");
		}
	}

	public static void main(String[] args) {
		int []arr= {10,20,30,10,15,8,25,16,32,50,35,20,40};		
		windowmax(arr, 4);
		
	   }
	}



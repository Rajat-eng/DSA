package Stacks;
import java.util.Stack;

public class Stock {
	
	public static int[] stockSpan(int[] price) {
		Stack<Integer> st=new Stack<Integer>();
		int [] span= new int[price.length];
		st.push(0);
		span[0]=1;
		for(int i=1;i<price.length;i++) {
			while ( st.size()!=0  &&  price[i]>price[st.peek()] ) {  // cant be converse otherwsie stackemptyexception
				st.pop();
			}
			if(st.size()==0) {
				span[i]=1+i;
			}
			else {
				span[i]=i-st.peek();
			}
			st.push(i);
		}				
		return span;
	}

	public static void main(String[] args) {
		int [] arr= {10,20,30,10,25,15,8,18,50,35,40,25,30};
		int ans[]=stockSpan(arr);
        for(int i=0;i<ans.length;i++) {
        	System.out.print(ans[i] + " ");
        }
	}

}

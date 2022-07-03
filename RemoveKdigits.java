package Stacks;
import java.util.*;
public class RemoveKdigits {
	public static String remove(String s,int k) {
//		return smallest number after removing k digits
		Stack<Character> st=new Stack<Character>();
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
//			if next char is smaller it will give minimum number after removal
//			if char is equal then push in stack
			while(st.size()!=0 && k>0 && st.peek()>ch) {  
				st.pop();
				k--;
			}
			st.push(ch);	  // string in ascending order 
		}
		while(k>0) {  
			// 12345-- removal of last characters
			st.pop();
			k--;	
		}
		char ans[]=new char[st.size()];
		for(int i=ans.length-1;i>=0;i--) {
			ans[i]=st.pop();
//			System.out.print(ans[i] + " ");
		}
		int d=0;  
		// case when initial char is 0 eg 200110-->> ans should be 110 after 3 digit removal
		while(d<ans.length && ans[d]=='0') {
//			iterated over initial 0
			d++;
		}
		StringBuilder sb=new StringBuilder();
		while(d<ans.length) {  
			// i
			sb.append(ans[d]);
			d++;
		}
		if(sb.length()==0)  
			// 000
			sb.append('0');
		return sb.toString();
	}
	
	public static void main(String[] args) {
	    String s="1001401";
	    
	    System.out.println("Ans:" + remove(s, 3));
	}

}

package Stacks;

import java.util.Stack;

public class reversebracket {
	
	public static  int countBracketReversals(String input) {
		Stack<Character> st=new Stack<>();
		int n=input.length();
		int count=0;
		if(n%2!=0)
			return -1;
		
		for(int i=0;i<n;i++) {
			char ch=input.charAt(i);
			if(ch=='{') {
				st.push(ch);
			}	else {
				if(st.size()==0) {
					st.push(ch);
				}
				else if(st.peek()!='{') {
					st.push(ch);
				}		
				else {
					st.pop();
				}				
			}
		}
		while(!st.isEmpty() ) {
			char ch1=st.peek();
			st.pop();
			char ch2=st.peek();
			if(ch1!=ch2) {
				count+=2;
			}	
			else {
				count+=1;
			}
			st.pop();	
		}
		
		return count;
	}

	public static void main(String[] args) {
		String s="{{}{{}}}}{{}";
		System.out.println(countBracketReversals(s));
	}

}

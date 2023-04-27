package Stacks;
import java.util.Stack;

public class redundant {
	
	public static boolean checkRedundantBrackets(String expression) {
		int n=expression.length();
		Stack<Character> st=new Stack<Character>();
		int i=0,count=0;
		for(i=0;i<n;i++) {
			char ch=expression.charAt(i);
			if(ch==')') {  
				while(st.peek()!='(') {
					st.pop();	
					count++;
				}
				if(count==1 || count==0)  //(a) or ()
					return true;
				else {
					st.pop();  // last open bracket and count=0
					count=0;
				}	
			 }
			else {
				st.push(ch);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String s="(x+y*(a-b))";
		String y="(a)";
		String x="a+(b)";
		boolean ans=checkRedundantBrackets(s);
		System.out.println(ans);
	}

}

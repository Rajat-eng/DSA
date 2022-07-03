package Queue;
import java.util.*;

public class Reversestring {
	
	public static String reverse(String s) {
		Stack<Character> st=new Stack<Character>();
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(ch==')') {
				Queue<Character> q=new LinkedList<Character>();
				while(st.size()!=0 && st.peek()!='(') {
					q.add(st.pop());
					}
				st.pop();
				while(q.size()!=0) {
					st.push(q.remove());
				}
			}else {
				st.push(ch);
			}
		}
		char[] c=new char[st.size()];
		for(int i=c.length-1;i>=0;i--) {
			c[i]=st.pop();
		}
		return new String(c);
	}
	public static void main(String[] args) {
		String s="(abcd)";
		System.out.println(reverse(s));
	}

}

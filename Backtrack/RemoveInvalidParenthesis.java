package BACKTRACK;
import java.util.*;
public class RemoveInvalidParenthesis {
	
	private static int getMin(String str) {
		Stack<Character> st=new Stack<Character>();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(ch=='(') {
				st.push(ch);
			}else if(ch==')') {
				if(st.size()==0) {
					st.push(ch);
				}else if(st.peek()==')'){
					st.push(ch);
				}else if(st.peek()=='(') {
					st.pop();
				}
			}
		}
		return st.size();
	}
	
	private static void solution(String str, int removal, HashMap<String,Boolean> map,ArrayList<String> ans) {
		if(removal==0) {
			int removalnow=getMin(str);
			if(removalnow==0) {
				ans.add(str);
			}
			return;
		}
		for(int i=0;i<str.length();i++) {
			String left=str.substring(0,i);
			String right=str.substring(i+1);
			if(!map.containsKey(left+right)) {
				map.put(left+right, true);
				solution(left+right,removal-1,map,ans);
			}	
		}	
	}
	

	public static void main(String[] args) {
		String str= ")()((x())";
		int removal=getMin(str);
		ArrayList<String> ans=new ArrayList<String>();
		HashMap <String,Boolean> map=new HashMap<>();
		solution(str,removal,map,ans);
		for(String s:ans) {
			System.out.println(s);
		}
	}

	

	

	
	

}

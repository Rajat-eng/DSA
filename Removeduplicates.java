package Stacks;
import java.util.*;
// maiintain dictionery order
public class Removeduplicates {
	
	public static String remove(String s) {
		HashMap<Character,Integer> map=new HashMap<Character, Integer>();
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(map.containsKey(ch)) {
				int f=map.get(ch);
				f++;
				map.put(ch, f);
			}else {
				map.put(ch, 1);
			}
		}
		boolean exist[]=new boolean[26];
		Stack<Character> st=new Stack<Character>();
		for(int i=0;i<s.length();i++) {
			
			char ch=s.charAt(i);
			int f=map.get(ch);
			f=f-1;
			map.put(ch, f);
			if(exist[ch-'a']==true) continue;
			
			while( st.size()!=0  && st.peek()>ch && map.get(st.peek())>0 ) {
            //  pop when incoming is lower and peek element has frequency greater than zero
				char rem=st.pop();
				exist[rem-'a']=false;
			}
			st.push(ch);
			exist[ch-'a']=true;
		}
		
		StringBuilder str=new StringBuilder();
		while(!st.isEmpty()) {
			str.append(st.pop());
		}
		return str.reverse().toString();
	}

	public static void main(String[] args) {
		String s="cbeacdcbc";
		System.out.println(remove(s));

	}

}

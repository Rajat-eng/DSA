package HashMap;
// each char in s should be mapped to only one specific in t
import java.util.*;
public class IsomorphicStrings {
	
	private static boolean solve(String s, String t) {
		if(s.length()!=t.length()) {
			return false;
		}
		HashMap<Character,Character> map1=new HashMap<Character,Character>();
		HashMap<Character,Boolean> used=new HashMap<Character, Boolean>();
		for(int i=0;i<s.length();i++) {
			char ch1=s.charAt(i);
			char ch2=t.charAt(i);
			if(map1.containsKey(ch1)) {
				if(map1.get(ch1)!=ch2) {
//					if a is mapped to another char other than x
					return false;
				}
			}else {
				if(used.containsKey(ch2)) {
//					if a is not used and x is already mapped 
					return false;
				}
				map1.put(ch1,ch2);
				used.put(ch2, true);
			}

		}
		return true;
	}

	public static void main(String[] args) {
		String s="abacba";
//		a->x  b->y  c->z
		String t="xyxzyx";
		System.out.println(solve(s,t));
	}

}

package HashMap;
import java.util.*;
public class KAnagram {
	
	private static boolean solve(String s1, String s2,int k) {
		HashMap<Character,Integer> map=new HashMap<>();
		for(int i=0;i<s1.length();i++) {
			char ch=s1.charAt(i);
			map.put(ch,map.getOrDefault(ch, 0)+1);
		}
		for(int i=0;i<s2.length();i++) {
			char ch=s2.charAt(i);
			if(map.getOrDefault(ch, 0)>0) {
				map.put(ch, map.get(ch)-1);
			}
		}
//		map is left with only +ve freq which will cancel out -ve freq
		int count=0;
		for(char ch:map.keySet()) {
			count+=map.get(ch);
		}
		if(count<k) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		String s1="ababaddccc";
		String s2="bcbecabacd";
		int k=3;
		System.out.println(solve(s1,s2,k));
	}

}

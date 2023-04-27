package HashMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
// anagram is string of same size with same characters 
public class PrintAnagrams {

	public static void main(String[] args) {
		String source="abcabaccba";
		String pattern="aabc";
		solve(source,pattern);
	}

	private static void solve(String source, String pattern) {
		HashMap<Character,Integer> smap=new HashMap<Character, Integer>();
		HashMap<Character,Integer> pmap=new HashMap<Character, Integer>();
		
		for(int i=0;i<pattern.length();i++) {
			char ch=source.charAt(i);
			smap.put(ch, smap.getOrDefault(ch, 0)+1);
		}
		
		for(int i=0;i<pattern.length();i++) {
			char ch=pattern.charAt(i);
			pmap.put(ch, pmap.getOrDefault(ch, 0)+1);
		}
		
		Set<String> set=new HashSet<>();
		int i=pattern.length();
		
		while(i<source.length()) {
			if(compare(smap,pmap)) {
				String str=source.substring(i-pattern.length(),i);
				set.add(str);
			}
//			cha is acquired 
			char cha=source.charAt(i);
			smap.put(cha,smap.getOrDefault(cha,0)+1);
			
//			chr is released char at starting point of window
			char chr=source.charAt(i-pattern.length());
			
			if(smap.get(chr)==1) {
				smap.remove(chr);
			}else {
				smap.put(chr,smap.get(chr)-1);
			}
			i++;
		}
//		it is a chance that last window may be anagram but not compared in while loop bcoz i=s.length
		if(compare(smap,pmap)) {
			String str=source.substring(i-pattern.length(),i);
			set.add(str);
		}
		
		System.out.println(set);
	}
	
	
	

	private static boolean compare(HashMap<Character, Integer> smap, HashMap<Character, Integer> pmap) {
		for(char ch:smap.keySet()) {
			if( pmap.getOrDefault(ch,0) !=smap.get(ch) )
					return false;
		}
		return true;
	}

}

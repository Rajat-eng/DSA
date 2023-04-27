package BACKTRACK;
import java.util.*;
public class wordPatternMatching {
	
	private static void solution(String str, String pattern, HashMap<Character, String> map, String originalpattern) {
		
		if(pattern.length()==0) {
			if(str.length()==0) {
				HashSet<Character> alreadyPrinted= new HashSet<>();
				for(int i=0;i<originalpattern.length();i++) {
					char ch=originalpattern.charAt(i);
					if(alreadyPrinted.contains(ch)==false) {
						System.out.print(ch + "-->" + map.get(ch) + ",");
						alreadyPrinted.add(ch);
					}
				}
			}
			return;
		}
		
		char ch=pattern.charAt(0);
		String rest=pattern.substring(1);
		if(map.containsKey(ch)) {
			String previousMapping=map.get(ch);
			if(str.length()>=previousMapping.length()) {
				String prefix=str.substring(0,previousMapping.length());
				String left=str.substring(previousMapping.length());
				if(previousMapping.equals(prefix)) {
					solution(left,rest,map,originalpattern);
				}
			}
		}else {
			for(int i=0;i<str.length();i++) {
				String prefix=str.substring(0,i+1);
				String left=str.substring(i+1);
				map.put(ch, prefix);
				solution(left,pattern,map,originalpattern);
				map.remove(ch);
			}
		}		
	}

	public static void main(String[] args) {
		String str="graphtreegraph";
		String pattern="pep";
		HashMap <Character,String> map=new HashMap<Character, String>();
		solution(str,pattern,map,pattern);
	}
}

package HashMap;
import java.util.*;
// find min window which contains all the unique characters
public class MinWindowSubstring {
	private static void solve(String s) {
		int length=s.length();
		HashSet<Character> set=new HashSet<Character>();
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			set.add(ch);
		}
		HashMap<Character,Integer> map=new HashMap<>();
		int i=-1,j=-1;
		while(true) {
			boolean f1=false;
			boolean f2=false;
//			acquire charc til map.size=set.size
			while(i<s.length()-1 && map.size()<set.size()) {
				i++;
				char ch=s.charAt(i);
				map.put(ch, map.getOrDefault(ch, 0)+1);
				f1=true;
			}
			while(j<i && map.size()==set.size()) {
				int potentiallength= i-j;
				if(potentiallength<length) {
					length=potentiallength;
				}
				j++;
				char ch=s.charAt(j);
				if(map.get(ch)==1) {
					map.remove(ch);
				}else {
					map.put(ch,map.get(ch)-1);
				}
				f2=true;
				
			}
			if(!f1&&!f2) {
				break;
			}
		}
		System.out.println(length);
	}

	public static void main(String[] args) {
		String s="bbacacdcbbcaadcdca";
		solve(s);	
	}
}
